package my.fast.admin.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import my.fast.admin.app.entity.FileInfo;


public interface FileService {
    /**
     * 批量上传文件
     */
    List<FileInfo> uploadFile(MultipartFile[] file) throws Exception;

}
