package com.app.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseDao;
import com.app.model.Purchase;
import com.app.model.PurchaseDtl;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Repository
public class PurchaseDaoImpl implements IPurchaseDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchase(Purchase purchase) {
		return (Integer)ht.save(purchase);
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		ht.update(purchase);
	}

	@Override
	public void deletePurchase(Integer id) {
		ht.delete(new Purchase(id));
	}

	@Override
	public Purchase getOnePurchase(Integer id) {
		return ht.get(Purchase.class,id);
	}

	@Override
	public List<Purchase> getAllPurchases() {
		return ht.loadAll(Purchase.class);
	}
	
	/**child methods**/
	public Integer savePurchaseDtl(PurchaseDtl purchaseDtl) {
		return (Integer) ht.save(purchaseDtl);
	}
	
	public void deletePurchaseDtl(Integer id) {
		ht.delete(new PurchaseDtl(id));
	}
	/***child methods end*/
	@Override
	public List<Object[]> getPurchaseIdAndCode() {
		
		DetachedCriteria dc=DetachedCriteria.forClass(Purchase.class)
				.setProjection(
						Projections.projectionList()
						.add(Projections.property("id"))
						.add(Projections.property("orderCode"))
						)
				.add(Restrictions.eq("status", "INVOICED"));
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(dc);
		
		return list;
	}
	@Override
	public void updateStatusById(Integer id, String status) {
		ht.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException {
				String hql=" update com.app.model.Purchase p "
						+ " set p.status=:a "
						+ " where p.id=:b";
				
				return session.createQuery(hql)
						.setParameter("a", status)
						.setParameter("b", id)
						.executeUpdate();
			}
		});
		
	}
	
}




