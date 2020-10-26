package com.diego.userlevels.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diego.userlevels.entity.Progress;

public interface ProgressService {
	
	public Iterable<Progress> findAll();
	
	public Page<Progress> findAll(Pageable pageable);
	
	public Optional<Progress> findById(Long id);
	
	public Progress save(Progress progress);
	
	public void deleteById(Long id);

}
