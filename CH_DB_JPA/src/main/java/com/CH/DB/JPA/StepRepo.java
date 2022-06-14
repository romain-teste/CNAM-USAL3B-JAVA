package com.CH.DB.JPA;

import com.CH.DB.JPA.table.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepo extends JpaRepository<TableStep,Integer> {
	   
}
