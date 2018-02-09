package org.future.ims.pojo;

public class QueryVoIntegral {
	private String voStuIdAndName;
	private String voClass;
	private String voClub;
	private String voSemester;
	
	public String getVoStuIdAndName() {
		return voStuIdAndName;
	}
	public void setVoStuIdAndName(String voStuIdAndName) {
		this.voStuIdAndName = voStuIdAndName;
	}
	public String getVoClass() {
		return voClass;
	}
	public void setVoClass(String voClass) {
		this.voClass = voClass;
	}
	public String getVoClub() {
		return voClub;
	}
	public void setVoClub(String voClub) {
		this.voClub = voClub;
	}
	public String getVoSemester() {
		return voSemester;
	}
	public void setVoSemester(String voSemester) {
		this.voSemester = voSemester;
	}
	
	@Override
	public String toString() {
		return "QueryVoIntegral [voStuIdAndName=" + voStuIdAndName + ", voClass=" + voClass + ", voClub=" + voClub
				+ ", voSemester=" + voSemester + "]";
	}
	
	
}
