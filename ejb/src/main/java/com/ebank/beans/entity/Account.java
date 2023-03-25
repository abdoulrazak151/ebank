package com.ebank.beans.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="accounts")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
public class Account implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double solde;
    @NotNull
    @Column(name="creation_date")
    @Temporal(value=TemporalType.DATE)
    private Date dateCreation;
    @JoinColumn(name="customer_id", referencedColumnName="id", nullable=false)
    @ManyToOne(fetch=FetchType.LAZY, targetEntity=Customer.class, cascade=CascadeType.ALL, optional = false)
    private Customer customer;

    @OneToMany(fetch=FetchType.LAZY, targetEntity = Operation.class, cascade = CascadeType.ALL, mappedBy="account")
    private List<Operation> operations;
    
    
    public List<Operation> getOperations() {
        return operations;
    }
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
}
