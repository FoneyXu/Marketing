package org.marketing.service;

import org.marketing.model.Customer;
import org.marketing.util.Prompt;

public interface CustomerService {
	
	/**
	 * 
	 * @Description: 增加用户
	 * @method addCustomer
	 * @param @param customer
	 * @param @return 
	 * @return Prompt  
	 * @author foney
	 * @date 2017年9月19日 上午9:35:56
	 */
	Prompt addCustomer(Customer customer);
	
	/**
	 * 
	 * @Description: 删除用户
	 * @method deleteCustomer
	 * @param @param customerId
	 * @param @return 
	 * @return Prompt  
	 * @author foney
	 * @date 2017年9月19日 上午9:35:53
	 */
	Prompt deleteCustomer(Integer customerId);
	
	/**
	 * 
	 * @Description: 修改用户
	 * @method updateCustomer
	 * @param @param customer
	 * @param @return 
	 * @return Prompt  
	 * @author foney
	 * @date 2017年9月19日 上午9:35:48
	 */
	Prompt updateCustomer(Customer customer);
	
	/**
	 * 
	 * @Description: 根据编号查询用户
	 * @method findCustomerById
	 * @param @param customerId
	 * @param @return 
	 * @return Prompt  
	 * @author foney
	 * @date 2017年9月19日 上午9:35:35
	 */
	Prompt findCustomerById(Integer customerId);
	
	/**
	 * 
	 * @Description: 查找所有用户
	 * @method findAllCustomer
	 * @param @return 
	 * @return Prompt  
	 * @author foney
	 * @date 2017年9月19日 上午9:35:21
	 */
	Prompt findAllCustomer();
	
	/**
	 * 
	 * @Description: 登录
	 * @method login
	 * @param @param phone
	 * @param @param password
	 * @param @return 
	 * @return Prompt  
	 * @author foney
	 * @date 2017年9月19日 上午9:35:11
	 */
	Prompt login(String phone,String password);
	
}
