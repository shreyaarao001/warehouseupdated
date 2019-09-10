package com.warehousemanagement.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.warehousemanagement.Bean.CustomerInfo;
import com.warehousemanagement.Bean.ItemInfo;
import com.warehousemanagement.Interfaces.CustomerInterface;
import com.warehousemanagement.Interfaces.ItemInterface;
/*
 * These class is like DAO where we can add,delete and update.
 */
@Service
@Component
@EnableAutoConfiguration
public class ItemInfoDAO {
	@Autowired
	ItemInterface iteminterface;
	
//These method is used to add item using save
	public String addItem(ItemInfo item) {
		iteminterface.save(item);
		return "Item inserted successfully where item_id is:"+item.getItem_id();
	}

//These method is used to check item using get and set from bean class.
	public ItemInfo check(String item) {
		ArrayList<ItemInfo> iteminfoObj=(ArrayList<ItemInfo>) iteminterface.findAll();
		ItemInfo itemObj=new ItemInfo();
		int item_id=Integer.parseInt(item);
		for (int i = 0; i < iteminfoObj.size(); i++) {
			if(item_id==iteminfoObj.get(i).getItem_id()) {
				itemObj.setItem_id(iteminfoObj.get(i).getItem_id());
				itemObj.setName(iteminfoObj.get(i).getName());
				itemObj.setPrice(iteminfoObj.get(i).getPrice());
				itemObj.setStock(iteminfoObj.get(i).getStock());
			}
		}
		return itemObj;
	}

//These method is used to view item based on item_id using list.
	public ItemInfo viewItem(String item) {
		int item_id=Integer.parseInt(item);
		ArrayList<ItemInfo> iteminfoObj=(ArrayList<ItemInfo>) iteminterface.findAll();
		ItemInfo itemObj=new ItemInfo();
		for (int i = 0; i < iteminfoObj.size(); i++) {
			if(item_id==iteminfoObj.get(i).getItem_id()) {
				itemObj.setItem_id(iteminfoObj.get(i).getItem_id());
				itemObj.setName(iteminfoObj.get(i).getName());
				itemObj.setPrice(iteminfoObj.get(i).getPrice());
				itemObj.setStock(iteminfoObj.get(i).getStock());
			}
		}
		return itemObj;
	}

//These method is used to add stock to previous stock ,in these first we will find stock and we will add stock and after we will save it.
	public String addStock(int id, String stock) {
		int stock1=Integer.parseInt(stock);
		ItemInfo itemobj=iteminterface.findById(id).orElse(new ItemInfo());
		itemobj.setStock(itemobj.getStock()+stock1);
		iteminterface.save(itemobj);
		String reply="Stock Changed to "+itemobj.getStock();
		return reply;
	}


	
}


