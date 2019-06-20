package com.jn.system.config;

/**
 * AccessContext
 *
 * @author： shenph
 * @date： Created on 2019/4/26 21:34
 * @version： v1.0
 * @modified By:
 */
public class AccessContext {
    private static final ThreadLocal<String> tokenContext = new ThreadLocal();

    public AccessContext() {
    }

    public static void setTokenContext(String token) {
        tokenContext.set(token);
    }

    public static String getTokenContext() {
        return (String) tokenContext.get();
    }

    public static void remove() {
        tokenContext.remove();
    }
}
