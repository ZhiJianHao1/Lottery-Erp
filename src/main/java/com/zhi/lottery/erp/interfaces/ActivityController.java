package com.zhi.lottery.erp.interfaces;

import com.zhi.lottery.erp.application.IActivityService;
import com.zhi.lottery.erp.domain.activity.model.ActivityListPageReq;
import com.zhi.lottery.erp.infrastructure.common.EasyResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @description:
 * @author：zhijianhao
 * @date: 2024/2/4
 */
@Controller
@RequestMapping("api/activity")
public class ActivityController {
    private Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Resource
    private IActivityService activityService;

    @RequestMapping("queryActivityListPage")
    @ResponseBody
    public EasyResult queryActivityListPage(String page, String rows) {
        try {
            logger.info("查询活动列表数据 page：{} rows：{}", page, rows);
            rows = null == rows ? "10" : rows;
            ActivityListPageReq req = new ActivityListPageReq(page, rows);
            req.setErpId("zhi");
            return activityService.queryActivityListPage(req);
        } catch (Exception e) {
            logger.error("查询活动列表数据失败 page：{} rows：{}", page, rows, e);
            return EasyResult.buildEasyResultError(e);
        }
    }
}
