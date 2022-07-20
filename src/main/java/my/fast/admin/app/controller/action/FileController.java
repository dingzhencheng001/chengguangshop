package my.fast.admin.app.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import my.fast.admin.app.common.constant.CommonResult;
import my.fast.admin.app.entity.FileInfo;
import my.fast.admin.app.service.FileService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 15:09
 */
@RestController
@RequestMapping(value = "/file")
@Api(tags = "FileController", description = "文件上传下载")
public class FileController {

    @Autowired
    FileService fileService;

    /**
     * 批量上传
     * @param files
     * @return
     */
    @PostMapping(value = "/upload")
    public CommonResult upload(@RequestParam("file") MultipartFile[] files){
        List<FileInfo> fileInfos = fileService.uploadFile(files);
        return CommonResult.success(fileInfos);
    }

    /**
     * 文件预览
     */
    @GetMapping(value = "/preview/{fileId}")
    public ResponseEntity<Resource> preview(@PathVariable String fileId, HttpServletRequest request){
        return fileService.preview(fileId,request);
    }


    /**
     * 文件删除
     * @param fileId
     * @return
     */
    @PostMapping(value = "/del")
    public CommonResult delFile(@PathVariable String fileId){
        int count = fileService.delFile(fileId);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}
