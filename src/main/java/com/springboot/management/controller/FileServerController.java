package com.springboot.management.controller;
/*
 *@Author 李恒彪
 * @date 2020/06/18
 *完成头像上传
 */



import com.springboot.management.vo.FileSystem;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin//允许跨域
@RestController
@RequestMapping("/filesystem")
public class FileServerController {

    private String upload_location="D:\\";

    @PostMapping("/upload")
    @ResponseBody
    public FileSystem upload(@RequestParam("file") MultipartFile file) throws IOException {
        //将文件先存储在web服务器上（本机），再调用fastDFS的client将文件上传到 fastDSF服务器
        FileSystem fileSystem = new FileSystem();
        //得到 文件的原始名称
        String originalFilename = file.getOriginalFilename();
        //扩展名
        String extention = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileNameNew = UUID.randomUUID()+extention;
        //定义file，使用file存储上传的文件
        File file1 = new File(upload_location+fileNameNew);
        file.transferTo(file1);
        //获取新上传文件的物理路径
        String newFilePath = file1.getAbsolutePath();
        try {
            //加载fastDFS客户端的配置 文件
            ClientGlobal.initByProperties("fastdfs-client.properties");
            System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
            System.out.println("charset=" + ClientGlobal.g_charset);

            //创建tracker的客户端
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            //定义storage的客户端
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);
            //文件元信息
            NameValuePair[] metaList = new NameValuePair[1];
            metaList[0] = new NameValuePair("fileName", originalFilename);
            //执行上传，将上传成功的存放在web服务器（本机）上的文件上传到 fastDFS
            String fileId = client.upload_file1(newFilePath,null, metaList);
            System.out.println("upload success. file id is: " + fileId);
            fileSystem.setFileId(fileId);
            fileSystem.setFilePath(fileId);
            fileSystem.setFileName(originalFilename);




            //关闭trackerServer的连接
            trackerServer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return fileSystem;
    }

}
