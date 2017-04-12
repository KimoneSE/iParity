package com.ip.model;

import org.hibernate.annotations.GenericGenerator;

import java.awt.Image;

import javax.persistence.*;

/**
 * Created by windkl on 2017/4/11.
 */
@Entity
@Table(name="Ad")
public class Ad {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    
    private int id;
    Image bg;
    String content;
    
    @JoinColumn(name="lk")
    Link link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getBg() {
    	return bg;
    }
    
    public void setBg(Image bg) {
		this.bg=bg;
	}
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Link getLink() {
		return link;
	}
    
    public void setLink(Link link) {
		this.link=link;
	}
    
}
