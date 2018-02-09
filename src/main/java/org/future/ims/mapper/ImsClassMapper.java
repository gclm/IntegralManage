package org.future.ims.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.future.ims.pojo.ImsClass;
import org.future.ims.pojo.ImsClassExample;

public interface ImsClassMapper {
    int countByExample(ImsClassExample example);

    int deleteByExample(ImsClassExample example);

    int deleteByPrimaryKey(Integer classId);

    int insert(ImsClass record);

    int insertSelective(ImsClass record);

    List<ImsClass> selectByExample(ImsClassExample example);
    
    //通过名称模糊查询班级
    List<ImsClass> getClassByName(String name);

    //通过名称精确查询班级，用于修改、添加时的查重
    List<ImsClass> getCompletelyClassByName(String name);
    
    ImsClass selectByPrimaryKey(Integer classId);
    
    int updateByExampleSelective(@Param("record") ImsClass record, @Param("example") ImsClassExample example);

    int updateByExample(@Param("record") ImsClass record, @Param("example") ImsClassExample example);

    int updateByPrimaryKeySelective(ImsClass record);

    int updateByPrimaryKey(ImsClass record);
}