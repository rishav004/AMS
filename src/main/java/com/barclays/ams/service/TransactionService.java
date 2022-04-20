package com.barclays.ams.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.ams.dao.CustomerDao;
import com.barclays.ams.dao.TransactionDao;
import com.barclays.ams.dao.TransactionDetailsDao;
import com.barclays.ams.entity.BankAccount;
import com.barclays.ams.entity.Customer;
import com.barclays.ams.entity.Transaction;
import com.barclays.ams.entity.TransactionDetails;
import com.barclays.ams.repository.BankAccountRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private EmailSenderService emailSenderService;

	private TransactionDetails transactionDetails;

	@Autowired
	private BankAccountRepository bankAccountRepo;

	@Autowired
	private TransactionDetailsDao transactionDetailsDao;

	@Autowired
	private CustomerDao customerDao;

	public void triggerMailforDebit(TransactionDetails transactionDetails) throws MessagingException {
		Customer customer = customerDao.getByCid(transactionDetails.getCid());
		emailSenderService.sendMail(customer.getEmail(), "View: Account update for JDBC Bank A/c",
				"Dear " + customer.getName() + ",\n\n" + "Rs. " + transactionDetails.getAmount()
						+ " has been debited from your\naccount number: " + transactionDetails.getAccno() + " on "
						+ transactionDetails.getDate() + ".\n\nYour UPI transaction reference number is "
						+ transactionDetails.getReferenceno() + ".\n\n"
						+ "Please call on 1800-5694-123 to report if this transaction was not authorized by you.\n\n\n"
						+ "Warm Regards,\nJDBC Bank");
	}

	public void triggerMailCredit(TransactionDetails transactionDetails) throws MessagingException {
		Customer customer = customerDao.getByCid(transactionDetails.getCid());
		emailSenderService.sendMail(customer.getEmail(), "View: Account update for JDBC Bank A/c",
				"Dear " + customer.getName() + ",\n\n" + "Rs. " + transactionDetails.getAmount()
						+ " has been credited to your \naccount number: " + transactionDetails.getAccno() + " on "
						+ transactionDetails.getDate() + ".\n\nYour UPI transaction reference number is "
						+ transactionDetails.getReferenceno() + ".\n\n"
						+ "Please call on 1800-5694-123 to report if this transaction was not authorized by you.\n\n\n"
						+ "Warm Regards,\nJDBC Bank");
	}

	public String addTransaction(Transaction transaction) {
		String s = "";
		List<BankAccount> lba = bankAccountRepo.findAll();
		transactionDetails = new TransactionDetails();
		for (BankAccount b : lba) {
			if (b.getAccno() == transaction.getAccno()) {
				if (transaction.getType().equals("debit")) {
					if (transaction.getSubtype().equals("cash")) {
						if (b.getBalance() == 0) {
							s += "Your account balance is 0.\n";
							return s;
						} else if (b.getBalance() < transaction.getAmount()) {
							s += "Insufficient Balance.\n";
							return s;
						} else if (transactionDetailsDao.getTotalAmountPerDay(transaction.getAccno())
								+ transaction.getAmount() >= 10000 && transaction.getAmount() < 10000) {
							if ((10000 - (transactionDetailsDao.getTotalAmountPerDay(transaction.getAccno())
									+ transaction.getAmount())) < 0) {
								double k = 10000 - transactionDetailsDao.getTotalAmountPerDay(transaction.getAccno());
								s += "Please enter amount less than " + k;
							} else {
								s += "Allowed per day limit exceeded. Please visit tomorrow\n";
							}
							return s;
						} else if (transaction.getAmount() > 10000) {
							s += "Allowed limit exceeded. Please enter amount less than Rs.10,000/-.\n";
							return s;
						} else {
							float bal = b.getBalance() - transaction.getAmount();
							b.setBalance(bal);
							transactionDetails.setBalance(bal);
							transactionDetails.setType(transaction.getType());
							transactionDetails.setSubtype(transaction.getSubtype());
							transactionDetails.setAmount(transaction.getAmount());
							transactionDetails.setCid(b.getCid());
							transactionDetails.setAccno(transaction.getAccno());
							transactionDetailsDao.addTransactionDetails(transactionDetails);
							s += "Amount debited successfully " + transaction.getAmount() + "\n";
							try {
								triggerMailforDebit(transactionDetails);
							} catch (MessagingException e) {
								e.printStackTrace();
							}
						}
					}
				} else if (transaction.getType().equals("credit")) {
					if (transaction.getSubtype().equals("cash")) {
						float bal = b.getBalance() + transaction.getAmount();
						b.setBalance(bal);
						transactionDetails.setBalance(bal);
						transactionDetails.setType(transaction.getType());
						transactionDetails.setSubtype(transaction.getSubtype());
						transactionDetails.setAmount(transaction.getAmount());
						transactionDetails.setCid(b.getCid());
						transactionDetails.setAccno(transaction.getAccno());
						transactionDetailsDao.addTransactionDetails(transactionDetails);
						s += "Money added successfully\n";
						try {
							triggerMailCredit(transactionDetails);
						} catch (MessagingException e) {
							e.printStackTrace();
						}
					}
				}

				transactionDao.addTransaction(transaction);
				s += "Thank You!!! Visit again.";
			}

		}
		return s;
	}

}