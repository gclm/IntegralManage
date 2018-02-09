package org.future.ims.pojo;

/**
 * null
 * 
 * @author wcyong
 * 
 * @date 2017-11-04
 */
public class ImsClass {
    private Integer classId;

    private String className;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

	@Override
	public String toString() {
		return "ImsClass [classId=" + classId + ", className=" + className + "]";
	}
    
    
}