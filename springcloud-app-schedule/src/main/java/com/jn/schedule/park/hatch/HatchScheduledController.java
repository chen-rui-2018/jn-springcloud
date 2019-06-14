package com.jn.schedule.park.hatch;

import com.jn.common.model.Result;
import com.jn.park.api.PmPayBillServiceClient;
import com.jn.park.hatch.api.HatchhomeConfigClient;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 孵化企业定时器
 *
 * @author： wzy
 * @date： Created on 2019/5/29 20:11
 * @version： v1.0
 * @modified By:
 */
@Component
public class HatchScheduledController {

    private static Logger logger = LoggerFactory.getLogger(HatchScheduledController.class);

    @Autowired
    private HatchhomeConfigClient hatchhomeConfigClient;

    /**
     * 每天凌晨4点执行执行,更新在孵企业（团队）报名活动项
     */
    @Scheduled(cron = " 0 0 4 * * ? ")
    public void updateEnrolmentActivit() {
        logger.info("凌晨4点执行执行,更新在孵企业（团队）报名活动项");
        hatchhomeConfigClient.updateEnrolmentActivit();
    }

    /**
     * 每天凌晨4点执行执行,更新在孵企业（团队）政策申报项
     */
    @Scheduled(cron = " 0 0 4 * * ? ")
    public void updatePolicyDeclarate() {
        logger.info("凌晨4点执行执行,更新在孵企业（团队）政策申报项");
        hatchhomeConfigClient.updatePolicyDeclarate();
    }

    /**
     * 每天凌晨4点执行执行,更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】
     */
    @Scheduled(cron = " 0 0 4 * * ? ")
    public void updateGraduateRegister() {
        logger.info("凌晨4点执行执行,更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】");
        hatchhomeConfigClient.updateGraduateRegister();
    }

    /**
     * 每天凌晨4点执行执行,更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】
     */
    @Scheduled(cron = " 0 0 4 * * ? ")
    public void updateGraduateRevenue() {
        logger.info("凌晨4点执行执行,更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】");
        hatchhomeConfigClient.updateGraduateRevenue();
    }

}
