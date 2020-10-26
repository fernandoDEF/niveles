package com.diego.userlevels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.userlevels.entity.Progress;

@Repository
public interface ProgressRepo extends JpaRepository<Progress,Long> {

}
