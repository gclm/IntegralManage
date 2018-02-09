package org.future.ims.pojo;

/**
 * null
 * 
 * @author 
 * 
 * @date 2017-11-03
 */
public class ImsClubroom {
    private Integer clubroomId;

    private String clubroomName;

    public Integer getClubroomId() {
        return clubroomId;
    }

    public void setClubroomId(Integer clubroomId) {
        this.clubroomId = clubroomId;
    }

    public String getClubroomName() {
        return clubroomName;
    }

    public void setClubroomName(String clubroomName) {
        this.clubroomName = clubroomName == null ? null : clubroomName.trim();
    }
}