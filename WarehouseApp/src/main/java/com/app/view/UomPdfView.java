package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView 
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
		
		response.addHeader("Content-Disposition", "attachment;filename=uoms.pdf");
		
		
		//1. creating elements
		Paragraph p=new Paragraph("Hello All");
		//2. add element to doc
		document.add(p);
		
		//3. read data from ModelMap
		List<Uom> uoms=(List<Uom>) model.get("list");
		
		//4. Create Table
		PdfPTable table=new PdfPTable(4);
		table.addCell("ID");
		table.addCell("TYPE");
		table.addCell("MODEL");
		table.addCell("NOTE");
		
		for(Uom u:uoms) {
			table.addCell(u.getId().toString());
			table.addCell(u.getUomType());
			table.addCell(u.getUomModel());
			table.addCell(u.getDescription());
		}
		document.add(table); //**
		
		document.add(new Paragraph(new Date().toString()));
	}

}


