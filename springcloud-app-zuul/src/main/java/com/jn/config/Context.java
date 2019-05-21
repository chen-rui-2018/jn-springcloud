package com.jn.config;

import java.util.HashMap;

/**
 * 上下文
 *
 * @author： fengxh
 * @date： Created on 2019/4/26 21:34
 * @version： v1.0
 * @modified By:
 */
public abstract class Context {
    private static final ThreadLocal<HashMap> CONTEXT = new ThreadLocal();



    public static HashMap getContext() {
        HashMap map = CONTEXT.get() ;
        if(map== null){
            map = new HashMap();
            CONTEXT.set(map);
        }
        return CONTEXT.get() ;
    }

    public static void remove() {
        CONTEXT.remove();
    }
}
