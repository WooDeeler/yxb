package com.kongke.trigger.http;

import cn.hutool.core.util.StrUtil;
import com.aliyun.oss.model.OSSObject;
import com.kongke.domain.univ.model.dto.FileDownloadReq;
import com.kongke.domain.univ.utils.FileUtil;
import com.kongke.types.common.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;


/**
 * oss接口
 *
 * @author kongke
 * @date 2025/05/09
 */
@RequestMapping("/oss")
@RestController
public class OSSController {


    /**
     * 上传文件
     *
     * @param file 文件
     * @return {@link Result }<{@link String }>
     */
    @PostMapping("/upload")
    public Result<String> uploadFile(MultipartFile file) throws IOException {
        if (file == null)
            return Result.failed(2, "参数错误");
        String url = FileUtil.uploadFile(file.getInputStream(), "yxb/"+file.getOriginalFilename());
        return Result.success(url);
    }

    /**
     * 下载文件
     *
     * @param fileName filename
     * @return {@link Result }<{@link Boolean }>
     */
    @GetMapping("/download")
    public void downloadFile(String fileName, HttpServletResponse response){
        if (StrUtil.isBlank(fileName)) {
            return;
        }
        FileUtil.downloadFile("yxb/"+fileName, response);
    }

}
