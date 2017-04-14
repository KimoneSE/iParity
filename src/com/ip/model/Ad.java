package com.ip.model;


import javax.persistence.*;

/**
 * Created by windkl on 2017/4/11.
 */
@Entity
@Table(name="Ad")
public class Ad {
    @Id    
    private int id;
    private String  imgurl;
    private String linkurl;
    private String content;
    
    public Ad(){
    	
    }
    
    public Ad(int id, String imgurl, String content,String linkurl) {
		super();
		this.id = id;
		this.imgurl = imgurl;
		this.linkurl = linkurl;
		this.content = content;
	}

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

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getLinkurl() {
		return linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
    
}