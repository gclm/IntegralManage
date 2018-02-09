package org.future.ims.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.future.ims.pojo.ImsUser;
import org.future.ims.pojo.ImsUserExample;

public interface ImsUserMapper {
    int countByExample(ImsUserExample example);

    int deleteByExample(ImsUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(ImsUser record);

    int insertSelective(ImsUser record);

    List<ImsUser> selectByExample(ImsUserExample example);
    
    List<ImsUser> selectUsersByStudentId(String studentId);

    ImsUser selectByPrimaryKey(Integer userId);
    
    ImsUser selectByStudentId(String studentId);
    
    ImsUser selectByEmail(String email);

    int updateByExampleSelective(@Param("record") ImsUser record, @Param("example") ImsUserExample example);

    int updateByExample(@Param("record") ImsUser record, @Param("example") ImsUserExample example);

    int updateByPrimaryKeySelective(ImsUser record);

    int updateByPrimaryKey(ImsUser record);

	
	
    
}