package com.cg.ofda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.ofda.dto.RestaurantDto;

@Repository
	public interface IRestaurantRepository extends JpaRepository<RestaurantDto,String>{
		
	}

