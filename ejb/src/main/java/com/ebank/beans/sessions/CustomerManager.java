package com.ebank.beans.sessions;

import java.util.List;

import com.ebank.beans.entity.Customer;
import com.ebank.interceptors.LifeCycleInterceptor;

import jakarta.ejb.Singleton;

import jakarta.interceptor.Interceptors;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Singleton @Interceptors({LifeCycleInterceptor.class})
public class CustomerManager {
    @PersistenceContext
 private EntityManager em;

 
 public Customer create(Customer customer){
     em.persist(customer);
     return customer;
 }

 public Customer find(long id){
     Customer customer = em.find(Customer.class,id);
     if(customer==null){
         throw new RuntimeException("Customer not found");
     }
     return customer;
 }

 public List<Customer> findAll(){
     String query = "select from customers JOIN FETCH c.accounts";
     return em.createQuery(query, Customer.class).getResultList();
     
 }

 public Customer update(Customer customer){
     em.merge(customer);
     return customer;
 }
 public void delete(long id){
     em.remove(find(id));
 }
    
}
