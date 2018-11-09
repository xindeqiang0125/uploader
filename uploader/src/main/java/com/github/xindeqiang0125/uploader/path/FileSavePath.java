package com.github.xindeqiang0125.uploader.path;

public interface FileSavePath {
    String fullPath(int type);

    String relativePath();
}
