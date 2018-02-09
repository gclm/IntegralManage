package org.future.ims.pojo;

/**
 * null
 * 
 * @author 
 * 
 * @date 2017-11-03
 */
public class ImsStudent {
    private Integer id;

    private String name;

    private String grades;

    private String studentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades == null ? null : grades.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

	@Override
	public String toString() {
		return "ImsStudent [id=" + id + ", name=" + name + ", grades=" + grades + ", studentId=" + studentId + "]";
	}
}