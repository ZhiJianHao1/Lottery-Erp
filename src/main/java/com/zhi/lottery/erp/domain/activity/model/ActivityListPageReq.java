package com.zhi.lottery.erp.domain.activity.model;

import com.zhi.lottery.common.PageRequest;

/**
 * @description:
 * @author：zhijianhao
 * @date: 2024/2/4
 */
public class ActivityListPageReq extends PageRequest {
    /**
     * ERP ID，记录谁在操作
     */
    private String erpId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    public ActivityListPageReq(int page, int rows) {
        super(page, rows);
    }

    public ActivityListPageReq(String page, String rows) {
        super(page, rows);
    }

    public String getErpId() {
        return erpId;
    }

    public void setErpId(String erpId) {
        this.erpId = erpId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
