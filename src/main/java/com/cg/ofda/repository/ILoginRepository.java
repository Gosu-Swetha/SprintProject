package com.cg.ofda.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.ofda.dto.LoginDto;

@Repository

public interface ILoginRepository extends JpaRepository < LoginDto, String>{

}

