package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.stereotype.Service;

import com.nt.beans.SbAccount;
import com.nt.repo.SbAccountrepo;

@Service
public class SbBankService {
@Autowired
private	SbAccountrepo sbrepo;

	
	
	public String  accountSaving(SbAccount obj) 
	{
		Optional<SbAccount> byId = sbrepo.findById((int) sbrepo.count());
		if(byId.isPresent()) {
			Long num=byId.get().getAcNumber();
			obj.setAcNumber(++num);
		}
		else {
		obj.setAcNumber(10000001L);
		}
		sbrepo.save(obj);
		return "Account Created";
	}
	
	public Long amountdeposit(SbAccount obj)
	{
	List<SbAccount> custmor =	sbrepo.findByAcNumber(obj.getAcNumber());
	Long amount=0L;
	for(SbAccount element:custmor) {
		amount=element.getAmount()+obj.getAmount();
		element.setAmount(amount);
		sbrepo.save(element);
		break;
	}
	return amount;

	}
	public Long amountWithdraw(SbAccount obj)
	{
		List<SbAccount> custmor =	sbrepo.findByAcNumber(obj.getAcNumber());
		Long amount=0L;
		for(SbAccount element:custmor) {
			amount=element.getAmount()-obj.getAmount();
			element.setAmount(amount);
			sbrepo.save(element);
			break;
		}
		return amount;
		
	}
	
	public SbAccount checkBalance(SbAccount obj) {
		List<SbAccount> custmor =	sbrepo.findByAcNumber(obj.getAcNumber());
		for(SbAccount element:custmor) {	
			return element;
		}
		 return new SbAccount();
	}

}
