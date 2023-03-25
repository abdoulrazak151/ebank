package com.ebank.beans.entity;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="savings_accounts")
@DiscriminatorValue(value="SA")
public class SavingsAccount extends Account{
    @Column(name="interest_rate")
    private float interestRate;

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }
    
}
