package com.jn.park.sp.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/24 22:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SpPowerVo",description = "权力清单")
public class SpPowerVo  implements Serializable {
    private static final long serialVersionUID = -4442252254493162760L;

    @ApiModelProperty(value = "孩子(当前权力的所有孩子节点列表)")
    private List<SpPowerVo>childs;

    @ApiModelProperty(value = "主键",example = "1")
    private String id;

    @ApiModelProperty(value = "父节点ID",example = "100100")
    private String parentId;

    @ApiModelProperty(value = "权力名称",example = "危险化学品建设项目安全设施设计审查")
    private String name;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public List<SpPowerVo> getChilds() {
        return childs;
    }

    public void setChilds(List<SpPowerVo> childs) {
        this.childs = childs;
    }
}
