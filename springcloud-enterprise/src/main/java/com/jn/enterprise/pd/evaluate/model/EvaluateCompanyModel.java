package com.jn.enterprise.pd.evaluate.model;

import com.jn.company.model.CompanyProImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**企业基本信息
 * @author： huangbq
 * @date： Created on 2019/4/2 19:04
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "EvaluateCompanyModel",description = "企业基本信息")
public class EvaluateCompanyModel implements Serializable {
    @ApiModelProperty(value = "企业ID",example = "8afabb60045d40e485e1d4ac04666e8a")
    private String id;
    @ApiModelProperty(value = "企业名称",example = "南京**智能化系统有限公司")
    private String comName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComName() {
        return this.desensitization(comName);
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    /**
     * 公司名脱敏输出
     * 中间1/3的内容用*代替
     * @param s
     * @return
     */
    private String desensitization(String s){
        if(null==s||s.length()<4){
            return s;
        }
        int totalLength=s.length();
        int partLength=totalLength/4;

        StringBuffer sb=new StringBuffer();
        sb.append(s.substring(0,partLength));
        for(int i=0;i<partLength;i++){
            sb.append("*");
        }
        sb.append(s.substring(partLength*3));
        return sb.toString();
    }

}