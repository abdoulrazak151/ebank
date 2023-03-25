package com.ebank.beans.sessions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import com.ebank.beans.entity.Account;
import com.ebank.beans.entity.Customer;
import com.ebank.interceptors.LifeCycleInterceptor;
import com.ebank.interceptors.LogingInterceptors;

import jakarta.ejb.Singleton;
import jakarta.interceptor.Interceptors;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Singleton
@Interceptors({ LifeCycleInterceptor.class })
public class AccountManager {

@PersistenceContext
private EntityManager em;

 //creation de la liste dans laquelle on va stocker les compte

//generer les setter et les getters
//====================================================

 //====================================================
  //creation de la methode creation de compte
  public Account create(long customerId,Account account){
    Customer customer=em.find(Customer.class, customerId);
    if(customer==null){
        throw new RuntimeErrorException(null, "customer "+customerId+" not found");
    }
    account.setCustomer(customer);
  em.persist(account);
  return account;
}

  
/*
    public void create(Account account){
        Long code = account.getCode();
        if(accounts.get(code) != null){
            throw new RuntimeErrorException(null, "Account already exists.");
        }
        accounts.put(code,account);
    }*/
    //chercher un copmte
    public Account find(int id){
        Account account = em.find(Account.class, id);
        if(account == null){
            throw new RuntimeErrorException(null, "Account not found.");
        }
        return account;
       
    }
    public List<Account> findAll() {
       return em.createQuery("SELECT a FROM accounts a JOIN FETCH a.customer",Account.class).getResultList();
    }
    //deposer sur un compte
    public Account deposit(int id, double amount){
        
        Account account = find(id);
        double newBalance=account.getSolde()+amount;
        account.setSolde(newBalance);
       
        if(amount <= 0){
            throw new RuntimeErrorException(null, "Amout must be positive.");
        }
        em.merge(account);
        return account;
    }
  public Account retrait(int id, double amount){
    Account account = find(id);
    double newBalance=account.getSolde()-amount;
    account.setSolde(newBalance);
   
    if(amount <= 0){
        throw new RuntimeErrorException(null, "Amout must be positive.");
    }
    em.merge(account);
    return account;

    }


    public void delete(int id){
       em.remove(find(id));
    }
}