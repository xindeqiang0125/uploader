package com.github.xindeqiang0125.uploader;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({EnableUploaderImportSelector.class})
public @interface EnableUploader {
}
