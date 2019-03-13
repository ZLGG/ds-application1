package com.zlg.bs.util;

import com.zlg.bs.center.user.vo.ResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {

    @RequestMapping("/upload")
    @ResponseBody
    public ResponseDto uploadFile(MultipartFile file) {
        //判断文件是否为空
        if (file.isEmpty()) {
            return new ResponseDto("ERROR", "文件为空");
        }

        String fileName = file.getOriginalFilename();

        int unixSep = fileName.lastIndexOf('/');
        // Check for Windows-style path
        int winSep = fileName.lastIndexOf('\\');
        // Cut off at latest possible point
        int pos = (winSep > unixSep ? winSep : unixSep);
        if (pos != -1)  {
            // Any sort of path separator found...
            fileName = fileName.substring(pos + 1);
        }

        //加个时间戳，尽量避免文件名称重复
        String path = "D:/image/" + 1 + "_" + fileName;
        File dest = new File(path);
/*
        new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
*/
        //判断文件是否已经存在
        if (dest.exists()) {
            /*return "-2";*/
            return new ResponseDto("ERROR", "文件已经存在");
        }

        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest); //保存文件
        } catch (IOException e) {
            e.printStackTrace();
            /*return "-3";*/
        }

        /*return "0";*/
        return new ResponseDto(fileName);
    }
}
