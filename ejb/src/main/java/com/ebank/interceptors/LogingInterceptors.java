package com.ebank.interceptors;



import java.util.Date;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class LogingInterceptors {
    
    @AroundInvoke
    public Object log(InvocationContext context)
        throws Exception{
            //permet de recuperer la date la difference entre 1970 01 01 et la date de today....
            long start_time = System.currentTimeMillis();
        try {
            return context.proceed();
      
    } finally {
         //recuperer la dete a laquelle on a appeller la methode
         //permet de recuperer le nom de la methode qui a ete appeller
         String methode = context.getMethod().getName();
         //permet de recuperer la date la difference entre 1970 01 01 et la date de today....
         long duration = System.currentTimeMillis() - start_time;
         System.out.println( new Date() +"-"+ methode +"-"+ duration + "ms");
   
     }

}

}