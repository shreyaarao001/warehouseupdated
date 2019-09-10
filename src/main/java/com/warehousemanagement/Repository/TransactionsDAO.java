package com.warehousemanagement.Repository;



import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.warehousemanagement.Bean.Transactions;
import com.warehousemanagement.Interfaces.TransactionsInterface;
/*
 * These class is like dao which is used for transaction where we will get data from customer_info,
 * item_info and we will check if it is present in transactions table
 *
 */
@Service
@Component
@EnableAutoConfiguration
public class TransactionsDAO {
	/*
	 *  autowired is use to auto wire bean on the setter method, constructor or a field.
	 */
	@Autowired
	TransactionsInterface transactionsinterface;
	
	//These method is used to create transaction,if transaction is succesful it will enter in these block of code.
	public String createTransaction(Transactions tran) {
		  transactionsinterface.save(tran);
		   String status;
		   //if date is not null it will go in these block of code.
		   if (tran.getTransaction_date()!=null)
			   status="Transaction Successful with transaction Id: "+tran.getTransaction_id();
		   //if date is null it will enter in these block of code
		   else
			   status="Transaction failed";
			return status; 
	}

	
//if we want to cancel oder it will in these block of code
	public String deleteTransaction(String tranid) {
		int transaction_id=Integer.parseInt(tranid);
		Optional<Transactions> tranobj=transactionsinterface.findById(transaction_id);
		String reply;
		//if transaction_date is not null it will enter in these block of code
		if(tranobj.get().getTransaction_date()!=null) {
		transactionsinterface.deleteById(transaction_id);
		    reply="Transaction deleted successfully";
		}
		//if transaction_date is null it will enter in these block of code.
		else
			 reply="Transaction not found";
		return reply;
	}


//these method is used to display transactions using list.
	public List<Transactions> displayTransactions(String tdate) {
		Date trandate=Date.valueOf(tdate);
		List<Transactions> tranObj=(List<Transactions>) transactionsinterface.findByTransaction_dateSorted(trandate);
		return tranObj;
	}

	

}
