package org.future.ims.pojo;

/**
 * null
 * 
 * @author 
 * 
 * @date 2017-11-03
 */
public class ImsUser {
    private Integer userId;

    private String name;

    private String studentId;

    private String password;

    private String clubroom;

    private String role;

    private String email;

    private String pic;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getClubroom() {
        return clubroom;
    }

    public void setClubroom(String clubroom) {
        this.clubroom = clubroom == null ? null : clubroom.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ImsUser [userId=" + userId + ", name=" + name + ", studentId=" + studentId + ", password=" + password
				+ ", clubroom=" + clubroom + ", role=" + role + ", email=" + email + ", pic=" + pic + "]";
	}
    
    
}