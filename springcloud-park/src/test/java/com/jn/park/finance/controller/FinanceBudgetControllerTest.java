package com.jn.park.finance.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

/**
 * @author： huangbq
 * @date： Created on 2019/3/10 21:59
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FinanceBudgetControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void selectTotalBudget() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/finance/budget/selectTotalBudget").param("costTypeId","4")).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void historyList() {
    }

    @Test
    public void add() {
    }
}