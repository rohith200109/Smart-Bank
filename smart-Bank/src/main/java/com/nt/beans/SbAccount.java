package com.nt.beans;

import java.time.LocalDateTime;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class SbAccount {
	
	@SequenceGenerator(name ="sq" ,sequenceName = "smartBank",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "sq")
	@Id
	Integer id;
	
	@Column(length = 25)
	String custName;
	@Column(length = 25)
	String BankName="Smart Bank";
	@NonNull
	Long acNumber;
	Long aadhaarNumber;
	Long mobileNumber;
	@Column(length = 20)
	String pan;
	@Column(length = 100)
	String address;
	@Column(length = 20)
	String accountType;
	@NonNull
	Long Amount;
	LocalDateTime dob;
	
}
