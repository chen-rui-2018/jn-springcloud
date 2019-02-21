package com.jn.wechat.base.utils.xml;

import com.thoughtworks.xstream.converters.basic.StringConverter;

/**
 * 微信报文格式转换
 * String类型的需加<![CDATA[]]>
 *
 * @Author： cm
 * @Date： Created on 2019/1/9 10:35
 * @Version： v1.0
 * @Modified By:
 */
public class XStreamDataConverter extends StringConverter {

    @Override
    public String toString(Object obj) {
        return "<![CDATA[" + super.toString(obj) + "]]>";
    }

}
