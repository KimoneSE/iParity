package com.ip.model;

import java.net.URL;

/**
 * Created by windkl on 2017/4/11.
 */
public class Link {
    URL url;

    public Link(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Link() {
    }
}
