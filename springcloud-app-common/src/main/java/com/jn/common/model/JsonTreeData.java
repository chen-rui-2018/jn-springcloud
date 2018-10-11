package com.jn.common.model;

import java.util.List;
/**
 * json的树形结构
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By:
 */
public class JsonTreeData {

    public String id;
    public String pid;
    public String text;
    public String state;
    public Attributes attributes;
    public List<JsonTreeData> children;

    public JsonTreeData(String id, String pid, String text, String state, Attributes attributes,
                        List<JsonTreeData> children) {
        super();
        this.id = id;
        this.pid = pid;
        this.text = text;
        this.state = state;
        this.attributes = attributes;
        this.children = children;
    }

    public JsonTreeData() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<JsonTreeData> getChildren() {
        return children;
    }

    public void setChildren(List<JsonTreeData> children) {
        this.children = children;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }


}