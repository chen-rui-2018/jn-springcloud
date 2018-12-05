package com.jn.portals.user.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCache;
import com.jn.portals.user.enums.PortalsLoginExceptionEnum;
import com.jn.portals.user.service.SildeValidationService;
import com.jn.portals.user.utils.VerifyImageUtils;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.*;

/**
 * 滑动验证
 * @Author: yangph
 * @Date: 2018/11/30 17:02
 * @Version v1.0
 * @modified By:
 */
@Service
public class SildeValidationServiceImpl implements SildeValidationService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(SildeValidationServiceImpl.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value(value = "${side_validation.key}")
    private String redisSildeKey;

    @Value(value = "${side_validation.expire}")
    private int expire;

    @Value(value = "${side_validation.prefix}")
    private String prefix;

    /**
     * 滑动验证图片生成
     * @param oriWidth  源文件宽度
     * @param oriHeight 源文件高度
     * @return
     */
    @ServiceLog(doAction = "滑动验证图片生成")
    @Override
    public Result slideValidation(String oriWidth, String oriHeight) {
        Result result= new Result();
        //放大倍数
        float magnify=1.5f;
        //文件宽度在1-885有效，否则使用默认值
        if(StringUtils.isNumeric(oriWidth) && Integer.parseInt(oriWidth)>0 && Integer.parseInt(oriWidth)<=(VerifyImageUtils.getOriWidth()*magnify)){
            //设置源文件的宽度，默认为宽度为590px
            VerifyImageUtils.setOriWidth(Integer.parseInt(oriWidth));
        }
        //文件宽度在1-540有效，否则使用默认值
        if(StringUtils.isNumeric(oriHeight)&& Integer.parseInt(oriHeight)>0 &&  Integer.parseInt(oriHeight)<=(VerifyImageUtils.getOriHeight()*magnify) ){
            //设置源文件的高度，默认为宽度为360px
            VerifyImageUtils.setOriHeight(Integer.parseInt(oriHeight));
        }
        Map<String, byte[]> pictureMap;

        Random random = new Random();
        int templateNo = random.nextInt(4) + 1;
        int targetNo = random.nextInt(20) + 1;

        //模板图片
        File templateFile=new File(templateNo + ".png");
        File targetFile=new File(targetNo + ".jpg");
        try(InputStream tempStream = getClass().getClassLoader().getResourceAsStream("static/templates/" + templateNo + ".png");
            InputStream tagStream = getClass().getClassLoader().getResourceAsStream("static/targets/" + targetNo + ".jpg")){
            FileUtils.copyInputStreamToFile(tempStream, templateFile);
            FileUtils.copyInputStreamToFile(tagStream, targetFile);
            pictureMap = VerifyImageUtils.pictureTemplatesCut(templateFile, targetFile, "png", "jpg");
            //获取抠图坐标x,把值转为字符串再存储
            String xCoord = VerifyImageUtils.getX()+"";
            //用uuid作为key,返回前端，验证时要前端带回来
            UUID uuid = UUID.randomUUID();
            //将抠图坐标x写入redis中，以便校验
            RedisCache cache=new RedisCache(redisTemplate, prefix, expire);
            logger.info("滑动验证抠图坐标x的值为：{}",xCoord);
            cache.put(redisSildeKey+"_"+"xCoord"+"_"+uuid.toString(), xCoord);
            //新建map对象，存放uuid的key
            Map map=new HashMap(16);
            map.put("verifyKey",  uuid.toString());
            //存放图片和验证key,返回前端
            List list=new ArrayList(16);
            list.add(map);
            list.add(pictureMap);
            result.setData(list);
        }catch(Exception e){
            result.setCode(PortalsLoginExceptionEnum.NETWORK_ANOMALY.getCode());
            result.setResult(PortalsLoginExceptionEnum.NETWORK_ANOMALY.getMessage());
            logger.info("滑动图片生成失败，失败原因：{}",e.getMessage());
        }finally {
            if(templateFile.exists()){
                boolean flag = templateFile.delete();
                if(!flag){
                    logger.info("---滑动图片删除失败，请手动删除---");
                }
            }
            if(targetFile.exists()){
                boolean flag = targetFile.delete();
                if(!flag){
                    logger.info("---滑动图片删除失败，请手动删除---");
                }
            }
        }
        return result;
    }

    /**
     * 校验前端滑动操作结果
     * @param verifyKey  后端传递的校验key
     * @param xCoord     抠图坐标x
     * @return
     */
    @ServiceLog(doAction = "校验前端滑动操作结果")
    @Override
    public Result verificationOption(String verifyKey, String xCoord) {
        Result result= new Result();
        if(StringUtils.isBlank(verifyKey) || StringUtils.isBlank(xCoord)){
            result.setCode(PortalsLoginExceptionEnum.SIDE_VALTIDATION_PARAM_ERROR.getCode());
            result.setResult(PortalsLoginExceptionEnum.SIDE_VALTIDATION_PARAM_ERROR.getMessage());
            logger.info("滑动操作参数错误，参数为空");
            return  result;
        }
        try {
            //判断xCood能否转换为float
            if(Float.parseFloat(xCoord)>0){
                //根据校验key从redis中获取抠图坐标x的值
                RedisCache cache=new RedisCache(redisTemplate, prefix, expire);
                String xValue=(String) cache.get(redisSildeKey+"_"+"xCoord"+"_"+verifyKey);
                if(StringUtils.isNotBlank(xValue)){
                    //校验通过标识
                    String okFlag="ok";
                    String msg="滑动验证通过";
                    //已经校验通过，重复请求直接返回校验通过结果
                    if(okFlag.equals(xValue)){
                        return new Result(msg);
                    }
                    float value=Float.parseFloat(xValue);
                    //差异值
                    float diffVlue=5;
                    //如果前端传递的抠图坐标x的值在redis缓存值的±5的范围内，则校验通过
                    if((value+diffVlue)>=Float.parseFloat(xCoord) && (value-diffVlue)<=Float.parseFloat(xCoord)){
                        //验证通过，把redis中的值设置为OK
                        cache.put(redisSildeKey+"_"+"xCoord"+"_"+verifyKey, "ok");
                        return new Result(msg);
                    }
                }
            }
            //校验不通过
            result.setCode(PortalsLoginExceptionEnum.SIDE_VALIDATION_MSG.getCode());
            result.setResult(PortalsLoginExceptionEnum.SIDE_VALIDATION_MSG.getMessage());
            logger.info("滑动操作检验不通过");
        } catch (NumberFormatException e) {
            result.setCode(PortalsLoginExceptionEnum.SIDE_VALTIDATION_PARAM_ERROR.getCode());
            result.setResult(PortalsLoginExceptionEnum.SIDE_VALTIDATION_PARAM_ERROR.getMessage());
            logger.info("滑动操作参数错误，参数格式错误");
        }
        return result;
    }
}
