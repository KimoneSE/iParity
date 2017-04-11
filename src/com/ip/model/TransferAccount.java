package com.ip.model;

/**
 * Created by windkl on 2017/4/11.
 */
public class TransferAccount {
    User from;
    User to;
    double num;

    public TransferAccount() {
    }

    public TransferAccount(User from, User to, double num) {
        this.from = from;
        this.to = to;
        this.num = num;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }
}
