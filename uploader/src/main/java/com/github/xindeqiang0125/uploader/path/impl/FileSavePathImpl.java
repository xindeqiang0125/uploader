package com.github.xindeqiang0125.uploader.path.impl;

import com.github.xindeqiang0125.uploader.UploaderProperties;
import com.github.xindeqiang0125.uploader.path.ChildPath;
import com.github.xindeqiang0125.uploader.path.FileSavePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileSavePathImpl implements FileSavePath {
    @Autowired
    private UploaderProperties uploaderProperties;

    @Autowired
    private ChildPath childPath;

    @Override
    public String fullPath(int type) {
        return rootPath(type) + childPath();
    }

    @Override
    public String relativePath() {
        return childPath();
    }

    private String childPath() {
        return childPath.getChildPath();
    }

    private String rootPath(int type) {
        switch (type) {
            case 1:
                return uploaderProperties.getCommonFilePath();
            case 2:
                return uploaderProperties.getImagePath();
            case 3:
                return uploaderProperties.getAttachmentPath();
            default:
                return "";
        }
    }


}
