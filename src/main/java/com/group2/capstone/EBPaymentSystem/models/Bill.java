package com.group2.capstone.EBPaymentSystem.models;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long billId;
	private double amount;
	private LocalDate billingMonth;
    private Date dueDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Property property;
    private Integer status;
    private double unitsConsumed;

    public Bill(double amount, Date dueDate) {
        this.amount = amount;
        this.dueDate = dueDate;
    }


    // getters and setters
}
