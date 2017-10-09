package com.vcooline.crm.admin.service;

import com.vcooline.crm.common.scheduling.AbstractTask;
import com.vcooline.crm.common.scheduling.TaskExecuter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService extends BaseService {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    TaskExecuter taskExecuter;


    /**
     * 每天凌晨7点定时清空缓存
     */
    @Scheduled(cron = "0 0 7 * * ?")
    public void clearCache() {
        taskExecuter.execute(new AbstractTask() {
            @Override
            public void run() {
                /*demoService.clearCache();*/
            }

            @Override
            public String getName() {
                return "clearCache";
            }

            @Override
            public String getKeyPrefix() {
                return "lock:clearCache";
            }
        });
    }
}
