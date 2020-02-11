package com.example.demo;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.service.ProviderService;
@RestController
public class Consumer   {
   @Reference(version = "1.0.0",check = false)
	private  ProviderService service;

    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name){
        return service.sayHello(name);
    }
}