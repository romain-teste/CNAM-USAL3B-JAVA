package com.CH.DB.JPA;

import com.CH.DB.JPA.table.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenarioRepo extends JpaRepository<TableSenario,Integer> {

}
