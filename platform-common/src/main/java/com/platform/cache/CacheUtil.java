package com.platform.cache;

import org.springframework.beans.factory.InitializingBean;

/**
 * 内存缓存 <br>
 *
 * @author lipengjun
 * @date 2017年11月18日 下午13:13:23
 */
public class CacheUtil implements InitializingBean {


    public static void init() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

}