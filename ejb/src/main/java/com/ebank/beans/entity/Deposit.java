package com.ebank.beans.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name ="deposits")
@DiscriminatorValue(value="D")
public class Deposit extends Operation{
    
}
