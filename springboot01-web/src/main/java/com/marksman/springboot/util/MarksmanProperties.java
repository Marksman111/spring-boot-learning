package com.marksman.springboot.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author weilb
 * @date 2018/8/19
 * @description
 */
@Component
public class MarksmanProperties {

    @Value("${com.marksman.title}")
    private String title;

    @Value("{com.marksman.description}")
    private String description;

    public MarksmanProperties() {
    }

    public MarksmanProperties(String title,String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
