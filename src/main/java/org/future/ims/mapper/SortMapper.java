package org.future.ims.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.future.ims.pojo.Sort;
import org.future.ims.pojo.SortExample;

public interface SortMapper {
    int countByExample(SortExample example);

    int deleteByExample(SortExample example);

    int insert(Sort record);

    int insertSelective(Sort record);

    List<Sort> selectByExample(SortExample example);
    
    //根据学号和学期查询总的积分信息
    List<Sort> selectByStudentIdAndSemester(String studentId,String intSemester);
    
    //根据班级、学期查询总的积分信息
    List<Sort> selectByClassAndSemester(String grades,String intSemester);

    int updateByExampleSelective(@Param("record") Sort record, @Param("example") SortExample example);

    int updateByExample(@Param("record") Sort record, @Param("example") SortExample example);
}