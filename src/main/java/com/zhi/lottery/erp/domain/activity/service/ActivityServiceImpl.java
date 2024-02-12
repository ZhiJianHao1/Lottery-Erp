package com.zhi.lottery.erp.domain.activity.service;

import com.zhi.lottery.common.Constants;
import com.zhi.lottery.erp.application.IActivityService;
import com.zhi.lottery.erp.domain.activity.model.ActivityListPageReq;
import com.zhi.lottery.erp.infrastructure.common.EasyResult;
import com.zhi.lottery.rpc.deploy.ILotteryActivityDeploy;
import com.zhi.lottery.rpc.deploy.req.ActivityPageReq;
import com.zhi.lottery.rpc.deploy.res.ActivityRes;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @description: 活动服务
 * @author：zhijianhao
 * @date: 2024/2/4
 */
@Service
public class ActivityServiceImpl implements IActivityService {
    @DubboReference(interfaceClass = ILotteryActivityDeploy.class)
    private ILotteryActivityDeploy activityDeploy;
    @Override
    public EasyResult queryActivityListPage(ActivityListPageReq req) {
        // 1. 组装参数
        ActivityPageReq activityPageReq = new ActivityPageReq(req.getPage(), req.getRows());
        activityPageReq.setErpId(req.getErpId());
        activityPageReq.setActivityId(req.getActivityId());
        activityPageReq.setActivityName(req.getActivityName());

        // 2. 查询数据
        ActivityRes activityRes = activityDeploy.queryActivityListByPageForErp(activityPageReq);

        // 3. 封装结果
        if (Constants.ResponseCode.SUCCESS.getCode().equals(activityRes.getResult().getCode())) {
            return EasyResult.buildEasyResultSuccess(activityRes.getCount(), activityRes.getActivityDTOList());
        } else {
            return EasyResult.buildEasyResultError(activityRes.getResult().getCode());
        }
    }
}
