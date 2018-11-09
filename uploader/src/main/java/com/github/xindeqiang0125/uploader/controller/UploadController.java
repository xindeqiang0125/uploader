package com.github.xindeqiang0125.uploader.controller;

import com.github.xindeqiang0125.uploader.ResultData;
import com.github.xindeqiang0125.uploader.UploaderProperties;
import com.github.xindeqiang0125.uploader.path.FileSavePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UploadController {
    @Autowired
    private UploaderProperties properties;

    @Autowired
    private FileSavePath fileSavePath;

    @RequestMapping("/upload/{fileType}")
    public ResultData upload(MultipartFile[] file, @PathVariable Integer fileType) {
        try {
            checkParams(file, fileType);
            List<String> urls = new ArrayList<>(file.length);
            String fullPath = fileSavePath.fullPath(fileType);
            String relativePath = fileSavePath.relativePath();
            checkPath(fullPath);
            for (MultipartFile mf : file) {
                String newName = saveFile(fullPath, mf);
                urls.add(relativePath + "/" + newName);
            }
            return ResultData.success(urls.toArray(new String[0]));
        } catch (Exception e) {
            return ResultData.failure(e.getMessage());
        }

    }

    private void checkParams(MultipartFile[] file, Integer fileType) {
        if (file == null || file.length == 0) throw new RuntimeException("未选择上传文件");
        if (fileType <= 0 || fileType > 3) throw new RuntimeException("文件类型参数错误");
    }

    private String saveFile(String fullPath, MultipartFile mf) throws IOException {
        String filename = mf.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        String newName = UUID.randomUUID() + suffix;
        File dest = new File(fullPath + "/" + newName);
        mf.transferTo(dest);
        return newName;
    }

    private void checkPath(String pathStr) {
        File path = new File(pathStr);
        if (!path.exists()) {
            path.mkdirs();
        }
    }
}
