package com.jn.service;

import com.didispace.scca.core.domain.Label;
import com.didispace.scca.service.persistence.db.DbPersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

/**
 * 代理新的配置
 *
 * @author： fengxh
 * @date： Created on 2018/11/28 20:15
 * @version： v1.0
 * @modified By:
 */
public class DbNewPersistenceService extends DbPersistenceService {

    private static final Logger log = LoggerFactory.getLogger(DbNewPersistenceService.class);

    @Autowired
    private Refresh refresh;

    public DbNewPersistenceService() {
        super();
    }

    @Override
    public Properties readProperties(String application, String profile, String label) {
        return super.readProperties(application, profile, label);
    }

    @Override
    public void deletePropertiesByEnv(String profile) {
        super.deletePropertiesByEnv(profile);
    }

    @Override
    public void deletePropertiesByProject(String application) {
        super.deletePropertiesByProject(application);
    }

    @Override
    public void deletePropertiesByProjectAndEnv(String application, String profile) {
        super.deletePropertiesByProjectAndEnv(application, profile);
    }

    @Override
    public void deletePropertiesByLabel(Label label) {
        super.deletePropertiesByLabel(label);
    }

    @Override
    public void deletePropertiesByProjectAndEnvAndLabel(String application, String profile, String label) {
        super.deletePropertiesByProjectAndEnvAndLabel(application, profile, label);
    }

    @Override
    public void saveProperties(String application, String profile, String label, Properties update) {
        super.saveProperties(application, profile, label, update);
        sendBusMessage();
    }

    @Override
    public void updateProfileName(String oldName, String newName) {
        super.updateProfileName(oldName, newName);
    }


    /**
     * 对配置修改，进行通知
     */
    private void sendBusMessage(){
        log.info("进入BUS总线通知配置更新");
        // TODO: 2018/11/28  炮哥，如果其他的配置还需要BUS总线通知的，可以在这里切入代理
        try{
            refresh.refresh();
        }catch (Exception e){
            log.warn("进入BUS总线通知配置更新,异常：{}",e.getMessage());
        }
    }
}
