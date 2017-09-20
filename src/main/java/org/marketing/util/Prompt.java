/**
 * 
 */
package org.marketing.util;

/**
 * 
 * @author Administrator
 * 类名：Prompt
 * 类描述：返回消息类
 * 创建日期：
 */
public class Prompt {
	
	private Object data;
	private String result;
	private String msg;
	
	private Prompt(){
		
	}
	
	private static Prompt instance; 
	
	public static synchronized  Prompt getInstance() {   
        if (instance == null) {
        	instance = new Prompt();   
        	instance.setResult("true");//默认返回对象为true
        }  
        return instance;   
    }  
	
	public void clearPrompt() {
		this.data = null;
		this.result = "true";//清除之后，重新设置返回对象结果为true
		this.msg = null;
	}
	
	/**
	 * @author 徐志远
	 * @created 2017年6月7日 下午3:50:19 
	 * @return type 
	 */
	
	public Object getData() {
		return data;
	}
	/** 
	 * @author 徐志远
	 * @created 2017年6月7日 下午3:50:19 
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * @author 徐志远
	 * @created 2017年6月7日 下午3:50:19 
	 * @return type 
	 */
	
	public String getResult() {
		return result;
	}
	/** 
	 * @author 徐志远
	 * @created 2017年6月7日 下午3:50:19 
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @author 徐志远
	 * @created 2017年6月7日 下午3:50:19 
	 * @return type 
	 */
	
	public String getMsg() {
		return msg;
	}
	/** 
	 * @author 徐志远
	 * @created 2017年6月7日 下午3:50:19 
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
