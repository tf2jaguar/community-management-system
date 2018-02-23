function registCheck(form) {
	if (document.forms.myfor.username.value == "") {
		alert("请填写用户名");
		document.forms.myfor.username.focus();
		return false;
	} else if (document.forms.myfor.userpass.value== "") {
		alert("请填写密码");
		document.forms.myfor.userpass.focus();
		return false;
	} else if (document.forms.myfor.userpass.value != document.forms.myfor.repass.value) {
		alert("两次输入的密码不一致。");
		document.forms.myfor.repass.focus();
		return false;
	} else if (document.forms.myfor.email.value== "") {
		alert("邮箱不能为空。");
		document.forms.myfor.email.focus();
		return false;
	} else if (document.forms.myfor.phone.value== "") {
		alert("手机号不能为空。");
		document.forms.myfor.phone.focus();
		return false;
	} 
}
