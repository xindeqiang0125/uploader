package com.github.xindeqiang0125.uploader.path.impl;

import com.github.xindeqiang0125.uploader.path.ChildPath;
import com.github.xindeqiang0125.uploader.util.TimeUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name = "xin.uploader.child-path-strategy", havingValue = "year"
)
public class YearChildPath implements ChildPath {

    @Override
    public String getChildPath() {
        return "/" + TimeUtil.year();
    }
}
