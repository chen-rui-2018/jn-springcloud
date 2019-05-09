package com.jn.enterprise.data.tool;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/28 20:35
 * @version： v1.0
 * @modified By:
 */
public class ScientExcelListener extends AnalysisEventListener {
    private List<Object> data = new ArrayList<>();

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        if(data.size()<500){
            data.add(o);
        }else{
            doSomething();
            data.clear();
        }
    }

    /**
     * 做某件事情
     */
    private void doSomething(){
        //


        //
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
