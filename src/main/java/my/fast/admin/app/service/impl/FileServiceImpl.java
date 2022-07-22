package my.fast.admin.app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;

import my.fast.admin.app.common.constant.S3Constant;
import my.fast.admin.app.config.AwsProperties;
import my.fast.admin.app.entity.AppPicture;
import my.fast.admin.app.entity.FileInfo;
import my.fast.admin.app.mapper.AppPictureMapper;
import my.fast.admin.app.service.FileService;
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
    private AppPictureMapper appPictureMapper;

    @Override
    public List<FileInfo> uploadFile(MultipartFile[] files) {
        //创建返回对象
        List<FileInfo> fileInfos = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                FileInfo fileInfo = new FileInfo();
                fileInfo.setName(file.getOriginalFilename());
                fileInfo.setSize(file.getSize());
                String id = UUID.randomUUID()
                    .toString();
                fileInfo.setId(id);
                fileInfo.setPath(getKey(fileInfo));
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentLength(file.getSize());
                objectMetadata.setContentType(file.getContentType());
                try {
                    amazonS3.putObject(awsProperties.getBucketName(),fileInfo.getName(),file.getInputStream(),objectMetadata);
                    //存储数据库
                    AppPicture appPicture = new AppPicture();
                    appPicture.setPictureId(fileInfo.getId());
                    appPicture.setPicturePath(fileInfo.getPath());
                    appPicture.setPictureName(fileInfo.getName());
                    appPicture.setUpdateTime(DateFormat.getNowDate());
                    appPictureMapper.insertSelective(appPicture);
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
        return "/" + S3Constant.FILEPATH + "/" + fileInfo.getId() + "/" + fileInfo.getName();
    }

}
