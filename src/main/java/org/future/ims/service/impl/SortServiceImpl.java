package org.future.ims.service.impl;

import java.util.List;

import org.future.ims.mapper.SortMapper;
import org.future.ims.pojo.Sort;
import org.future.ims.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("sortService")
public class SortServiceImpl implements SortService{

	@Autowired
	private SortMapper sortMapper;

	@Override
	public List<Sort> selectByStudentIdAndSemester(String studentId, String intSemester) {
		return sortMapper.selectByStudentIdAndSemester(studentId, intSemester);
	}

	@Override
	public List<Sort> selectByClassAndSemester(String grades, String intSemester) {
		return sortMapper.selectByClassAndSemester(grades, intSemester);
	}

	
}