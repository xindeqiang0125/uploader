package com.github.xindeqiang0125.uploader;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@ComponentScan("com.github.xindeqiang0125.uploader")
@EnableConfigurationProperties({UploaderProperties.class})
public class UploaderConfiguration {

}
