
function LoginValidate(frm){
	
	alert(1);
	let output=(id)=>document.getElementById(id);
	

	let name=frm.custName.value;
	let aadharNum = frm.aadhaarNumber.value;
	let mobileNum = frm.mobileNumber.value;
	let pan = frm.pan.value;
	let address = frm.address.value;
	let amount = frm.Amount.value;
	let dob = frm.dob.value;
	
	let vflag=true;
	if(name==""){
		output('errName').innerHTML="Name is Mandatory ";
		vflag=false;
	}
	if(aadharNum==""){
		output('errAadhaar').innerHTML="aadhaarNumber is Mandatory ";
		vflag=false;
	}
	if(mobileNum==""){
		output('errPhoneNumber').innerHTML="Mobile number is mandatory";
		vflag=false;
	}
	if(pan==""){
			output('errPan').innerHTML="Pan  is mandatory";
		vflag=false;
	}
	if(address==""){
			output('errAddress').innerHTML="Address is mandatory";
		vflag=false;
	}
	if(amount==""){
			output('errAmount').innerHTML="Amount is mandatory";
		vflag=false;
	}
	if(dob==""){
			output('errDob').innerHTML="Dob is mandatory";
		vflag=false;
	}
	
	return vflag;
	
}