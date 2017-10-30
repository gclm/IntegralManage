package org.future.ims.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.future.ims.pojo.ImsIntegeral;
import org.future.ims.pojo.ImsIntegeralExample;

public interface ImsIntegeralMapper {
    int countByExample(ImsIntegeralExample example);

    int deleteByExample(ImsIntegeralExample example);

    int deleteByPrimaryKey(Integer integeralId);

    int insert(ImsIntegeral record);

    int insertSelective(ImsIntegeral record);

    List<ImsIntegeral> selectByExample(ImsIntegeralExample example);

    ImsIntegeral selectByPrimaryKey(Integer integeralId);

    int updateByExampleSelective(@Param("record") ImsIntegeral record, @Param("example") ImsIntegeralExample example);

    int updateByExample(@Param("record") ImsIntegeral record, @Param("example") ImsIntegeralExample example);

    int updateByPrimaryKeySelective(ImsIntegeral record);

    int updateByPrimaryKey(ImsIntegeral record);
}