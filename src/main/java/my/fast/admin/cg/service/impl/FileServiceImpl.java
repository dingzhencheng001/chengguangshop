package my.fast.admin.cg.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

import my.fast.admin.cg.common.constant.S3Constant;
import my.fast.admin.cg.config.AwsProperties;
import my.fast.admin.cg.entity.AppFile;
import my.fast.admin.cg.entity.FileInfo;
import my.fast.admin.cg.mapper.AppFileMapper;
import my.fast.admin.cg.service.FileService;
import my.fast.admin.framework.utils.DateFormat;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/19 12:09
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private AwsProperties awsProperties;

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private AppFileMapper appFileMapper;

    @Override
    public List<FileInfo> uploadFile(MultipartFile[] files) {
        //创建返回对象
        List<FileInfo> fileInfos = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                FileInfo fileInfo = new FileInfo();
                fileInfo.setName(file.getOriginalFilename());
                fileInfo.setSize(file.getSize());
                String[] split = file.getOriginalFilename()
                    .split("\\.");
                fileInfo.setFileFormat(split[1]);
                String id = UUID.randomUUID()
                    .toString();
                fileInfo.setId(id);
                fileInfo.setPath(getKey(fileInfo));
                fileInfo.setName(id+"."+split[1]);
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentLength(file.getSize());
                objectMetadata.setContentType(file.getContentType());
                try {
                    amazonS3.putObject(awsProperties.getBucketName(),getKey(fileInfo),file.getInputStream(),objectMetadata);
                    //存储数据库
                    AppFile appFile = new AppFile();
                    appFile.setId(fileInfo.getId());
                    appFile.setFilePath(fileInfo.getPath());
                    appFile.setFileName(fileInfo.getName());
                    appFile.setFileFormat(fileInfo.getFileFormat());
                    appFile.setUploadTime(DateFormat.getNowDate());
                    appFileMapper.insertSelective(appFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                fileInfos.add(fileInfo);
            }
        }
        return fileInfos;
    }

    /**
     * 文件存放目录
     *
     * @return
     */
    private String getKey(FileInfo fileInfo) {
        return  S3Constant.FILEPATH + "/" + fileInfo.getName();
    }

}
