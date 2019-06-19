package com.jn.reconciliation.service;

import com.jn.reconciliation.ReconciliationTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReconciliationTest {

    @Autowired
    private ReconciliationTask  reconciliationTask;


    /**
     * 对账功能
    * */
    @Test
    public void reconciliationTaskTest() {

        reconciliationTask.taskRun();

    }


}
