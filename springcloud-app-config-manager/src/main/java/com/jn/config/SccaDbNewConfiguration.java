package com.jn.config;

import com.didispace.scca.core.service.PersistenceService;
import com.jn.service.DbNewPersistenceService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用新的configuartion
 *
 * @author： fengxh
 * @date： Created on 2018/11/28 20:13
 * @version： v1.0
 * @modified By:
 */
@Configuration
public class SccaDbNewConfiguration {

    public SccaDbNewConfiguration() {
    }

    @Bean
    @ConditionalOnMissingBean
    public PersistenceService persistenceService() {
        return new DbNewPersistenceService();
    }

}
