package com.group2.capstone.EBPaymentSystem.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Property {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne
    private Meter meter;
    @OneToOne
    private PropertyType propertyType;
//    @OneToOne(mappedBy = "property",cascade = CascadeType.ALL)
//    private Bill bill;
    @OneToOne
    private Address address;
}
