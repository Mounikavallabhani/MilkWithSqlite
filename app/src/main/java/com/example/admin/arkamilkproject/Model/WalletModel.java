package com.example.admin.arkamilkproject.model;

public class WalletModel {
    String wallettransition;
    String walletstatus;

    public WalletModel(String wallettransition, String walletstatus) {
        this.wallettransition = wallettransition;
        this.walletstatus = walletstatus;
    }

    public String getWallettransition() {
        return wallettransition;
    }

    public void setWallettransition(String wallettransition) {
        this.wallettransition = wallettransition;
    }

    public String getWalletstatus() {
        return walletstatus;
    }

    public void setWalletstatus(String walletstatus) {
        this.walletstatus = walletstatus;
    }
}