package com.marksman.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author weilb
 * @date 2018/8/26
 * @description
 */
@Component
public class SchedulerTask {

    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task running "+(count++));
    }
}
