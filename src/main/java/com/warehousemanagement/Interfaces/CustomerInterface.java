package com.warehousemanagement.Interfaces;

import org.springframework.data.repository.CrudRepository;

import com.warehousemanagement.Bean.CustomerInfo;


public interface CustomerInterface extends CrudRepository<CustomerInfo,Integer>{

}
