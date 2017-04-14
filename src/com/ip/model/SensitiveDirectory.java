package com.ip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sensitivedirectory")
public class SensitiveDirectory {

	@Id
	@GeneratedValue
	private int id;
	
	private String word;

	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="word")
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
}
