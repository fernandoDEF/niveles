package com.diego.userlevels.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diego.userlevels.entity.Classification;

public interface ClassificationService {

    public Iterable<Classification> findAll();
	
	public Page<Classification> findAll(Pageable pageable);
	
	public Optional<Classification> findById(Long id);
	
	public Classification save(Classification classification);
	
	public void deleteById(Long id);
    
}
