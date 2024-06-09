package com.nt.controler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.beans.SbAccount;
import com.nt.service.SbBankService;

@Controller
public class SmartBankControler {
	@Autowired
	SbBankService service;
	private static Long sendersAcNumber;
	private static	String custName;
	

	@GetMapping("/")
public String  home(){
		return "home";
	}
	
	@GetMapping("createaccount")
	public String  accountCreation(@ModelAttribute("acc") SbAccount ob){
	return "createacForm";
}
	@PostMapping("createaccount")
	public String StoringAccountData(@ModelAttribute("acc") SbAccount obj,Map<String,Object> map) {
		String msg = service.accountSaving(obj);
		map.put("message", msg);
		map.put("custdetails",obj);
		return "accountsucess";
	}
	
	@GetMapping("depositeaccount")
	public String depositeForm(@ModelAttribute("deposit") SbAccount ob) 
	{
		return "deposit";
	}
	@PostMapping("depositeaccount")
	public String depositSaving(@ModelAttribute("deposit") SbAccount obj,Map<String,Object> map) {
		 Long amt = service.amountdeposit(obj);
		map.put("msg","Deposited  Sucessfully");
		map.put("accountnum", obj.getAcNumber());
		map.put("depositedamount", obj.getAmount());
		map.put("balance",amt);
		return "depositSucess";
	}
	
	@GetMapping("withdraw")
	public String withdrawform(@ModelAttribute("debit") SbAccount obj ) {
		return "withdrawForm";
	}

	@PostMapping("withdraw")
	public String withdrawAction(@ModelAttribute("debit") SbAccount obj ,Map<String,Object> map) {
		 Long amt = service.amountWithdraw(obj);
			map.put("msg","Withdraw  Sucessfully");
			map.put("accountnum", obj.getAcNumber());
			map.put("depositedamount", obj.getAmount());
			map.put("balance",amt);
			return "depositSucess";
	}
	
	@GetMapping("Transferfunds")
	public String transferForm(@ModelAttribute("transfer") SbAccount obj) {
		return "transferForm";
	}
	
	@PostMapping("Transferfunds")
	public String getSenderDetails(@ModelAttribute("transfer") SbAccount obj,Map<String,Object> map) {
		sendersAcNumber	= obj.getAcNumber();
		 custName = obj.getCustName();
			return "reseverForm";
	}
	
	@PostMapping("reseverdetails")
	public String getReseverDetails(@ModelAttribute("transfer") SbAccount obj,Map<String,Object> map) {
		SbAccount sbObj= new SbAccount();
		sbObj.setAcNumber(sendersAcNumber);
		sbObj.setAmount(obj.getAmount());
		System.out.println(sbObj);
		System.out.println(sbObj);
		service.amountWithdraw(sbObj);
		service.amountdeposit(obj);
		map.put("senderAccountnum",sendersAcNumber);
		map.put("amountSent",obj.getAmount());
		map.put("reciveraccountnum",obj.getAcNumber());
		return "transferAmountResult";
	}
	
	@GetMapping("checkBalance")
	public String checkBalance(@ModelAttribute("cb") SbAccount obj) {
		return "checkBalanceForm";
	}
	
	@PostMapping("checkBalance")
	public String getAccountBalance(@ModelAttribute("cb") SbAccount obj,Map<String,Object> map) {
		SbAccount  CustObject = service.checkBalance(obj);
		System.out.println(CustObject);
		map.put("CustName", CustObject.getCustName());
		map.put("CustBank", CustObject.getBankName());
		map.put("CustAccountNumber", CustObject.getAcNumber());
		map.put("CustAmount", CustObject.getAmount());

		return "AccountBalanceResult";
	}
	
}
