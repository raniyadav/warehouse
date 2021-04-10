package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class UomUtil {

	public void genPie(
			String path,List<Object[]> list) 
	{
		//1. create DataSet
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list) {
			dataset.setValue(ob[0].toString(),
					new Double(ob[1].toString()));
		}
		
		//2. Create JFreeChart object
		JFreeChart chart=ChartFactory.createPieChart3D("UOM PIE CHART", dataset); 
		
		
		//3. save as Image
		try {
			ChartUtils.saveChartAsJPEG(
					new File(path+"/resources/images/UomPie.jpg"),
					chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void genBar(String path,List<Object[]> list) {
		//1. create DataSet
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		
		for(Object[] ob:list) {
			dataset.setValue(new Double(ob[1].toString()),
					ob[0].toString(),"");
		}
		
		//2. Create JFreeChart obj
		JFreeChart chart=ChartFactory.createBarChart("UOM BAR CHART", "Uom Types", "Count", dataset); 
		
		//3. save as Image
		try {
			ChartUtils.saveChartAsJPEG(
					new File(path+"/resources/images/UomBar.jpg"),
					chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
}



