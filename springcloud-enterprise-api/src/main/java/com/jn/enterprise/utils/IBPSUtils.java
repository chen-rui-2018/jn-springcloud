package com.jn.enterprise.utils;

import com.google.gson.Gson;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.CallOtherSwaggerUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.enums.IBPSOperationExceptionEunm;
import com.jn.enterprise.enums.IBPSRequestUrlEnum;
import com.jn.enterprise.model.IBPSCompleteParam;
import com.jn.enterprise.model.IBPSMyTasksParam;
import org.apache.commons.lang3.ObjectUtils;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * IBPS启动工具类
 * @author： huxw
 * @date： Created on 2019-5-7 15:54:37
 * @version： v1.0
 * @modified By:yangph
 */
public class IBPSUtils {
    /**
     * 日志组件
     */
    private static final Logger logger= LoggerFactory.getLogger(IBPSUtils.class);

    /***
     * 启动工作流
     * @param bpmnDefId  流程id
     * @param account    操作人账号（一般为当前登录用户账号）
     * @param data       表单数据
     * @return
     */
    public static IBPSResult startWorkFlow(String bpmnDefId,String account,Object data){
        Map<String,Object>param=new HashMap<>();
        param.put("bpmnDefId", bpmnDefId);
        JSONObject jsonObject = operationWorkFlow(account, IBPSRequestUrlEnum.START_WORK_FLOW.getRequestUrl(), data, param,HttpMethod.POST,null);
        logger.info("启动ibps流程返回数据：{}",jsonObject.toString());
        return new Gson().fromJson(jsonObject.toString(), IBPSResult.class);
    }

    /**
     * 获取审批历史
     * @param account  用户账号
     * @param bpmInstId 流程实例id,启动工作流返回的data为流程实例id
     * @param taskId   任务id,可为空
     * @return
     */
    public static JSONObject opinions(String account,String bpmInstId,String taskId){
        Map<String,Object>param=new HashMap<>(16);
        if(StringUtils.isBlank(bpmInstId)&& StringUtils.isBlank(taskId)){
            logger.warn("IBPS获取审批历史的流程实例ID和任务id不能都为空，至少一个要有值");
            throw new JnSpringCloudException(IBPSOperationExceptionEunm.MY_TASKS_PARAM_NOT_NULL);
        }
        if(StringUtils.isNotBlank(bpmInstId)){
            param.put("bpmInstId", bpmInstId);
        }
        if(StringUtils.isNotBlank(taskId)){
            param.put("taskId",taskId);
        }
        return operationWorkFlow(account, IBPSRequestUrlEnum.OPINIONS.getRequestUrl(), null, param, HttpMethod.GET,null);
    }

    /**
     * 我的待办事项
     * @param account 用户账号
     * @param ibpsMyTasksParam
     * @return
     */
    public static JSONObject myTasks(String account, IBPSMyTasksParam ibpsMyTasksParam){
        if(ibpsMyTasksParam==null){
            logger.warn("IBPS我的待办事项入参不能为空");
            throw new JnSpringCloudException(IBPSOperationExceptionEunm.MY_TASKS_PARAM_NOT_NULL);
        }
        return operationWorkFlow(account, IBPSRequestUrlEnum.MY_TASKS.getRequestUrl(), null, null,HttpMethod.POST,new Gson().toJson(ibpsMyTasksParam));
    }

    /**
     * 我的已办事项
     * @param account 用户账号
     * @return
     */
    public static JSONObject myHandled(String account,IBPSMyTasksParam ibpsMyTasksParam){
        if(ibpsMyTasksParam==null){
            logger.warn("IBPS我的已办事项入参不能为空");
            throw new JnSpringCloudException(IBPSOperationExceptionEunm.MY_HANDLED_PARAM_NOT_NULL);
        }
        return operationWorkFlow(account, IBPSRequestUrlEnum.MY_HANDLED.getRequestUrl(), null, null,HttpMethod.POST,new Gson().toJson(ibpsMyTasksParam));
    }

    /**
     * 获取流程表单
     * @param account       用户账号
     * @param processInsId  流程实例id
     * @return
     */
    public static JSONObject getInstForm(String account,String processInsId){
        Map<String,Object>param=new HashMap<>(16);
        if(processInsId==null){
            logger.warn("流程实例id不能为空");
            throw new JnSpringCloudException(IBPSOperationExceptionEunm.PROCESS_INS_ID_NOT_NULL);
        }
        param.put("bpmInstId", processInsId);
        return operationWorkFlow(account, IBPSRequestUrlEnum.GET_INST_FORM.getRequestUrl(), null, param,HttpMethod.GET,null);
    }

    /**
     * 处理任务
     * @param account  用户账号
     * @param ibpsCompleteParam 处理任务入参
     * @return
     */
    public static JSONObject complete(String account, IBPSCompleteParam ibpsCompleteParam){
        if(ibpsCompleteParam==null){
            logger.warn("IBPS处理任务入参不能为空");
            throw new JnSpringCloudException(IBPSOperationExceptionEunm.COMPLETE_PARAM_NOT_NULL);
        }
        Map<String,Object>param=javaBeanToMap(ibpsCompleteParam);
        return  operationWorkFlow(account, IBPSRequestUrlEnum.COMPLETE.getRequestUrl(), null, param,HttpMethod.POST,null);
    }


    /**
     * 操作工作流方法(默认表单提交方式)
     * @param operationAccount  操作人账号
     * @param ibpsRequestUrl    操作的IBPS方法的请求url
     * @param data              表单数据
     * @param param             请求入参
     * @param jsonObject        json格式请求参数
     * @return
     */
    public static JSONObject operationWorkFlow(String operationAccount, String ibpsRequestUrl, Object data, Map<String, Object> param,
                                               HttpMethod method, String jsonObject){
        MultiValueMap<String, Object> map=new LinkedMultiValueMap<>();
        if(data!=null){
            Gson gson = new Gson();
            String jsonData = gson.toJson(data);
            logger.info("表单json数据：{}",jsonData);
            map.add("data",jsonData);
        }
        if(param!=null){
            map.setAll(param);
        }
        if(jsonObject==null){
            return CallOtherSwaggerUtils.request(operationAccount, ibpsRequestUrl, method, map);
        }else{
            return CallOtherSwaggerUtils.request(operationAccount, ibpsRequestUrl, method, jsonObject);
        }

    }

    /**
     *把java对象设置为键值对存储   javaBean  to Map
     * @param obj
     * @return
     */
    public static Map<String,Object>javaBeanToMap(Object obj){
        Map<String,Object> map=new HashMap<>();
        if(obj==null){
            return null;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field:fields){
            try {
                //获取字段名
                String fieldName = field.getName();
                //暴力破解私有属性
                field.setAccessible(true);
                //获取字段值
                Object value = field.get(obj);
                //判断是否为data  流程表单数据，若是，需要转换为json字符串
                if("data".equals(fieldName)){
                    map.put(fieldName, new Gson().toJson(value));
                }else if(StringUtils.isNotBlank(ObjectUtils.toString(value))){
                    map.put(fieldName,(String)value);
                }else if(value==null){
                   //ignore
                }else{
                    logger.warn("当前字段：[{}]的类型不是字符串类型,请封装处理数据",fieldName);
                    throw new JnSpringCloudException(IBPSOperationExceptionEunm.NETWORK_ANOMALY);
                }
            } catch (IllegalAccessException e) {
                logger.warn("工作流设置键值对异常");
                throw new JnSpringCloudException(IBPSOperationExceptionEunm.NETWORK_ANOMALY);
            }

        }
        return map;
    }
}
