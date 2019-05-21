package com.jn.enterprise.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: yangph
 * @Date: 2019/5/14 20:22
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "IBPSMyTasksParam", description = "IBPS我的待办/已办事项入参")
public class IBPSMyTasksParam implements Serializable {
    @ApiModelProperty(value = "动态参数(参数可为流程id,流程名称，流程实例id...)",required = true)
    private List<Parameter> parameters;
    @ApiModelProperty(value = "分页参数",required = true)
    private RequestPage requestPage;
    @ApiModelProperty(value = "排序参数",required = true)
    private List<Sort>sorts;



    /**
     * 构造函数，传动态参数、分页信息、排序信息
     * @param dynamicParams 动态参数，可为null
     * @param limit
     * @param pageNo
     * @param sortsParam   排序参数，可为null
     */
    public IBPSMyTasksParam(List<Map<String,String>>dynamicParams,int limit,int pageNo,List<Map<String,String>>sortsParam){
        //动态参数
        List<Parameter> parameters=new ArrayList<>();
        if(dynamicParams!=null && dynamicParams.size()>0){
            for(Map<String,String>param:dynamicParams){
                String key = param.keySet().iterator().next();
                String value=param.get(key);
                Parameter parameter=new Parameter();
                parameter.setKey(key);
                parameter.setValue(value);
                parameters.add(parameter);
            }
        }else{
            parameters.add(new Parameter());
        }
        this.parameters=parameters;
        //分页信息
        RequestPage requestPage=new RequestPage();
        requestPage.setLimit(limit);
        requestPage.setPageNo(pageNo);
        this.requestPage=requestPage;
        //排序信息
        List<Sort>sorts=new ArrayList<>();
        if(sortsParam!=null && sortsParam.size()>0){
            for(Map<String,String>param:sortsParam){
                String field = param.keySet().iterator().next();
                String order=param.get(field);
                Sort sort=new Sort();
                sort.setField(field);
                sort.setOrder(order);
                sorts.add(sort);
            }
        }else{
            sorts.add(new Sort());
        }
        this.sorts = sorts;
    }

    /**
     * 动态参数
     */
    class Parameter{
        /**
         * 动态参数的key（参数可为流程id,流程名称，流程实例id...）,默认传""
         */
        private String key="";
        /**
         * 动态参数的value(流程id,流程名称，流程实例id...的value值),默认传""
         */
        private String value="";

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    /**
     * 分页参数
     */
    class RequestPage{
        /**
         * 每页显示数据条数
         */
        private int limit;
        /**
         * 显示页码（第几页）
         */
        private int pageNo;

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }
    }

    /**
     * 排序参数
     */
    class Sort{
        /**
         * 排序字段名，默认传""
         */
        private String field="";
        /**
         * 排序方式  asc:正序   desc:倒序，默认传""
         */
        private String order="";

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public RequestPage getRequestPage() {
        return requestPage;
    }

    public void setRequestPage(RequestPage requestPage) {
        this.requestPage = requestPage;
    }

    public List<Sort> getSorts() {
        return sorts;
    }

    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }
}
