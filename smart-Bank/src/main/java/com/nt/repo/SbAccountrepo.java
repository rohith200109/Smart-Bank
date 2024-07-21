package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.beans.SbAccount;

public interface SbAccountrepo extends JpaRepository<SbAccount,Integer> {
	
	
	public List<SbAccount> findByAcNumber(Long acNumber);

	@Query("select id from SbAccount where acNumber=?1 and custName=?2 and accountType=?3")
	Integer checkingDepositeDetails(Long acNumber,String custName,String accountType);
	
	@Query("select count(*) from SbAccount")
	Long countRecords();
	
	@Query("select  id  from SbAccount where aadhaarNumber=?1 ")
Integer accountchecking(Long aadhaarNumber);

}
