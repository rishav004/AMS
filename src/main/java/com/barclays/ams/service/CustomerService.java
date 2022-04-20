package com.barclays.ams.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.barclays.ams.dao.CustomerDao;
import com.barclays.ams.dao.UsersDao;
import com.barclays.ams.entity.Customer;
import com.barclays.ams.entity.ResponseStructure;
import com.barclays.ams.entity.Users;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private EmailSenderService emailSenderService;
	@Autowired
	private UsersDao usersDao;

	private Users user = new Users();

	public void triggerMail(Customer customer) throws MessagingException {
		emailSenderService.sendMail(customer.getEmail(), "View: Account update for your JDBC Bank A/c", "Dear "
				+ customer.getName()
				+ ",\n\n\nCongratulations !!! Your account has been successfully created with us.\n\n"
				+ "Please find your Customer ID and Temporary password below\n\n" + "Customer ID: " + customer.getCid()
				+ "\nTemporary Passcode: " + user.getPasscode() + "\n\n"
				+ "You are required to change your password after first login.\n\n\n Warm Regards, \n JDBC Bank");
	}

	public ResponseStructure<Customer> addCustomer(Customer customer) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Saved Data");
		Customer savedCustomer = customerDao.addCustomer(customer);
		if (savedCustomer != null) {
			try {
				triggerMail(savedCustomer);
				user.setUid(savedCustomer.getCid());
				usersDao.addUser(user);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

		responseStructure.setData(savedCustomer);
		return responseStructure;

	}

	public ResponseStructure<List<Customer>> getAll() {
		ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("All Customer Data");
		responseStructure.setData(customerDao.getAll());
		return responseStructure;
	}

}
