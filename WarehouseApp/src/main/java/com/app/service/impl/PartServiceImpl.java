package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPartDao;
import com.app.model.Part;
import com.app.service.IPartService;

@Service
public class PartServiceImpl implements IPartService {
	@Autowired
	private IPartDao dao;

	@Transactional
	public Integer savePart(Part part) {
		return dao.savePart(part);
	}

	@Transactional
	public void updatePart(Part part) {
		dao.updatePart(part);
	}

	@Transactional
	public void deletePart(Integer id) {
		dao.deletePart(id);
	}

	@Transactional(readOnly = true)
	public Part getOnePart(Integer id) {
		return dao.getOnePart(id);
	}

	@Transactional(readOnly = true)
	public List<Part> getAllParts() {
		return dao.getAllParts();
	}
	@Transactional(readOnly = true)
	public List<Object[]> getPartIdAndCodes() {
		return dao.getPartIdAndCodes();
	}
	
	
	
	
}
