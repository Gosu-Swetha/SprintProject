package com.cg.ofda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ofda.dto.FoodCartDto;

public interface ICartRepository extends JpaRepository<FoodCartDto, String>{

}
