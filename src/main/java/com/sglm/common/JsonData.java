package com.sglm.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用lombook插件来生成get、set方法
 */
@Getter
@Setter
public class JsonData {

	/**
	 * 返回结果
	 */
	private boolean ret;

	/**
	 * 如果有异常，通知的消息
	 */
	private String msg;

	/**
	 * 正常返回，返回给前台的数据
	 */
	private Object data;

	/**
	 * 封装常用的构造方法
	 * @param ret
	 */
	public JsonData(boolean ret) {
		this.ret = ret;
	}

	/**
	 * 定义全局方法——成功
	 * @param object
	 * @param msg
	 * @return
	 */
	public static JsonData success(Object object, String msg) {
		JsonData jsonData = new JsonData(true);
		jsonData.data = object;
		jsonData.msg = msg;
		return jsonData;
	}

	/**
	 * 成功，不需要有消息传到前端
	 * @param object
	 * @return
	 */
	public static JsonData success(Object object) {
		JsonData jsonData = new JsonData(true);
		jsonData.data = object;
		return jsonData;
	}

	/**
	 * 成功，不传任何参数
	 * @return
	 */
	public static JsonData success() {
		return new JsonData(true);
	}

	/**
	 * 失败
	 * @param msg
	 * @return
	 */
	public static JsonData fail(String msg) {
		JsonData jsonData = new JsonData(false);
		jsonData.msg = msg;
		return jsonData;
	}

	public Map<String, Object> toMap() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("ret", ret);
		result.put("msg", msg);
		result.put("data", data);
		return result;
	}
}
