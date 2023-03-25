package com.ebank.beans.entity;

import java.io.Serializable;



public class OldAccount implements Serializable {
    private long code;
    private Double solde;
    private String owner;


    public OldAccount(){

    }
    /**
     * @param code
     * @param i
     * @param owmer
     */

    public OldAccount(long code, double solde, String owner) {
        this.code = code;
        this.solde = solde;
        this.owner = owner;
    }
    /**
     * @return the code
     */
    public long getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(long code) {
        this.code = code;
    }
    /**
     * @return the solde
     */
    public Double getSolde() {
        return solde;
    }
    /**
     * @param solde the solde to set
     */
    public void setSolde(Double solde) {
        this.solde = solde;
    }
    /**
     * @return the owmer
     */
    public String getOwner() {
        return owner;
    }
    /**
     * @param owmer the owmer to set
     */
    public void setOwmer(String owner) {
        this.owner = owner;
    }
    
}
