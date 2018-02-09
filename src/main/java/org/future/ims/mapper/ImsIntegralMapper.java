package org.future.ims.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.future.ims.pojo.ImsIntegral;
import org.future.ims.pojo.ImsIntegralExample;
import org.future.ims.pojo.QueryVoIntegral;

public interface ImsIntegralMapper {
    int countByExample(ImsIntegralExample example);

    int deleteByExample(ImsIntegralExample example);

    int deleteByPrimaryKey(Integer integralId);

    int insert(ImsIntegral record);

    int insertSelective(ImsIntegral record);

    List<ImsIntegral> selectByExample(ImsIntegralExample example);
    
    //多条件查询
    List<ImsIntegral> selectByVo(QueryVoIntegral voQueryVoIntegral);
    
    //积分查重
    List<ImsIntegral> queryRepetition(String studentName,String studentId,String grades,
    		Float score,String reason,String time,String clubroom,String intSemester);
    
    ImsIntegral selectByPrimaryKey(Integer integralId);
    
    int updateByExampleSelective(@Param("record") ImsIntegral record, @Param("example") ImsIntegralExample example);

    int updateByExample(@Param("record") ImsIntegral record, @Param("example") ImsIntegralExample example);

    int updateByPrimaryKeySelective(ImsIntegral record);

    int updateByPrimaryKey(ImsIntegral record);
}