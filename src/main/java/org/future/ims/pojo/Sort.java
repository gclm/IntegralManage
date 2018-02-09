package org.future.ims.pojo;

/**
 * null
 * 
 * @author zsh
 * 
 * @date 2017-11-12
 */
public class Sort {
    private String studentName;

    private Float allscore;

    private String grades;

    private String intSemester;

    private String studentId;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public Float getAllscore() {
        return allscore;
    }

    public void setAllscore(Float allscore) {
        this.allscore = allscore;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades == null ? null : grades.trim();
    }

    public String getIntSemester() {
        return intSemester;
    }

    public void setIntSemester(String intSemester) {
        this.intSemester = intSemester == null ? null : intSemester.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

	@Override
	public String toString() {
		return "Sort [studentName=" + studentName + ", allscore=" + allscore + ", grades=" + grades + ", intSemester="
				+ intSemester + ", studentId=" + studentId + "]";
	}
    
    
}