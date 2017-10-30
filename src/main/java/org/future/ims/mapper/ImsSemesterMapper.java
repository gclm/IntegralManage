package org.future.ims.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.future.ims.pojo.ImsSemester;
import org.future.ims.pojo.ImsSemesterExample;

public interface ImsSemesterMapper {
    int countByExample(ImsSemesterExample example);

    int deleteByExample(ImsSemesterExample example);

    int deleteByPrimaryKey(Integer semesterId);

    int insert(ImsSemester record);

    int insertSelective(ImsSemester record);

    List<ImsSemester> selectByExample(ImsSemesterExample example);

    ImsSemester selectByPrimaryKey(Integer semesterId);

    int updateByExampleSelective(@Param("record") ImsSemester record, @Param("example") ImsSemesterExample example);

    int updateByExample(@Param("record") ImsSemester record, @Param("example") ImsSemesterExample example);

    int updateByPrimaryKeySelective(ImsSemester record);

    int updateByPrimaryKey(ImsSemester record);
}