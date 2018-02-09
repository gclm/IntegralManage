package org.future.ims.pojo;

public class EamilPassword {
	private String emailName;
	private String eamilPassword;
	
	public String getEmailName() {
		return emailName;
	}
	public void setEmailName(String emailName) {
		this.emailName = emailName;
	}
	public String getEamilPassword() {
		return eamilPassword;
	}
	public void setEamilPassword(String eamilPassword) {
		this.eamilPassword = eamilPassword;
	}
	
	@Override
	public String toString() {
		return "EamilPassword [emailName=" + emailName + ", eamilPassword=" + eamilPassword + "]";
	}
	
	
	
}
