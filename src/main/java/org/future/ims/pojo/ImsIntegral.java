package org.future.ims.pojo;

/**
 * null
 * 
 * @author wcyong
 * 
 * @date 2017-11-10
 */
public class ImsIntegral {
    private Integer integralId;

    private String studentName;

    private String studentId;

    private Float score;

    private String reason;

    private String time;

    private String clubroom;

    private String intSemester;

    private String grades;

    private String creatime;

    private String updateTime;

    private String name;

    public Integer getIntegralId() {
        return integralId;
    }

    public void setIntegralId(Integer integralId) {
        this.integralId = integralId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getClubroom() {
        return clubroom;
    }

    public void setClubroom(String clubroom) {
        this.clubroom = clubroom == null ? null : clubroom.trim();
    }

    public String getIntSemester() {
        return intSemester;
    }

    public void setIntSemester(String intSemester) {
        this.intSemester = intSemester == null ? null : intSemester.trim();
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades == null ? null : grades.trim();
    }

    public String getCreatime() {
        return creatime;
    }

    public void setCreatime(String creatime) {
        this.creatime = creatime == null ? null : creatime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "ImsIntegral [integralId=" + integralId + ", studentName=" + studentName + ", studentId=" + studentId
				+ ", score=" + score + ", reason=" + reason + ", time=" + time + ", clubroom=" + clubroom
				+ ", intSemester=" + intSemester + ", grades=" + grades + ", creatime=" + creatime + ", updateTime="
				+ updateTime + ", name=" + name + "]";
	}
    
    
}