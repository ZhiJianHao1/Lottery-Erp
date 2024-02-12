package com.zhi.lottery.erp.application;

import com.zhi.lottery.erp.domain.activity.model.ActivityListPageReq;
import com.zhi.lottery.erp.infrastructure.common.EasyResult;

/**
 * @description: 活动服务接口
 * @author：zhijianhao
 * @date: 2024/2/4
 */
public interface IActivityService {
    /**
     * 查询活动分页数据
     * @param req   入参
     * @return      结果
     */
    EasyResult queryActivityListPage(ActivityListPageReq req);
}
