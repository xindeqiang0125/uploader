package com.github.xindeqiang0125.uploader;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class EnableUploaderImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        String[] strings = {"com.github.xindeqiang0125.uploader.UploaderConfiguration"};
        return strings;
    }
}
