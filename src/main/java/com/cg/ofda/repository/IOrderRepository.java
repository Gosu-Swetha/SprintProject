package com.cg.ofda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.ofda.dto.OrderDetailsDto;
@Repository

public interface IOrderRepository extends JpaRepository < OrderDetailsDto, Integer> {

}

