package com.app.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.model.Purchase;
import com.app.model.PurchaseDtl;

@Component
public class PurchaseUtil {

	public void allocateSlno(Purchase po) {
		List<PurchaseDtl> list=po.getChilds();
		int count=1;
		for(PurchaseDtl dtl:list) {
			dtl.setSlno(count);
			count=count+1;
		}
		
	}
}



