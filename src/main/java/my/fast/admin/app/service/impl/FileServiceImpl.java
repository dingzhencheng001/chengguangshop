package my.fast.admin.app.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;


import my.fast.admin.app.common.constant.Constant;
import my.fast.admin.app.common.utils.S3Utils;
import my.fast.admin.app.config.AwsProperties;
import my.fast.admin.app.entity.FileInfo;
import my.fast.admin.app.service.FileService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/19 12:09
 */
@Service
public class FileServiceImpl implements FileService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AwsProperties awsProperties;

    @Autowired
    AmazonS3 amazonS3;

    // 这里模拟一下存储
    Map<String,FileInfo> map = new HashMap<>();

    @Override
    public List<FileInfo> uploadFile(MultipartFile[] files){
        List<FileInfo> fileInfos = new ArrayList<>();
        for(MultipartFile file : files){
            if(!file.isEmpty()){
                FileInfo fileInfo = new FileInfo();
                fileInfo.setName(file.getOriginalFilename());
                fileInfo.setSize(file.getSize());
                String id = UUID.randomUUID().toString();
                fileInfo.setId(id);
                fileInfo.setPath(getKey(fileInfo));
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentLength(file.getSize());
                objectMetadata.setContentType(file.getContentType());
                try {
                    amazonS3.putObject(awsProperties.getBucketName(),getKey(fileInfo),file.getInputStream(),objectMetadata);
                    //存储数据库
                    map.put(id,fileInfo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                fileInfos.add(fileInfo);
            }
        }
        return fileInfos;
    }

    @Override
    public ResponseEntity<Resource> preview(String fileId, HttpServletRequest request) {
        FileInfo fileInfo = map.get(fileId);
        if(fileInfo != null){
            S3Object s3Object = amazonS3.getObject(awsProperties.getBucketName(), getKey(fileInfo));
            InputStream inputStream = s3Object.getObjectContent();
            String fileName = null;
            try {
                fileName = getDownloadFileName(request, fileInfo.getName());
            } catch (UnsupportedEncodingException e) {
                logger.error("数据预览异常：文件名编码错误", e);
            }
            HttpHeaders headers = new HttpHeaders();
            headers.add("charset", "utf-8");
            headers.add("Content-Disposition", "inline;filename=\"" + fileName + "\"");
            Resource resource = new InputStreamResource(inputStream);
            return ResponseEntity.ok().headers(headers).contentType(MediaType.valueOf(S3Utils.getContentType(S3Utils.getFileType(fileInfo.getName())))).body(resource);
        }else {
            logger.warn("没有找到要预览的文件！ 文件id： " + fileId);
        }
      return null;
    }

    @Override
    public int delFile(String fileId) {
        amazonS3.deleteObject(awsProperties.getBucketName(),fileId);
        return 1;
    }

    /**
     * 文件存放目录
     * @return
     */
    private String getKey(FileInfo fileInfo){
        return "/"+ Constant.FILEPATH+"/"+ fileInfo.getId()+"/"+fileInfo.getName();
    }

    /**
     * 判断是否是ie
     * @return
     */
    private boolean isIE(String userAgent){
        if(userAgent != null){
            userAgent = userAgent.toLowerCase();
            return userAgent.contains("msie") ||
                    userAgent.contains("trident") ||
                    userAgent.contains("edge");
        }
        return false;
    }

    private String getDownloadFileName(HttpServletRequest request, String fileName) throws UnsupportedEncodingException {
        if (isIE(request.getHeader("user-agent"))) {
            return URLEncoder.encode(fileName, "UTF-8");
        } else {
            return new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        }
    }


}
