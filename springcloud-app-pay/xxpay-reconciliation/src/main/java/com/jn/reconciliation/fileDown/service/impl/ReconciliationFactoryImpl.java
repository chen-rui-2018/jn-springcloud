package com.jn.reconciliation.fileDown.service.impl;

import com.jn.reconciliation.fileDown.service.FileDown;
import com.jn.reconciliation.fileDown.service.ReconciliationFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;


/**
 * @ClassName：账单工厂
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class ReconciliationFactoryImpl implements ReconciliationFactory , BeanFactoryAware {
    private BeanFactory beanFactory;

    /**
     * 去Spring容器中根据beanName获取对象（也可以直接根据名字创建实例，可以参考后面流程中的parser）
     *
     * @param payInterface
     * @return
     */
    public Object getService(String payInterface) {
        return beanFactory.getBean(payInterface);
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 账单下载
     *
     * @param payInterface
     *            支付渠道
     *
     * @param billDate
     *            账单日
     */
    @Override
    public File fileDown(String payInterface, Date billDate) throws Exception {
        // 找到具体的FileDown实现，做向上转型
        FileDown fileDown = (FileDown) this.getService(payInterface + "FileDown");
        return fileDown.fileDown(billDate);
    }
}
