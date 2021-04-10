package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;

@Repository
public class DocumentDaoImpl 
	implements IDocumentDao {
	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveDocument(Document doc) {
		return (Integer)ht.save(doc);
	}
	
	
	public List<Object[]> getDocumentIdAndName(){
		String hql="select fileId,fileName from com.app.model.Document";
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}
	

	public Document getOneDocument(Integer id) {
		return ht.get(Document.class, id);
	}
	
	
	
	
}





