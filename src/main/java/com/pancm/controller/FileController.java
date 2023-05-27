package com.pancm.controller;

import com.pancm.model.RespBody;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

@RestController
@RequestMapping("/file")
@Api(value = "文件controller", tags = {"文件管理接口"})
@ApiIgnore
public class FileController {

    //    private final static String Address = "/home/huangxiaojie/huangxiaojie/huangxiaojie/opencv_demo/src/scripts/drone_demo.py";
    private final static String Address = "/home/huangxiaojie/huangxiaojie/huangxiaojie/opencv_demo/src/scripts/test.py";
//    private final static String Address = "H:\\桌面\\test.py";

    @PostMapping("/change")
    public RespBody<Void> changeFile(MultipartFile file) {

        try {
            InputStream input = file.getInputStream();
            OutputStream outputStream = new FileOutputStream(Address);
            byte[] b = new byte[4096];
            int count = input.read(b);
            while (count != -1) {
                for (int i = 0; i < count; i++) {
                    outputStream.write(b[i]);
                }
                count = input.read(b);
            }

            //文件加权
            Path path = Paths.get(Address);
            Set<PosixFilePermission> perms = Files.readAttributes(path, PosixFileAttributes.class).permissions();
            perms.add(PosixFilePermission.OWNER_READ);
            perms.add(PosixFilePermission.OWNER_WRITE);
            perms.add(PosixFilePermission.OWNER_EXECUTE);//rwx

            perms.add(PosixFilePermission.GROUP_READ);
            perms.add(PosixFilePermission.GROUP_EXECUTE);//r-x

            perms.add(PosixFilePermission.OTHERS_READ);
            perms.add(PosixFilePermission.OTHERS_EXECUTE);//r-x
            Files.setPosixFilePermissions(path, perms);

            input.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return RespBody.fail("上传失败");
        }

        return RespBody.ok();
    }

}
