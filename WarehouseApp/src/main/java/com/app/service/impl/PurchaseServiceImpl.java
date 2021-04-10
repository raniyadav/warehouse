package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseDao;
import com.app.model.Purchase;
import com.app.model.PurchaseDtl;
import com.app.service.IPurchaseService;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Service
public class PurchaseServiceImpl implements IPurchaseService {
	@Autowired
	private IPurchaseDao dao;

	@Override
	@Transactional
	public Integer savePurchase(Purchase purchase) {
		return dao.savePurchase(purchase);
	}

	@Override
	@Transactional
	public void updatePurchase(Purchase purchase) {
		dao.updatePurchase(purchase);
	}

	@Override
	@Transactional
	public void deletePurchase(Integer id) {
		dao.deletePurchase(id);
	}

	@Override
	@Transactional(
			readOnly = true
			)
	public Purchase getOnePurchase(Integer id) {
		return dao.getOnePurchase(id);
	}

	@Override
	@Transactional(
			readOnly = true
			)
	public List<Purchase> getAllPurchases() {
		return dao.getAllPurchases();
	}
	@Transactional
	public Integer savePurchaseDtl(PurchaseDtl purchaseDtl) {
		return dao.savePurchaseDtl(purchaseDtl);
	}
	@Transactional
	public void deletePurchaseDtl(Integer id) {
		dao.deletePurchaseDtl(id);
	}
	@Transactional(readOnly=true)
	public List<Object[]> getPurchaseIdAndCode() {
		return dao.getPurchaseIdAndCode();
	}
	@Transactional
	public void updateStatusById(Integer id, String status) {
		dao.updateStatusById(id, status);
	}
	

}




