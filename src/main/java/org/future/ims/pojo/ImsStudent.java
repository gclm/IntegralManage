package org.future.ims.pojo;
/**
 * @ClassName:     ImsStudent.java
 *  
 * @author         孤城落寞
 *
 * @Date           2017年10月22日 上午9:47:55
 *
 * @Description:   学生信息表  
 */
public class ImsStudent {
    private Integer student_id;

    private String grades;

    private String name;

    private Integer id;

    
    public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades == null ? null : grades.trim();
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}