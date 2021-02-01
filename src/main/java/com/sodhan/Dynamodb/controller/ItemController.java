package com.sodhan.Dynamodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sodhan.Dynamodb.entity.Inventory;
import com.sodhan.Dynamodb.repository.ItemRepository;

@RestController
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostMapping("/inventory")
	public Inventory saveItem(@RequestBody Inventory inventory) {
		return itemRepository.save(inventory);
		}
	
	@GetMapping("/inventory/{id}")
	public Inventory getItem(@PathVariable("id")String itemId) {
		return itemRepository.getItemById(itemId);
	}

	@DeleteMapping("/inventory/{id}")
	public String deleteemployee(@PathVariable("id")String itemId) {
		return itemRepository.delete(itemId);
	}
	
	@PutMapping("/inventory/{id}")
	public String updateEmployee(String itemId, @RequestBody Inventory inventory) {
		return itemRepository.update(itemId, inventory);
	}
}
