package com.sodhan.Dynamodb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.sodhan.Dynamodb.entity.Inventory;

@Repository
public class ItemRepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public Inventory save(Inventory inventory) {
		
		dynamoDBMapper.save(inventory);
		return inventory;
	}
	
	public Inventory getItemById(String itemId) {
		
		return dynamoDBMapper.load(Inventory.class, itemId);
	}
	
	public String delete(String itemId) {
		
		Inventory itm = dynamoDBMapper.load(Inventory.class, itemId);
		dynamoDBMapper.delete(itm);
		return "Item Deleted";
	}
	
	public String update(String itemId, Inventory inventory) {
		
		dynamoDBMapper.save(inventory, 
				new DynamoDBSaveExpression()
				.withExpectedEntry(itemId, new ExpectedAttributeValue(
						new AttributeValue().withS(itemId))));
		
		return itemId;
	}

}
