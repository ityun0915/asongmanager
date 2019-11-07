package com.fangzhou.asongmanager.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回类
 *
 */
public class Msg {
	
	@Override
	public String toString() {
		return "Msg [code=" + code + ", msg=" + msg + ", extend=" + extend + ", getCode()=" + getCode() + ", getMsg()="
				+ getMsg() + ", getExtend()=" + getExtend() + "]";
	}

	//状态码
	private int code;
	//提示信息
	private String msg;
	
	//用户要返回给浏览器的数据
	private Map<String,Object> extend = new HashMap<String,Object>();

	public static Msg success() {
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("成功");
		return result;
		
	}
	
	public static Msg fail() {
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("失败");
		return result;
		
	}
	
	public static Msg failForPass() {
		Msg result = new Msg();
		result.setCode(300);
		result.setMsg("失败");
		return result;
		
	}
	
	public static Msg failForNotPass() {
		Msg result = new Msg();
		result.setCode(400);
		result.setMsg("失败");
		return result;
		
	}
	
	public static Msg failForNotZiji() {
		Msg result = new Msg();
		result.setCode(500);
		result.setMsg("失败");
		return result;
		
	}
	
	public static Msg guoqifail() {
		Msg result = new Msg();
		result.setCode(300);
		result.setMsg("登录信息过期，请重新登录");
		return result;
		
	}

	public static Msg jihaofail() {
		Msg result = new Msg();
		result.setCode(400);
		result.setMsg("账号被挤出");
		return result;
		
	}
	
	public static Msg denlufail() {
		Msg result = new Msg();
		result.setCode(500);
		result.setMsg("未登录，请先登录");
		return result;
		
	}
	
	public static Msg beifeng() {
		Msg result = new Msg();
		result.setCode(600);
		result.setMsg("账号已被封，请联系管理员");
		return result;
		
	}
	
	public Msg add(String key,Object value) {
		this.getExtend().put(key, value);
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
}
