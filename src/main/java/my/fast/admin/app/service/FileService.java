package my.fast.admin.app.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


import my.fast.admin.app.entity.FileInfo;

/**
 * @author lihaijian
 */
public interface FileService {
    /**
     * 批量上传文件
     * @param file
     * @return
     */
    List<FileInfo> uploadFile(MultipartFile[] file);

    /**
     * 文件预览
     * @param fileId
     * @param request
     * @return
     */
    ResponseEntity<Resource> preview(String fileId, HttpServletRequest request);

    /**
     * 文件预览
     * @param request
     * @param fileId
     * @return
     */
    int delFile(String fileId);
}
