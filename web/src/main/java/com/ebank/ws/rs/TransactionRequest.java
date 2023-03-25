package com.ebank.ws.rs;

public class TransactionRequest{
    private Long code;
    private double amount;
    public TransactionRequest() {
    }
    public int getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}