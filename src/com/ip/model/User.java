package com.ip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by windkl on 2017/4/11.
 */
@Entity
@Table(name="User")
public class User {
	@Id
    @GeneratedValue
    private int id;
	private String name;
	private String password;
	private String telephone;
	private String email;
    private int role;
    
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
		this.telephone=telephone;
	}
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}
