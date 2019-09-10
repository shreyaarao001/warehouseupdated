package com.warehousemanagement.Interfaces;

import java.util.List;

import javax.transaction.Transactional;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.warehousemanagement.Bean.ItemInfo;
@Repository
public interface ItemInterface extends CrudRepository<ItemInfo,Integer>{
	
}

