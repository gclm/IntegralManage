package org.future.ims.pojo;

public class ImsClubroom {
    private Integer clubroom_id;

    private String clubroom_name;

    
    public Integer getClubroom_id() {
		return clubroom_id;
	}

	public void setClubroom_id(Integer clubroom_id) {
		this.clubroom_id = clubroom_id;
	}

	public String getClubroom_name() {
		return clubroom_name;
	}

	public void setClubroom_name(String clubroom_name) {
		this.clubroom_name = clubroom_name == null ? null : clubroom_name.trim();
	}
}