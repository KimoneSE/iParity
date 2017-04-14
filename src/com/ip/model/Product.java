package com.ip.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by windkl on 2017/4/11.
 */
@Entity
@Table(name="product")

public class Product {

	@Id
	private int id;
    private String name;
    private String link;
    private String seller;
    private double volume;
    private double reliability;
    private String description;
    double price;

    public Product() {
    }

	public Product(int id, String name, String link, String seller, double volume, double reliability,
			String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.seller = seller;
		this.volume = volume;
		this.reliability = reliability;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getReliability() {
		return reliability;
	}

	public void setReliability(double reliability) {
		this.reliability = reliability;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
