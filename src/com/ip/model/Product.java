package model;

import java.util.List;
import java.util.Set;

/**
 * Created by windkl on 2017/4/11.
 */
public class Product {

    Set<Ad> ads;
    List<Comment> comments;
    Set<Link> links;
    double price;

    public Product() {
    }

    public Product(Set<Ad> ads, List<Comment> comments, Set<Link> links, double price) {
        this.ads = ads;
        this.comments = comments;
        this.links = links;
        this.price = price;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
