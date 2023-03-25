package com.ebank.servlets;

import java.io.IOException;
import java.util.Date;

import com.ebank.beans.entity.Account;

import com.ebank.beans.entity.CheckingAccount;
import com.ebank.beans.session.AccountManager;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//anotation d'une servlets
@WebServlet(urlPatterns = { "/accounts" })
// =============================================
public class AccountsServlet extends HttpServlet {
    // generer automatiquement les methodes doGet & doPost
    // injection de ejb
    @EJB
    AccountManager accountManager;
    String errorMessage="";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // permet d'afficher les differents page en cliquant sur un des lient
        String target = "";
        switch (req.getParameter("action")) {
            case "create":
                target = "create_account_view.jsp";
                break;
            case "deposit":
                target = "deposit_view.jsp";
                break;
            case "withdraw":
                target = "withdraw_view.jsp";
                break;
            default:
                target = "accounts_list_view.jsp";
                req.setAttribute("Accounts", accountManager.findAll());
                break;
        }
        req.setAttribute("accounts", accountManager.findAll());
        // affichage de la page qui contient la liste des comptes
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/" + target)
                .forward(req, resp);
        // =============================================================

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        switch (req.getParameter("action")){
            case "create":
                long code =Long.valueOf(req.getParameter("code"));
                String owner =req.getParameter("owner");
                double initialBalance =Double.parseDouble(req.getParameter("initialBalance"));
                if (code == 0L || owner.isEmpty()) {

                    errorMessage="all fields are required!!!";
                }else{
                    try{
                        CheckingAccount account=new CheckingAccount();
                        account.setDateCreation(new Date());
                        account.setOverdraft(13800);
                        account.setSolde(initialBalance);
                        accountManager.create(1,account);
                    }catch(Exception e){
                        errorMessage=e.getMessage();
                        e.printStackTrace();
                    }
                }
                if(errorMessage.isEmpty()){
//                    accountManager.create(new Account(code, initialBalance, owner));
                    resp.sendRedirect(req.getContextPath()+"/accounts?action=list");
                }else {
                    req.setAttribute("errorMessage", errorMessage);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/create_account_view.jsp").forward(req, resp);
                }
                break;
            case "deposit":
                long account=Long.valueOf(req.getParameter("account"));

                double amount=Double.parseDouble(req.getParameter("amount"));
                if (account == 0L || amount==0 ) {

                    errorMessage="all fields are required!!!";
                }else{
                    try{

                        accountManager.deposit(account, amount);
                    }catch(Exception e){
                        errorMessage=e.getMessage();
                        e.printStackTrace();
                    }
                }
                if(errorMessage.isEmpty()){
//                    accountManager.create(new Account(code, initialBalance, owner));
                    resp.sendRedirect(req.getContextPath()+"/accounts?action=list");
                }else {
                    req.setAttribute("errorMessage", errorMessage);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/create_account_view.jsp").forward(req, resp);
                }
                break;
            case "withdraw":
                account=Long.valueOf(req.getParameter("code"));

                amount=Double.parseDouble(req.getParameter("amount"));
                if (account == 0L || amount==0 || accountManager.find(account).getSolde()<amount ) {

                    errorMessage="all fields are required or solde not authorized!!!";
                }else{
                    try{

                        accountManager.retrait(account, amount);
                    }catch(Exception e){
                        errorMessage=e.getMessage();
                        e.printStackTrace();
                    }
                }
                if(errorMessage.isEmpty()){
//                    accountManager.create(new Account(code, initialBalance, owner));
                    resp.sendRedirect(req.getContextPath()+"/accounts?action=list");
                }else {
                    req.setAttribute("errorMessage", errorMessage);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/create_account_view.jsp").forward(req, resp);
                }
                break;
            default:
                break;

        }

    }

}
