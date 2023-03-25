package com.ebank.beans.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="withdraws")
@DiscriminatorValue(value="W")
public class Withdraw extends Operation{
    
}
