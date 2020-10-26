package com.diego.userlevels.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classification")
public class Classification implements Serializable{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="level",length = 50, nullable=false)
	private String level;
	
	@Column(name="type", nullable=false, length = 20)
    private String type;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
    }
    
    public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
    }
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
}
