package com.diego.userlevels.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Iterable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diego.userlevels.entity.Progress;
import com.diego.userlevels.repository.ProgressRepo;

@Service
public class ProgressImpl implements ProgressService{

	@Autowired
	private ProgressRepo progressrepo;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Progress> findAll() {
		return progressrepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Progress> findAll(Pageable pageable) {
		return progressrepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Progress> findById(Long id) {
		return progressrepo.findById(id);
	}

	@Override
	@Transactional
	public Progress save(Progress progress) {
		return progressrepo.save(progress);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		progressrepo.deleteById(id);
	}
}
