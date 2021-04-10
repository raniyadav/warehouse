package com.app.dao;

import java.util.List;

import com.app.model.Grn;
import com.app.model.GrnDtl;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface IGrnDao {
	Integer saveGrn(Grn grn);
	void updateGrn(Grn grn);
	void deleteGrn(Integer id);
	Grn getOneGrn(Integer id);
	List<Grn> getAllGrns();
	
	Integer saveGrnDtl(GrnDtl dtl);
	List<GrnDtl> getGrnDtlByGrnId(Integer id);
}



