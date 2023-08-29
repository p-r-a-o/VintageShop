package com.example.jpabook.jpashop.service;

import com.example.jpabook.jpashop.domain.item.Item;
import com.example.jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, String brand, int price, int stockQuantity, String gender, String material) {
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(name);
        findItem.setBrand(brand);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
        findItem.setGender(gender);
        findItem.setMaterial(material);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
