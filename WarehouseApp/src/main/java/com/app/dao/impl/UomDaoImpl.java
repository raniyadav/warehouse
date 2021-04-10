package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUom(Uom u) {
		return (Integer) ht.save(u);
	}

	@Override
	public void updateUom(Uom u) {
		ht.update(u);
	}

	@Override
	public void deleteUom(Integer id) {
		ht.delete(new Uom(id));
	}

	@Override
	public Uom getOneUom(Integer id) {
		Uom u=ht.get(Uom.class, id);
		return u;
	}

	@Override
	public List<Uom> getAllUoms() {
		List<Uom> list=ht.loadAll(Uom.class);
		return list;
	}
	
	@Override
	public List<Object[]> getUomIdAndModels() {
		/*String hql="select id,uomModel "
				+ " from com.app.model.Uom ";
		return (List<Object[]>) ht.find(hql);*/
		
		DetachedCriteria dc=DetachedCriteria
				.forClass(Uom.class)
				.setProjection(
						Projections.projectionList()
						.add(Projections.property("id"))
						.add(Projections.property("uomModel")) 
						);
		@SuppressWarnings("unchecked")
		List<Object[]>  list=(List<Object[]>) ht.findByCriteria(dc);
		return list;
	}

	@Override
	public boolean isUomModelExist(String uomModel) {
		boolean flag=false;
		String hql=" select count(uomModel) "
				+" from com.app.model.Uom "
				+" where uomModel=?0";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Long> res= (List<Long>) ht.find(hql, uomModel);
		if(res!=null && !res.isEmpty()) {
			long count=res.get(0);
			flag=(count==1)?true:false;
		}
		
		
		return flag;
	}
	
}



