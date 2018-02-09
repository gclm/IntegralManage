package org.future.ims.service.impl;

import java.util.List;

import org.future.ims.mapper.ImsSemesterMapper;
import org.future.ims.pojo.ImsSemester;
import org.future.ims.pojo.ImsSemesterExample;
import org.future.ims.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("semesterService")
public class SemesterServiceImpl implements SemesterService{

	@Autowired
	private ImsSemesterMapper semesterMapper;
	
	/**
	  *  Description:
	  *  @author  zsh  DateTime 2017年11月6日 下午8:39:13
	  *  @param semester
	  *  增加学期方法
	  *  @return
	  */
	@Override
	public int addSemester(ImsSemester semester) {
		return semesterMapper.insert(semester);
	}

	
	
	/**
	  *  Description:
	  *  @author  zsh  DateTime 2017年11月6日 下午8:41:32
	  *  得到所有学期方法
	  *  @return
	  */
	@Override
	public List<ImsSemester> getSemesterAll() {
		return semesterMapper.selectByExample(null);
	}

	
	
	/**
	  *  Description:
	  *  @author  zsh  DateTime 2017年11月6日 下午8:42:31
	  *  @param name
	  *  通过学期名查询学期对象，用于修改和添加时候的查重
	  *  @return
	  */
	@Override
	public List<ImsSemester> getSemesterByName(String name) {
		return semesterMapper.getSemesterByName(name);
	}

	
	
	/**
	  *  Description:
	  *  @author  zsh  DateTime 2017年11月6日 下午8:43:03
	  *  @param record
	  *  修改学期方法
	  *  @return
	  */
	@Override
	public int updateByPrimaryKeySelective(ImsSemester record) {
		return semesterMapper.updateByPrimaryKey(record);
	}

	/**
	  *  Description:
	  *  @author  zsh  DateTime 2017年11月6日 下午8:44:01
	  *  @param semesterId
	  *  删除学期方法
	  *  @return
	  */
	@Override
	public int deleteByPrimaryKey(Integer semesterId) {
		return semesterMapper.deleteByPrimaryKey(semesterId);
	}
}