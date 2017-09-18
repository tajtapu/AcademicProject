package com.java.parse;

import java.util.ArrayList;
import java.util.List;

public class Operation {

	public static void main(String[] args) {
		
		final String inputFileName = "C:/Users/Tajul/Desktop/temp.xlsx";
		final String outputFileName = "C:/Users/Tajul/Desktop/output.xlsx";
		final String velocityFileName = "C:/Users/Tajul/Desktop/velocity.xlsx";
		final String distanceFileName = "C:/Users/Tajul/Desktop/distance.xlsx";
		List<Data> rawData = ParseExcel.parseExcel(inputFileName);
		List<Data> dataWithoutGravity = new ArrayList<Data>();
		for(Data d:rawData) {
			Data withoutGravity = GravityRemoval.removeGravity(d);
			dataWithoutGravity.add(withoutGravity);
		}
		List<Data> velocityDataList = new ArrayList<Data>();
		double initialXAxisVelocity = PhysicsCalculatorUtil.calculateByAxis(0, 0, dataWithoutGravity.get(0).getX());
		double initialYAxisVelocity = PhysicsCalculatorUtil.calculateByAxis(0, 0, dataWithoutGravity.get(0).getY());
		double initialZAxisVelocity = PhysicsCalculatorUtil.calculateByAxis(0, 0, dataWithoutGravity.get(0).getZ());
		velocityDataList.add(new Data(initialXAxisVelocity, initialYAxisVelocity, initialZAxisVelocity, dataWithoutGravity.get(0).getDateString()));
		for(int i=1; i<dataWithoutGravity.size(); i++) {
			double xAxisVelocity = PhysicsCalculatorUtil.calculateByAxis(velocityDataList.get(i-1).getX(), dataWithoutGravity.get(i-1).getX(), dataWithoutGravity.get(i).getX());
			double yAxisVelocity = PhysicsCalculatorUtil.calculateByAxis(velocityDataList.get(i-1).getY(), dataWithoutGravity.get(i-1).getY(), dataWithoutGravity.get(i).getY());
			double zAxisVelocity = PhysicsCalculatorUtil.calculateByAxis(velocityDataList.get(i-1).getZ(), dataWithoutGravity.get(i-1).getZ(), dataWithoutGravity.get(i).getZ());
			velocityDataList.add(new Data(xAxisVelocity, yAxisVelocity, zAxisVelocity, dataWithoutGravity.get(i).getDateString()));
		}
		List<Data> distanceDataList = new ArrayList<Data>();
		double initialXAxisdistance = PhysicsCalculatorUtil.calculateByAxis(0, 0, velocityDataList.get(0).getX());
		double initialYAxisdistance = PhysicsCalculatorUtil.calculateByAxis(0, 0, velocityDataList.get(0).getY());
		double initialZAxisdistance = PhysicsCalculatorUtil.calculateByAxis(0, 0, velocityDataList.get(0).getZ());
		distanceDataList.add(new Data(initialXAxisdistance, initialYAxisdistance, initialZAxisdistance, velocityDataList.get(0).getDateString()));
		for(int i=1; i<velocityDataList.size(); i++) {
			double xAxisdistance = PhysicsCalculatorUtil.calculateByAxis(distanceDataList.get(i-1).getX(), velocityDataList.get(i-1).getX(), velocityDataList.get(i).getX());
			double yAxisdistance = PhysicsCalculatorUtil.calculateByAxis(distanceDataList.get(i-1).getY(), velocityDataList.get(i-1).getY(), velocityDataList.get(i).getY());
			double zAxisdistance = PhysicsCalculatorUtil.calculateByAxis(distanceDataList.get(i-1).getZ(), velocityDataList.get(i-1).getZ(), velocityDataList.get(i).getZ());
			distanceDataList.add(new Data(xAxisdistance, yAxisdistance, zAxisdistance, velocityDataList.get(i).getDateString()));
		}
		ExcelWrite.writeToExcel(dataWithoutGravity, outputFileName);
		ExcelWrite.writeToExcel(velocityDataList, velocityFileName);
		ExcelWrite.writeToExcel(distanceDataList, distanceFileName);
	}

}
