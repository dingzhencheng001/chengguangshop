package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import my.fast.admin.cg.entity.FileInfo;


public interface FileService {
    /**
     * 批量上传文件
     */
    List<FileInfo> uploadFile(MultipartFile[] file) throws Exception;

}
