package my.fast.admin.app.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


import my.fast.admin.app.entity.FileInfo;


public interface FileService {
    /**
     * 批量上传文件
     */
    List<FileInfo> uploadFile(MultipartFile[] file);

    /**
     * 文件预览
     */
    ResponseEntity<Resource> preview(String fileId, HttpServletRequest request);

    /**
     * 文件删除
     */
    int delFile(String fileId);
}
