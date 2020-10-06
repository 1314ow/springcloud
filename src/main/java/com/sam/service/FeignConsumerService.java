package com.sam.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 通过@FeignClient注解指定服务名来绑定服务，这里的服务名字不区分大小写
 * 然后再通过@RequestMapping来绑定服务下的rest接口
 *
 */
// @FeignClient(name="hello-service")
@FeignClient(name="feign-service")// 1 通过@FeignClient定义 service层 接口，并指定服务名
@Service
public interface FeignConsumerService extends HelloService{ // 只需要继承即可，不需要重写接口方法
	 //"implements", extends expected  
	// eclipse明确指出，接口之间是继承关系，而非实现关系。

    // #### //地址为服务提供者对外暴露的地址
	@RequestMapping("/hello") // 2 通过@RequestMapping来绑定服务下的rest接口，地址为服务提供者对外暴露的地址
	public void hello();   // 调用feign-service/hello方法
	
	
	/****请求带参数***/ //与提供者定义的方法一样就行
	// 。需要注意的是：在SpringMVC中@RequestParam和@RequestHeader注解，如果我们不指定value，则默认采用参数的名字作为其value，但是在Feign中，这个value必须明确指定，否则会报错。
	// @RequestParam("name") String name
	@RequestMapping(value = "/mytestfeignprovider", method = RequestMethod.GET)// 2 通过@RequestMapping来绑定服务下的rest接口，地址为服务提供者对外暴露的地址
	public String mytest(@RequestParam("name") String name) ;
}
