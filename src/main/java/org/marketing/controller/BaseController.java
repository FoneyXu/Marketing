package org.marketing.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.marketing.util.Prompt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseController {

	protected String msg;
	protected Map<String, Object> map;
	@SuppressWarnings("rawtypes")
	protected List<Map> listmap;
	protected Prompt prompt;
	
	// 分页
	protected String sort = "ASC";// 排序方式 正序 倒叙

	protected String order;// 以什么排序

//	protected int rows = 10;// 每页显示的记录数

//	protected int page = 1;// 当前第几页

	/**
	 * 方法名称：outPutJson 方法描述：将对象转成Json串传到页面 创建人： 创建时间：2014-3-26 上午9:34:31
	 */
	protected void outPutJson(Object ob, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
			response.setHeader("Access-Control-Allow-Credentials","true");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Content-type", "application/json");
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.create();
			String json = gson.toJson(ob);
			//System.out.println(json);
			out.println(json);
			Prompt.getInstance().clearPrompt();//清除消息返回对象
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}


	/**
	 * 
	 * 方法名称：writeToPage 方法描述：输入字符串到页面 创建人： 创建时间：2014-6-25 上午10:32:34 修改人：
	 * 修改时间： 修改备注：
	 */
	public void writeToPage(String result, HttpServletResponse response) {
		PrintWriter out;
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");

		try {
			out = response.getWriter();
			try {
				out.print(result);
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public List<Map> getListmap() {
		return listmap;
	}

	@SuppressWarnings("rawtypes")
	public void setListmap(List<Map> listmap) {
		this.listmap = listmap;
	}
	

	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}


	public String getOrder() {
		return order;
	}


	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @author 徐志远
	 * @created 2017年6月7日 下午4:35:45 
	 * @return type 
	 */
	
	public Map<String, Object> getMap() {
		return map;
	}


	/** 
	 * @author 徐志远
	 * @created 2017年6月7日 下午4:35:45 
	 * @param map
	 */
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
