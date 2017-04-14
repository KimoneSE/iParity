package com.ip.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by windkl on 2017/4/11.
 */
@Entity
@Table(name="user")

public class User {
    double balance;
    List<Product> buyed;
    String email;
    int id;
    String name;
    String telephonr;
    Set<TransferAccount> transfer;

    Set<Product> products;

    public User() {
    }

    public User(double balance, List<Product> buyed, int id, String email, String name, String telephonr, Set<TransferAccount> transfer) {
        this.balance = balance;
        this.buyed = buyed;
        this.id = id;
        this.email = email;
        this.name = name;
        this.telephonr = telephonr;
        this.transfer = transfer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Product> getBuyed() {
        return buyed;
    }

    public void setBuyed(List<Product> buyed) {
        this.buyed = buyed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelephonr() {
        return telephonr;
    }

    public void setTelephonr(String telephonr) {
        this.telephonr = telephonr;
    }

    public Set<TransferAccount> getTransfer() {
        return transfer;
    }

    public void setTransfer(Set<TransferAccount> transfer) {
        this.transfer = transfer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
