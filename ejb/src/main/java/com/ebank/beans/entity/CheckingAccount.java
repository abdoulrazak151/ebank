package com.ebank.beans.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="checking_accounts")
@DiscriminatorValue(value="CA")
public class CheckingAccount extends Account {
    @Column(name="overdraft", nullable=false)
    private double overdraft;

    public double getOverdraft() {

        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
    

    
}
