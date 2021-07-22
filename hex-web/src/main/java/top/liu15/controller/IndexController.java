package top.liu15.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.liu15.ClassFileInfo;
import top.liu15.result.Result;
import top.liu15.result.ResultCode;

import java.io.IOException;

/**
 * @author lhy
 * @version 1.0
 * @date 2021/7/22 11:07
 */
@RestController
@RequiredArgsConstructor
public class IndexController {

    /**
     * 解析文件
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/parsing")
    public Result parsClassFile(MultipartFile file) throws IOException {
        if (null == file || file.isEmpty()) {
            return Result.failure(ResultCode.FAILURE_UPLOAD);
        }
        return Result.success(new ClassFileInfo(file.getInputStream()));
    }

}
