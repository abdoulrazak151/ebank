package com.ebank.ws.rs;
import com.ebank.beans.entity.Account;
import com.ebank.beans.session.AccountManager;

import jakarta.inject.Inject;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.List;

@Path(value="/accounts")
public class AccountRessource {
    @Inject
    AccountManager accountManager=new AccountManager();
    @GET @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
    return Response.status(Status.OK).entity(accountManager.findAll()).build();
    }
    @POST()
    @Path("/create/{customerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@QueryParam(value="customerId") long customerId, Account account){
        try{
      
       return Response.status(Status.CREATED)
       .entity(accountManager.create(customerId, account))
       .build();
        }catch(RuntimeException e){
            e.printStackTrace();
          return  Response.status(Status.CONFLICT).build(); 
        }
           
    }
    @GET 
    @Path(value="/{id}}") 
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@QueryParam(value="id") int code){
        try{
            return Response.status(Status.FOUND).entity(accountManager.find(code)).build();
        }catch(RuntimeException e){
            e.printStackTrace();
        return  Response.status(Status.CONFLICT).build(); 
        }
    }
   @POST
   @Path("/deposit")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Response deposit(TransactionRequest request){
       try{
           accountManager.deposit(request.getCode(), request.getAmount());
            return Response.status(Status.OK).entity(accountManager.find(request.getCode())).build();      
        }catch(RuntimeException e){
            e.printStackTrace();
        return  Response.status(Status.CONFLICT).build(); 
        }
   }
   @POST
   @Path("/withdraw")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response withdraw(TransactionRequest request){
       try{
           accountManager.retrait(request.getCode(), request.getAmount());
            return Response.status(Status.OK).entity(accountManager.find(request.getCode())).build();      
        }catch(RuntimeException e){
            e.printStackTrace();
        return  Response.status(Status.CONFLICT).build(); 
        }
   }
   
   @DELETE       
    @Path(value="/{code}") 
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam(value="code") int code){
        try{
            accountManager.delete(code);
            return Response.status(Status.OK).build();
        }catch(RuntimeException e){
            e.printStackTrace();
        return  Response.status(Status.CONFLICT).build(); 
        }
    }
    

}
