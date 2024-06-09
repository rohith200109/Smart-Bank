package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.beans.SbAccount;

public interface SbAccountrepo extends JpaRepository<SbAccount,Integer> {
	
	
	public List<SbAccount> findByAcNumber(Long acNumber);

}
