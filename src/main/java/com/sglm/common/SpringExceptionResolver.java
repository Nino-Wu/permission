package com.sglm.common;

import com.sglm.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理类
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		String url = request.getRequestURL().toString();
		ModelAndView mv;
		String defaultMsg = "System error";

		// 这里我们要求项目中所有请求json数据，都使用.json结尾
		if (url.endsWith(".json")) {
			// 如果当前异常时自定义异常，msg使用抛出来的msg
			if (ex instanceof PermissionException) {
				JsonData result = JsonData.fail(ex.getMessage());
				mv = new ModelAndView("jsonView", result.toMap());
			} else {
				log.info("unknow json exception, url:" + url, ex);
				JsonData result = JsonData.fail(defaultMsg);
				mv = new ModelAndView("jsonView", result.toMap());
			}
		} else if (url.endsWith(".page")) {
			log.info("unknow page exception, url:" + url, ex);
			JsonData result = JsonData.fail(defaultMsg);
			mv = new ModelAndView("exception", result.toMap());
		} else {
			log.info("unknow exception, url:" + url, ex);
			JsonData result = JsonData.fail(defaultMsg);
			mv = new ModelAndView("jsonView", result.toMap());
		}

		return mv;
	}
}
