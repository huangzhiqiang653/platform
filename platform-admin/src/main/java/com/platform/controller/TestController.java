package com.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试
 *
 * @author lipengjun
 * @date 2017年11月18日 下午13:13:23
 */
@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("/toTest")
    public String tojsp() {
        return "test";
    }
}
