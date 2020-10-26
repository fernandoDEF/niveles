package com.diego.userlevels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.userlevels.entity.Classification;

@Repository
public interface ClassificationRepo extends JpaRepository<Classification,Long> {
    
}
