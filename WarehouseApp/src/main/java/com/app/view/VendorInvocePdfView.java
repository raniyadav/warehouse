package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Purchase;
import com.app.model.PurchaseDtl;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorInvocePdfView 
	extends AbstractPdfView
{

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {
	
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=vendorinvoce.pdf");
		//read data from Controller 
		Purchase parent=(Purchase)model.get("parent");
		//childs
		List<PurchaseDtl> list=parent.getChilds();
		
		//logic to count final cost
		Double finalCost=0.0;
		for(PurchaseDtl dtl:list) {
			finalCost+=dtl.getPart().getBaseCost()*dtl.getQty();
		}
		//end logic
		
		
		document.add(new Paragraph("Invoce Details :"));
		PdfPTable header=new PdfPTable(4);
		header.addCell("Vendor Code");
		header.addCell(parent.getVendor().getCode());
		header.addCell("Order Code");
		header.addCell(parent.getOrderCode());
		header.addCell("Final Cost");
		header.addCell(finalCost.toString());
		header.addCell("Shipment Type");
		header.addCell(parent.getShipmentType().getCode());
		
		document.add(header);
		document.add(new Paragraph("Item Details :"));
		
		
		
		
		PdfPTable table=new PdfPTable(4);
		table.addCell("Item Code");
		table.addCell("Base Cost");
		table.addCell("Qntyt");
		table.addCell("Item Value");
		
		for(PurchaseDtl dtl:list) {
			table.addCell(dtl.getPart().getCode());
			table.addCell(dtl.getPart().getBaseCost().toString());
			table.addCell(dtl.getQty().toString());
			table.addCell((dtl.getPart().getBaseCost()*dtl.getQty())+"");
		}
		document.add(table);
		document.add(new Paragraph(new Date().toString()));
		
	}
}
