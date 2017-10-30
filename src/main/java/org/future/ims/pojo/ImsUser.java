package org.future.ims.pojo;

/**
 * @ClassName:     ImsUser.java
 *  
 * @author         孤城落寞
 *
 * @Date           2017年10月25日 上午8:27:19
 *
 * @Description:   TODO(用一句话描述该文件做什么)  
 */
public class ImsUser {
	
    private Integer user_id;
    
    //姓名
    private String name;

    private String student_id;

    private String password;
    //部室
    private String clubroom;

    private String role;
    
    private String phone;
    
    //头像
    private String pic;
    
    //状态
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id == null ? null : student_id.trim();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}