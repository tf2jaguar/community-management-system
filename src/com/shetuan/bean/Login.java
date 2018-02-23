package com.shetuan.bean;

public class Login {
		//登录权限
		private int managerId;
		//登录名
		private String loginName;
		//登录密码
		private String loginPass;
		//登录ID
		private int loginId;
		
		public int getLoginId() {
			return loginId;
		}
		public void setLoginId(int loginId) {
			this.loginId = loginId;
		}
		public String getLoginName() {
			return loginName;
		}
		public void setLoginName(String loginNmae) {
			this.loginName = loginNmae;
		}
		public String getLoginPass() {
			return loginPass;
		}
		public void setLoginPass(String loginPass) {
			this.loginPass = loginPass;
		}
		public int getManagerId() {
			return managerId;
		}
		public void setManagerId(int managerId) {
			this.managerId = managerId;
		}
}
