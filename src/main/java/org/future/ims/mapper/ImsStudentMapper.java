package org.future.ims.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.future.ims.pojo.ImsStudent;
import org.future.ims.pojo.ImsStudentExample;

public interface ImsStudentMapper {
    int countByExample(ImsStudentExample example);

    int deleteByExample(ImsStudentExample example);

    int deleteByPrimaryKey(Integer studentId);

    int insert(ImsStudent record);

    int insertSelective(ImsStudent record);

    List<ImsStudent> selectByExample(ImsStudentExample example);

    ImsStudent selectByPrimaryKey(Integer studentId);

    int updateByExampleSelective(@Param("record") ImsStudent record, @Param("example") ImsStudentExample example);

    int updateByExample(@Param("record") ImsStudent record, @Param("example") ImsStudentExample example);

    int updateByPrimaryKeySelective(ImsStudent record);

    int updateByPrimaryKey(ImsStudent record);
}