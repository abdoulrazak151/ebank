package com.ebank.beans.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="transactions")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name ="type",discriminatorType = DiscriminatorType.CHAR)
public abstract class Operation implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date dateOperation;
    private double amount;
    @JoinColumn(name="account_id", referencedColumnName="id")
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional = false, targetEntity=Operation.class)
    private Account account;
    public void setId(long id) {
        this.id = id;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDateOperation() {
        return dateOperation;
    }
    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
