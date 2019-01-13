package com.shetuan.bean;

public class Member {
	//登录名
	private String loginName;
	//登录权限
	private int managerId;
	//成员姓名
	private String memberName;
	//成员头像存储路径
	private String memberHeader;
	//成员性别
	private String memberGender;
	//成员年级
	private String memberGrade;
	//成员学院
	private String memberInstitute;
	//成员地址
	private String memberAdd;
	//成员邮箱
	private String memberEmail;
	//成员电话
	private String memberPhone;
	//是否创建社团
	private int iscreatCommunity;
	//是否加入社团
	private int isJoinCommunity;
	//加入的社团名称
	private String joinCommunity;
	
	public int getIscreatCommunity() {
		return iscreatCommunity;
	}
	public void setIscreatCommunity(int iscreatCommunity) {
		this.iscreatCommunity = iscreatCommunity;
	}
	public int getIsJoinCommunity() {
		return isJoinCommunity;
	}
	public void setIsJoinCommunity(int isJoinCommunity) {
		this.isJoinCommunity = isJoinCommunity;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberHeader() {
		return memberHeader;
	}
	public void setMemberHeader(String memberHeader) {
		this.memberHeader = memberHeader;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	public String getMemberInstitute() {
		return memberInstitute;
	}
	public void setMemberInstitute(String memberInstitute) {
		this.memberInstitute = memberInstitute;
	}
	public String getMemberAdd() {
		return memberAdd;
	}
	public void setMemberAdd(String memberAdd) {
		this.memberAdd = memberAdd;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	public String getJoinCommunity() {
		return joinCommunity;
	}
	public void setJoinCommunity(String joinCommunity) {
		this.joinCommunity = joinCommunity;
	}
	
	
	

	
	
	
}
