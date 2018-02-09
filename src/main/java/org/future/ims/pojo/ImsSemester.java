package org.future.ims.pojo;

/**
 * null
 * 
 * @author 
 * 
 * @date 2017-11-03
 */
public class ImsSemester {
    private Integer semesterId;

    private String semesterName;

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName == null ? null : semesterName.trim();
    }
}