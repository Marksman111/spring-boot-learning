package com.marksman.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author weilb
 * @date 2018/8/26
 * @description
 */
@Component
public class SchedulerTask2 {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime(){
        System.out.println("现在时间: "+sdf.format(new Date()));
    }
}
