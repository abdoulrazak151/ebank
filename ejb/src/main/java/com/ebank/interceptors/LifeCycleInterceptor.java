package com.ebank.interceptors;

import java.util.Date;

import com.ebank.beans.entity.Account;
import com.ebank.beans.entity.CheckingAccount;
import com.ebank.beans.entity.Customer;
import com.ebank.beans.entity.OldAccount;
import com.ebank.beans.entity.SavingsAccount;
import com.ebank.beans.sessions.AccountManager;

import jakarta.annotation.PostConstruct;
import jakarta.interceptor.InvocationContext;

public class LifeCycleInterceptor {
  
  
  
  
    @PostConstruct //ajouter un compte
    public void init(InvocationContext context){
        //recuperation d'une instance de notre ejb accountManager
        AccountManager accountManager = (AccountManager) context.getTarget();
        //====================================================================
        SavingsAccount account1=new SavingsAccount();
        CheckingAccount account2=new CheckingAccount();
        account1.setInterestRate(10);
        account1.setSolde(1500);
        account1.setDateCreation(new Date());
        Customer customer=new Customer();
        customer.setNom("Miro Miki"); 
        account2.setDateCreation(new Date());
        account2.setOverdraft(5000);
        accountManager.create(1, account2);  
         
      }

  
    
}
