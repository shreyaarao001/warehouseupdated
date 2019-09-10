package com.warehousemanagement.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

import com.warehousemanagement.Bean.Transactions;
import com.warehousemanagement.Interfaces.TransactionsInterface;
import com.warehousemanagement.Repository.TransactionsDAO;
/*
 * These class is like rest when we specify url it will come this class
 */
@RestController
@RequestMapping("transactions")
public class TransactionRest {
	/*
	 *  autowired is use to auto wire bean on the setter method, constructor or a field.
	 */
	@Autowired
	TransactionsDAO transactionsdao;
	@Autowired
	TransactionsInterface transactionsinterface;
	
	//these method is used add transaction inforamtion and we will call dao call in these method
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	   public String createTransactrion(@RequestBody Transactions tran) {
		   String status=transactionsdao.createTransaction(tran);
			return status; 
	   }
	//these method is used check transation inforamtion and we will call dao call in these method
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	   public List<Transactions> findTransaction(@RequestBody String trandate) {  
		List<Transactions> tranObj=transactionsdao.displayTransactions(trandate);
		 return tranObj; 
	   }
	//these method is used delete transaction inforamtion and we will call dao call in these method
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	   public String deleteTransactrion(@RequestBody String tranid) {
		   String status=transactionsdao.deleteTransaction(tranid);
			return status; 
	   }
	

}
