package com.spring.college.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.college.dao.MarksheetDao;
import com.spring.college.entity.Marksheet;

@Repository
public class MarksheetServiceImpl implements MarksheetService {

	@Autowired
	private MarksheetDao marksheetBeanDao;

	@Override
	@Transactional
	public List<Marksheet> getMarksheets() {
		return marksheetBeanDao.getMarksheets();
	}

	@Override
	@Transactional
	public void saveMarksheet(Marksheet marksheet) {
		marksheetBeanDao.saveMarksheet(marksheet);
	}

	@Override
	@Transactional
	public Marksheet getMarksheet(int id) {
		return marksheetBeanDao.getMarksheet(id);
	}

	@Override
	@Transactional
	public void deleteMarksheet(int id) {
		marksheetBeanDao.deleteMarksheet(id);
	}

	@Override
	@Transactional
	public List<Marksheet> getMarksheetIdBasedOnUserId(Integer userId) {
		return marksheetBeanDao.getMarksheetIdBasedOnUserId(userId);
	}
}
