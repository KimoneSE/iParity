package com.ip.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by windkl on 2017/4/11.
 */
@Entity
@Table()
public class Ad {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    @ManyToOne
    @JoinColumn(name="id")
    Product product;

    @Column
    String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Ad() {
    }

    public Ad(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
