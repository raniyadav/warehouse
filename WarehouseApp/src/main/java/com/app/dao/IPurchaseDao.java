package com.app.dao;

import java.util.List;

import com.app.model.Purchase;
import com.app.model.PurchaseDtl;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface IPurchaseDao {
	Integer savePurchase(Purchase purchase);
	void updatePurchase(Purchase purchase);
	void deletePurchase(Integer id);
	Purchase getOnePurchase(Integer id);
	List<Purchase> getAllPurchases();
	
	Integer savePurchaseDtl(PurchaseDtl purchaseDtl);
	void deletePurchaseDtl(Integer id); 
	
	List<Object[]> getPurchaseIdAndCode();
	void updateStatusById(Integer id,String status);
}






