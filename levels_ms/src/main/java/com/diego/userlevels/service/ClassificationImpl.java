package com.diego.userlevels.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Iterable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diego.userlevels.entity.Classification;
import com.diego.userlevels.repository.ClassificationRepo;

@Service
public class ClassificationImpl implements ClassificationService {

    @Autowired
	private ClassificationRepo classificationrepo;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Classification> findAll() {
		return classificationrepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Classification> findAll(Pageable pageable) {
		return classificationrepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Classification> findById(Long id) {
		return classificationrepo.findById(id);
	}

	@Override
	@Transactional
	public Classification save(Classification classification) {
		return classificationrepo.save(classification);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		classificationrepo.deleteById(id);
	}
    
}
