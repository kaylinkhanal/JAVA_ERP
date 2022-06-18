package com.laconic.cb.service;

import com.laconic.cb.model.Item;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IItemService {
    Item saveItem(Item item);
    Item updateItem(Item item);

    Page<Item> getAllItems(int pageNo);

    long getTotalItems();

    void softDeleteItem(Long id);

    Optional<Item> findById(Long id);
}
