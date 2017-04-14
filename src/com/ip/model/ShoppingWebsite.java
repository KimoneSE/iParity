package com.ip.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by windkl on 2017/4/11.
 */
@Entity
@Table(name="ShoppingWebsite")
public class ShoppingWebsite {
	private int id;
	private String name;
	private String url;
//    Set<Seller> sellers;

    public ShoppingWebsite() {
    }

    @Id
    @Column(name="id")
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
//    public Set<Seller> getSellers() {
//        return sellers;
//    }
//
//    public void setSellers(Set<Seller> sellers) {
//        this.sellers = sellers;
//    }
}
