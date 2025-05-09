package com.kongke.domain.univ.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.DownloadFileRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class FileUtil {

    // 阿里云OSS配置
    private static final String ENDPOINT = "https://oss-cn-hangzhou.aliyuncs.com";
    private static final String ACCESS_KEY_ID = "LTAI5tMVrC1Yjnxi7cWgifqe";
    private static final String ACCESS_KEY_SECRET = "4Pwifa6rEWwF4qmEABW5FHMsTjL01w";
    private static final String BUCKET_NAME = "pic-buc";

    public static OSS BuildOssClient(){
        return new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    }

    public static String getBucketName() {
        return BUCKET_NAME;
    }

    /**
     * 上传文件到OSS
     * @param file 要上传的文件
     * @param objectName OSS中存储的文件名(可以包含路径)
     * @return 文件的访问URL
     */
    public static String uploadFile(InputStream file, String objectName) {
        OSS ossClient = BuildOssClient();
        try {
            // 创建PutObjectRequest对象
            PutObjectRequest putObjectRequest = new PutObjectRequest(getBucketName(), objectName, file);

            // 上传文件
            ossClient.putObject(putObjectRequest);

            // 返回文件的访问URL
            return generateFileUrl(objectName);
        } finally {
            ossClient.shutdown();
        }
    }

    /**
     * 生成文件的访问URL
     * @param objectName OSS中存储的文件名
     * @return 文件的访问URL
     */
    private static String generateFileUrl(String objectName) {
        // 简单起见，这里直接拼接URL，实际生产环境可能需要考虑签名等问题
        return "https://" + getBucketName() + "." + ENDPOINT.replace("https://", "") + "/" + objectName;
    }


    /**
     * 从OSS下载文件到本地
     * @param objectName OSS中存储的文件名
     * @param response 输出流
     * @return 是否下载成功
     */
    public static boolean downloadFile(String objectName, HttpServletResponse response) {
        OSS ossClient = BuildOssClient();
        try {
            // 获取OSS文件对象
            OSSObject ossObject = ossClient.getObject(getBucketName(), objectName);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(objectName, "UTF-8"));
            // 写入本地文件
            try (InputStream inputStream = ossObject.getObjectContent();
                 OutputStream outputStream = response.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                outputStream.flush();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ossClient.shutdown();
        }
    }


}
