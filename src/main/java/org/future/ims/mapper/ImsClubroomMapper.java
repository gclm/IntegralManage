package org.future.ims.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.future.ims.pojo.ImsClubroom;
import org.future.ims.pojo.ImsClubroomExample;

public interface ImsClubroomMapper {
    int countByExample(ImsClubroomExample example);

    int deleteByExample(ImsClubroomExample example);

    int deleteByPrimaryKey(Integer clubroomId);

    int insert(ImsClubroom record);

    int insertSelective(ImsClubroom record);

    List<ImsClubroom> selectByExample(ImsClubroomExample example);

    ImsClubroom selectByPrimaryKey(Integer clubroomId);

    int updateByExampleSelective(@Param("record") ImsClubroom record, @Param("example") ImsClubroomExample example);

    int updateByExample(@Param("record") ImsClubroom record, @Param("example") ImsClubroomExample example);

    int updateByPrimaryKeySelective(ImsClubroom record);

    int updateByPrimaryKey(ImsClubroom record);
}