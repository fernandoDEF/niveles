package com.diego.userlevels.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.userlevels.entity.Progress;
import com.diego.userlevels.service.ProgressService;


@RestController
@RequestMapping("progress")
public class ProgressControl {
	
	@Autowired
	private ProgressService progressService;
	
	//create new progress
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Progress progress){
		return ResponseEntity.status(HttpStatus.CREATED).body(progressService.save(progress));
	}
	
	//read an progress
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long progressId){
        Optional<Progress> oProgress =	progressService.findById(progressId);
        
        if(!oProgress.isPresent()) {
        	return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oProgress);
	}

    //Update an progress
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Progress progressDetails, @PathVariable(value = "id") Long progressId){
		Optional<Progress> progress = progressService.findById(progressId);
		 
		if(!progress.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//BeanUtils.copyProperties(userLevelsDetails, userlevels);
		progress.get().setType(progressDetails.getType());
		progress.get().setName(progressDetails.getName());
		progress.get().setAdvance(progressDetails.getAdvance());
		progress.get().setEnable(progressDetails.getEnable());
		return ResponseEntity.status(HttpStatus.CREATED).body(progressService.save(progress.get()));
	}
	
    //delete an progress
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long ProgressId){
		if(!progressService.findById(ProgressId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		progressService.deleteById(ProgressId);
		return ResponseEntity.ok().build();
	}
	
	//read all progress
	@GetMapping("/allProgress")
	public List<Progress> realAll (){
		List<Progress> progress = StreamSupport
				.stream(progressService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return progress;
    }
}
