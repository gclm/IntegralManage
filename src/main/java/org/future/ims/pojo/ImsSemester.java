package org.future.ims.pojo;

/**
 * @ClassName:     ImsSemester.java
 *  
 * @author         孤城落寞
 *
 * @Date           2017年10月22日 上午9:44:33
 *
 * @Description:   学期表  
 */
public class ImsSemester {
    
	private Integer semester_id;

    private String semester_name;

    
    public Integer getSemester_id() {
		return semester_id;
	}


	public void setSemester_id(Integer semester_id) {
		this.semester_id = semester_id;
	}


	public String getSemester_name() {
		return semester_name;
	}


	public void setSemester_name(String semester_name) {
		 this.semester_name = semester_name == null ? null : semester_name.trim();
	}
}