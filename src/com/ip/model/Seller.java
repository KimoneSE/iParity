package model;

import java.util.Set;

/**
 * Created by windkl on 2017/4/11.
 */
public class Seller {
    double balance;
    Set<Product> products;

    Set<TransferAccount> transferAccounts;

    public Seller() {
    }

    public Seller(double balance, Set<Product> products) {
        this.balance = balance;
        this.products = products;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Seller(double balance, Set<Product> products, Set<TransferAccount> transferAccounts) {
        this.balance = balance;
        this.products = products;
        this.transferAccounts = transferAccounts;
    }

    public Set<TransferAccount> getTransferAccounts() {
        return transferAccounts;
    }

    public void setTransferAccounts(Set<TransferAccount> transferAccounts) {
        this.transferAccounts = transferAccounts;
    }
}
