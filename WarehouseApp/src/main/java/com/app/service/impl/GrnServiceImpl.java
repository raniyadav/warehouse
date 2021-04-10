package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IGrnDao;
import com.app.model.Grn;
import com.app.model.GrnDtl;
import com.app.service.IGrnService;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Service
public class GrnServiceImpl implements IGrnService {
	@Autowired
	private IGrnDao dao;

	@Override
	@Transactional
	public Integer saveGrn(Grn grn) {
		return dao.saveGrn(grn);
	}

	@Override
	@Transactional
	public void updateGrn(Grn grn) {
		dao.updateGrn(grn);
	}

	@Override
	@Transactional
	public void deleteGrn(Integer id) {
		dao.deleteGrn(id);
	}

	@Override
	@Transactional(
			readOnly = true
			)
	public Grn getOneGrn(Integer id) {
		return dao.getOneGrn(id);
	}

	@Override
	@Transactional(
			readOnly = true
			)
	public List<Grn> getAllGrns() {
		return dao.getAllGrns();
	}

	@Override
	@Transactional
	public Integer saveGrnDtl(GrnDtl dtl) {
		return dao.saveGrnDtl(dtl);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<GrnDtl> getGrnDtlByGrnId(Integer id) {
		return dao.getGrnDtlByGrnId(id);
	}
}
