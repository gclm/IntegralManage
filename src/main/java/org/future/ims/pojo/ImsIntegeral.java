package org.future.ims.pojo;

import java.util.Date;

/**
 * @ClassName:     ImsIntegeral.java
 *  
 * @author         孤城落寞
 *
 * @Date           2017年10月22日 上午9:44:12
 *
 * @Description:   积分表  
 */

public class ImsIntegeral {
    private Integer integeral_id;

    private String student_name;

    private String student_id;

    private String score;

    private String reason;

    private String clubroom;

    private String semester;

    private String grades;

    private Date creatime;

    private Date update_time;
     
    
    public Integer getIntegeral_id() {
		return integeral_id;
	}

	public void setIntegeral_id(Integer integeral_id) {
		this.integeral_id = integeral_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id == null ? null : student_id.trim();
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades == null ? null : grades.trim();
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	

    /**
	 * @return the student_name
	 */
	public String getStudent_name() {
		return student_name;
	}

	/**
	 * @param student_name the student_name to set
	 */
	public void setStudent_name(String student_name) {

	   this.student_name = student_name == null ? null : student_name.trim();
	}


    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getClubroom() {
        return clubroom;
    }

    public void setClubroom(String clubroom) {
        this.clubroom = clubroom == null ? null : clubroom.trim();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester == null ? null : semester.trim();
    }

	public Date getCreatime() {
		return creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}

   
}