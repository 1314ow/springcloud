package com.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sam.entity.User;
import com.sam.service.FeignConsumerService;

@RestController
public class FeiConsumerController {

	@Autowired
	FeignConsumerService consumerService;

	
	
	/****请求带参数***/
	@RequestMapping("feign-consumer-mytest")
	public String mytest() {
		// 调用feign-service/mytestfeignprovider方法
		consumerService.mytest("请求带参数");
		System.out.println("--------------in-feign consumer  mytest 方法中");
		return "--------------in-feign consumer  mytest 方法中";
	}
	
	
	@RequestMapping("feign-consumer")
	public String feignConsumer() {
		// 调用feign-service/hello方法
		consumerService.hello();
		System.out.println("--------------in-feign consumer  feignConsumer 方法中");
		return "--------------in-feign consumer  feignConsumer 方法中";
	}

	@RequestMapping("feign-consumer-user")
	public User feignConsumerUser(User user) {
		consumerService.hello2();
		System.out.println("--------------in-feign consumer  feignConsumerUser 方法中");
		return consumerService.printUser(user);
	}
}
