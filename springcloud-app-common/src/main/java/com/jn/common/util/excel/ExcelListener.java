package com.jn.common.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Excel监听类
 *
 * @author： shenph
 * @date： Created on 2019/1/16 15:33
 * @version： v1.0
 * @modified By:
 */
public class ExcelListener extends AnalysisEventListener {

    /**
     * 自定义用于暂时存储data
     * 可以通过实例获取该值
     */
    private List<Object> datas = new ArrayList<>();

    @Override
    public void invoke(Object object, AnalysisContext context) {
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        datas.add(object);
        //根据业务自行 do something
        doSomething();

        //TODO 如数据过大，可以进行定量分批处理
        /*if(datas.size()<=100){
            datas.add(object);
        }else {
            doSomething();
            datas = new ArrayList<Object>();
        }*/
    }

    private void doSomething() {
        //TODO 根据业务自行实现该方法
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //TODO 解析结束销毁不用的资源
        //datas.clear();
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}
