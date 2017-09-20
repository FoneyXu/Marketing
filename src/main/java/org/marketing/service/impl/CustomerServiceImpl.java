package org.marketing.service.impl;

import org.marketing.model.Customer;
import org.marketing.service.CustomerService;
import org.marketing.util.Prompt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Override
	public Prompt addCustomer(Customer customer) {
		return null;
	}

	@Override
	public Prompt deleteCustomer(Integer customerId) {
		return null;
	}

	@Override
	public Prompt updateCustomer(Customer customer) {
		return null;
	}

	@Override
	public Prompt findCustomerById(Integer customerId) {
		return null;
	}

	@Override
	public Prompt findAllCustomer() {
		return null;
	}

	@Override
	public Prompt login(String phone, String password) {
		return null;
	}

}
