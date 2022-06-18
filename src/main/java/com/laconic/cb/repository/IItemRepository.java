package com.laconic.cb.repository;

import com.laconic.cb.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "update ITEM set IS_DELETED = 1 where ITEM_ID=:itemId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteItem(Long itemId);

    Optional<Item> findByItemIdAndIsDeletedFalse(Long itemId);

    Page<Item> findAllByIsDeletedFalse(Pageable pageable);
    List<Item> findAllByIsDeletedFalse();

    long countByIsDeletedFalse();
}
