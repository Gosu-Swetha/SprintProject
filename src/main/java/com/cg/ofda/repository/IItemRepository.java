package com.cg.ofda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.ofda.dto.ItemDto;

@Repository
public interface IItemRepository extends JpaRepository<ItemDto, String>{

}