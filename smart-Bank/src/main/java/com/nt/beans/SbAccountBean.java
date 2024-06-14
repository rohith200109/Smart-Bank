package com.nt.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SbAccountBean implements Serializable {
private	Integer id;
	private	String custName;
	
	private	String BankName="Smart Bank";

	private	Long acNumber;
	private Long aadhaarNumber;
	private	Long mobileNumber;

	private	String pan;

	private	String address;

	private	String accountType;
	private	Long Amount;
	private	LocalDateTime dob;
	
	private	MultipartFile panCard;
	private	MultipartFile aadhar;
	
}
