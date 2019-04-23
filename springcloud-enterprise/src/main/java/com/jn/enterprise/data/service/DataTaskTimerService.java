package com.jn.enterprise.data.service;

/**
 * @author： yangh
 * @date： Created on 2019/4/18 10:35
 * @version： v1.0
 * @modified By:
 */
public interface DataTaskTimerService {
    /**
     * 创建任务
     */
    void createTask();

    /**
     * 更新任务
     */
    void updateTask();

    /**
     * 任务预警
     */
    void taskWarning();
}
