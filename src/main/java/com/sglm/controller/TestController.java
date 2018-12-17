package com.sglm.controller;

import com.mysql.jdbc.PacketTooBigException;
import com.sglm.common.JsonData;
import com.sglm.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping("/hello.json")
	@ResponseBody
	public JsonData hello() {
		log.info("hello");
		throw new PermissionException("test exception");
		//return JsonData.success("hello,permission");
	}

	@RequestMapping("/validate.json")
	@ResponseBody
	public JsonData validate(T) {
		log.info("hello");
		throw new PermissionException("test exception");
		//return JsonData.success("hello,permission");
	}
}
