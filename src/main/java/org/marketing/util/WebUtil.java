package org.marketing.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public final class WebUtil {

	/** 通过ActionContext获取当前用户信息（在还未到达action中时无法使用） **/
//	public static void setCustomerSession(HttpSession session,
//			CustomerSession customerSession) {
//		session.setMaxInactiveInterval(18000);
//		session.setAttribute("customerSession", customerSession);
//	}

	/** 通过request获取当前用户信息 **/
//	public static Customer getCustomerSession(
//			HttpServletRequest request) {
//		return (Customer) request.getSession().getAttribute(
//				"customerSession");
//	}
	
	/**
	 * 
	 * 方法名称：destroyCustomerLoginSession 方法描述：销毁用户登陆session 创建人：foney
	 * 创建时间：2014-6-21 下午8:45:15 修改人： 修改时间： 修改备注：
	 */
	public static void destroyCustomerSession(HttpServletRequest request) {
		request.getSession().removeAttribute("customerSession");
	}

	/** 获取ip地址 **/
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/** 获得当前系统时间返回TimeStamp **/
	public static Timestamp getNowTimestamp() {
		return new Timestamp(new Date().getTime());
	}


	/**
	 * 
	 * 方法名称：getRandString 方法描述：根据时间取加密成Md5 取前i位 创建人：foney 创建时间：2014-6-14 下午8:04:51
	 * 修改人： 修改时间： 修改备注：
	 */
	public static String getRandString(int i) {
		long nowtime = new java.util.Date().getTime();
		// 取当前的时间作为一个随机的参数
		String rodomtext = MD5Util.MD5Encode(String.valueOf(nowtime) + "rodom")
				.substring(0, i);// md5后再取前i位.
		return rodomtext;
	}

	
	/**
	 * 
	 * 方法名称：setPhoneValidateCode 方法描述：保存手机号response 创建人：foney 创建时间：2014-6-15
	 * 下午10:11:43 修改人： 修改时间： 修改备注：
	 */
	public static void setPhone(String phone, HttpServletResponse response) {
		String value = createKey();
		Cookie cookie = new Cookie("phone", value);
		cookie.setMaxAge(120);
		cookie.setPath("/");
		response.addCookie(cookie);
		/*RedisManager.setKey(value, phone, 120, 2);*/
	}

	public static void destroyPhone(HttpServletRequest request,
			HttpServletResponse response) {
		String key = WebUtil.getCookies("phone", request);
		if (key != null) {/*
			*//*RedisManager.del(key, 2);*/
			// 销毁cookie
			WebUtil.destroyCookies("phone", request, response);
		}
	}

	



	/**
	 * 
	 * 方法名称：getCookies 方法描述：获得cookies 创建人：foney 创建时间：2015-5-4 下午8:14:22 修改人： 修改时间：
	 * 修改备注：
	 */
	public static String getCookies(String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * 方法名称：destroyCookies 方法描述：销毁cookies 创建人：foney 创建时间：2015-5-4 下午8:15:00 修改人：
	 * 修改时间： 修改备注：
	 */
	public static void destroyCookies(String name, HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				// 找到需要删除的Cookie
				if (cookie.getName().compareTo(name) == 0) {
					// 设置生存期为0
					cookie.setMaxAge(0);
					cookie.setPath("/");
					// 设回Response中生效
					response.addCookie(cookie);
				}
			}
		}
	}

	/**
	 * 
	 * 方法名称：uniqueNumber 方法描述：获取唯一数 创建人：foney 创建时间：2014-6-15 下午10:13:23 修改人： 修改时间：
	 * 修改备注：
	 */
	private static Date date = new Date();
	private static StringBuilder buf = new StringBuilder();
	private static int seq = 0;
	private static final int ROTATION = 99999;

	public static synchronized long uniqueNumber() {
		if (seq > ROTATION)
			seq = 0;
		buf.delete(0, buf.length());
		date.setTime(System.currentTimeMillis());
		String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d",
				date, seq++);
		return Long.parseLong(str);
	}

	/**
	 * 
	 * 方法名称：createKey 方法描述：生成redis的随机key码 创建人：foney 创建时间：2015-9-9 上午10:23:48
	 * 修改人：修改时间： 修改备注：
	 */
	public static String createKey() {
		Random r = new Random();
		Long l = System.currentTimeMillis();
		return l.toString() + r.nextInt(9999999);
	}

	
}
