package com.ip.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	private String id;
	// 商品名称
	private String product;
	// 分类名称
	private String typeName;
	// 是一个商店还是一个概括(概括是null)
	private String parent;
	// 库存(抓不到)
	private int storage;
	// 商店名
	private String store;
	// 商店链接
	private String storeLink;
	// 价格
	private String price;
	// 图片链接(都有)
	private String imageLink;
	// 成交量(抓不到)
	private int volumn;
	// 描述(只有概括有)
	private String description;
	// 客户评分(只有概括有)
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getStoreLink() {
		return storeLink;
	}

	public void setStoreLink(String storeLink) {
		this.storeLink = storeLink;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}
}
