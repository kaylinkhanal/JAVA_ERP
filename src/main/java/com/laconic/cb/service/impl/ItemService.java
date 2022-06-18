package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Item;
import com.laconic.cb.repository.IItemRepository;
import com.laconic.cb.service.IItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService implements IItemService {

    private final IItemRepository itemRepository;

    public ItemService(IItemRepository iItemRepository) {
        this.itemRepository = iItemRepository;
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.saveAndFlush(item);
    }

    @Override
    public Page<Item> getAllItems(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return itemRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public long getTotalItems() {
        return itemRepository.countByIsDeletedFalse();
    }

    @Override
    public void softDeleteItem(Long id) {
        itemRepository.softDeleteItem(id);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }
}
