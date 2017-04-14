package com.ip.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by windkl on 2017/4/11.
 */

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	private int id;
	private int uid;
    private String pname;
    private String content;
    private Date datetime;

    public Comment() {
    }

    public Comment(int id, int uid, String pname, String content, Date datetime) {
		super();
		this.id = id;
		this.uid = uid;
		this.pname = pname;
		this.content = content;
		this.datetime = datetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
