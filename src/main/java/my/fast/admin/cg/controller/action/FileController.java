package my.fast.admin.cg.controller.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.FileInfo;
import my.fast.admin.cg.service.FileService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 15:09
 */
@RestController
@RequestMapping(value = "/action/file")
@Api(tags = "FileController", description = "文件上传")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 批量上传
     * @param files
     * @return
     */
    @PostMapping(value = "/upload")
    public CommonResult upload(@RequestParam("file") MultipartFile[] files) throws Exception {
        List<FileInfo> fileInfos = fileService.uploadFile(files);
        return CommonResult.success(fileInfos);
    }

}
