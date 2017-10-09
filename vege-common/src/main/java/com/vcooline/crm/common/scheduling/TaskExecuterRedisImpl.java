package com.vcooline.crm.common.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TaskExecuterRedisImpl implements TaskExecuter {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void execute(Task task) {

    }

}
