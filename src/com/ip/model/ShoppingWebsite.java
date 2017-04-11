package model;

import java.util.Set;

/**
 * Created by windkl on 2017/4/11.
 */
public class ShoppingWebsite {
    double balance;
    Set<Seller> sellers;

    public ShoppingWebsite() {
    }

    public ShoppingWebsite(double balance, Set<Seller> sellers) {
        this.balance = balance;
        this.sellers = sellers;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Set<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(Set<Seller> sellers) {
        this.sellers = sellers;
    }
}
