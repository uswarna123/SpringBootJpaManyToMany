package com.example.demo.repository;

import com.example.demo.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface stateRepository extends JpaRepository<State,Long> {
}
