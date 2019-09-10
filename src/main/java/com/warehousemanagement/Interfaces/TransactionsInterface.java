package com.warehousemanagement.Interfaces;

import org.springframework.data.repository.CrudRepository;

import com.warehousemanagement.Bean.Transactions;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface TransactionsInterface extends CrudRepository<Transactions,Integer>{
	
		@Query("from Transactions where transaction_date=?1 order by transaction_id")
		List<Transactions> findByTransaction_dateSorted(Date trandate);
	
}
