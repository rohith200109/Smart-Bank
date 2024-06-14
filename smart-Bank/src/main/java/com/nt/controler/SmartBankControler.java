package com.nt.controler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.nt.beans.SbAccount;
import com.nt.beans.SbAccountBean;
import com.nt.service.SbBankService;

@Controller("/app")
public class SmartBankControler {
	@Autowired
	SbBankService service;

	@Autowired
	Environment env;
	private static Long sendersAcNumber;
	private static String custName;

	@GetMapping("/home")
	public String home() {
		return "home.jsp";
	}

	@GetMapping("createaccount")
	public String accountCreation(@ModelAttribute("acc") SbAccountBean ob) {
		return "createacForm";
	}

	@SuppressWarnings("resource")
	@PostMapping("createaccount")
	public String StoringAccountData(@ModelAttribute("acc") SbAccountBean bean, Map<String, Object> map)
			throws Exception {
		// folder location
		String storedlocation = env.getRequiredProperty("spring.servlet.multipart.location");

		File locationFolder = new File(storedlocation);
		if (!locationFolder.exists())
			locationFolder.mkdir();
		// get multipart beans representing the uploaded files
		MultipartFile file1 = bean.getAadhar();
		MultipartFile file2 = bean.getPanCard();
		// create input stream and output stream
		InputStream file1Is = file1.getInputStream();
		InputStream file2Is = file2.getInputStream();

		// get file names
		String file1Name = file1.getOriginalFilename();
		String file2Name = file2.getOriginalFilename();

		// create output streams
		FileOutputStream file1Os = new FileOutputStream(locationFolder.getAbsolutePath() + "/" + file1Name);
		FileOutputStream file2Os = new FileOutputStream(locationFolder.getAbsolutePath() + "/" + file2Name);

		IOUtils.copy(file2Is, file2Os);
		IOUtils.copy(file1Is, file1Os);

		SbAccount obj = new SbAccount();
		obj.setAadhaarNumber(bean.getAadhaarNumber());
		obj.setAadhar(locationFolder.getAbsolutePath() + "/" + file1Name);
		obj.setAccountType(bean.getAccountType());
		obj.setAadhaarNumber(bean.getAadhaarNumber());
		obj.setAddress(bean.getAddress());
		obj.setCustName(bean.getCustName());
		obj.setPan(locationFolder.getAbsolutePath() + "/" + file2Name);
		obj.setMobileNumber(bean.getMobileNumber());
		obj.setAmount(bean.getAmount());
		String msg = service.accountSaving(obj);
		map.put("message", msg);
		map.put("custdetails", obj);
		return "accountsucess";
	}

	@GetMapping("depositeaccount")
	public String depositeForm(@ModelAttribute("deposit") SbAccount ob) {
		return "deposit";
	}

	@PostMapping("depositeaccount")
	public String depositSaving(@ModelAttribute("deposit") SbAccount obj, Map<String, Object> map) {
		Long amt = service.amountdeposit(obj);
		map.put("msg", "Deposited  Sucessfully");
		map.put("accountnum", obj.getAcNumber());
		map.put("depositedamount", obj.getAmount());
		map.put("balance", amt);
		return "depositSucess";
	}

	@GetMapping("withdraw")
	public String withdrawform(@ModelAttribute("debit") SbAccount obj) {
		return "withdrawForm";
	}

	@PostMapping("withdraw")
	public String withdrawAction(@ModelAttribute("debit") SbAccount obj, Map<String, Object> map) {
		Long amt = service.amountWithdraw(obj);
		map.put("msg", "Withdraw  Sucessfully");
		map.put("accountnum", obj.getAcNumber());
		map.put("depositedamount", obj.getAmount());
		map.put("balance", amt);
		return "depositSucess";
	}

	@GetMapping("Transferfunds")
	public String transferForm(@ModelAttribute("transfer") SbAccount obj) {
		return "transferForm";
	}

	@PostMapping("Transferfunds")
	public String getSenderDetails(@ModelAttribute("transfer") SbAccount obj, Map<String, Object> map) {
		sendersAcNumber = obj.getAcNumber();
		custName = obj.getCustName();
		return "reseverForm";
	}

	@PostMapping("reseverdetails")
	public String getReseverDetails(@ModelAttribute("transfer") SbAccount obj, Map<String, Object> map) {
		SbAccount sbObj = new SbAccount();
		sbObj.setAcNumber(sendersAcNumber);
		sbObj.setAmount(obj.getAmount());
		System.out.println(sbObj);
		System.out.println(sbObj);
		service.amountWithdraw(sbObj);
		service.amountdeposit(obj);
		map.put("senderAccountnum", sendersAcNumber);
		map.put("amountSent", obj.getAmount());
		map.put("reciveraccountnum", obj.getAcNumber());
		return "transferAmountResult";
	}

	@GetMapping("checkBalance")
	public String checkBalance(@ModelAttribute("cb") SbAccount obj) {
		return "checkBalanceForm";
	}

	@PostMapping("checkBalance")
	public String getAccountBalance(@ModelAttribute("cb") SbAccount obj, Map<String, Object> map) {
		SbAccount Custbean = service.checkBalance(obj);
		System.out.println(Custbean);
		map.put("CustName", Custbean.getCustName());
		map.put("CustBank", Custbean.getBankName());
		map.put("CustAccountNumber", Custbean.getAcNumber());
		map.put("CustAmount", Custbean.getAmount());

		return "AccountBalanceResult";
	}

}
