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

import com.diego.userlevels.entity.Classification;
import com.diego.userlevels.service.ClassificationService;

@RestController
@RequestMapping("classification")
public class ClassificationControl {
    
    @Autowired
	private ClassificationService classificationService;
	
	//create new classification
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Classification classification){
		return ResponseEntity.status(HttpStatus.CREATED).body(classificationService.save(classification));
	}
	
	//read an classification
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long classificationId){
        Optional<Classification> oClassificationService = classificationService.findById(classificationId);
        
        if(!oClassificationService.isPresent()) {
        	return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oClassificationService);
	}

    //Update an classification
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Classification classificationDetails, @PathVariable(value = "id") Long classificationId){
		Optional<Classification> classification = classificationService.findById(classificationId);
		 
		if(!classification.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//BeanUtils.copyProperties(userLevelsDetails, userlevels);
		classification.get().setLevel(classificationDetails.getLevel());
		classification.get().setType(classificationDetails.getType());
		return ResponseEntity.status(HttpStatus.CREATED).body(classificationService.save(classification.get()));
	}
	
    //delete an classification
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long classificationId){
		if(!classificationService.findById(classificationId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		classificationService.deleteById(classificationId);
		return ResponseEntity.ok().build();
	}
	
	//read all classification
	@GetMapping("/allClassification")
	public List<Classification> realAll (){
		List<Classification> classification = StreamSupport
				.stream(classificationService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return classification;
    }
}
