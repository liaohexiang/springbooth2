package com.tony.springbooth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

@RestController
public class MyController {

	@Autowired
	ActionRepository actionRepository;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@RequestMapping("/do-post")
	public String doPost(){
		actionRepository.save(new Action("123","123"));
    	actionRepository.save(new Action("234","234"));
    	return "hello shit";
	}
	@RequestMapping("/do-out")
	public String doOutput()
	{
		App app = applicationContext.getBean(App.class);
		app.init();
		return "hello shit2";
	}
}
