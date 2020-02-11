package com.example.demo;

import org.apache.dubbo.config.annotation.Reference;
import com.entity.ErrorLog;
import com.service.ErrorLogService;
import com.service.ProviderService;
import com.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Reference(version = "1.0.0",check = false)
    private UserInfoService userInfoService;

    @Reference(version = "1.0.0",check = false,async = true)
    private ErrorLogService errorLogService;
    
    @GetMapping("/aaa")
    public String aaa(){
        System.out.println(userInfoService.getUserInfo(1));
        return "aaa";
    }

    @GetMapping("/bbb")
    public String bbb(){
        ErrorLog errorLog = new ErrorLog();
        errorLog.setName("error");
        System.out.println(errorLogService.sendMsg(errorLog));
        System.out.println("haha");
        return "bbb";
    }

    @GetMapping("/ccc")
    public void ccc(){
        ErrorLog errorLog = new ErrorLog();
        errorLog.setName("dahai");
        errorLogService.asyncSendMsg(errorLog);
        System.out.println(123);
    }



}
