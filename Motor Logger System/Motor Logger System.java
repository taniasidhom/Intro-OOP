//Assignment 2: Tania Sidhom (netID: 16ttas; student number: 20061390)

import java.io.BufferedReader;
import java.io.BufferedWriter; 
import java.io.IOException;
import java.util.StringTokenizer; 
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files; 


public class Assn2_16ttas {
	
	//size of the array
	final static int TOTCOLS = 8; 
	final static int TOTROWS = 1000; 
	final static double MAXCURRENT = 8.0;
	
	//read the supplied csv file
	public static String[] readCsv(String inputFile) {
		String[] array = new String[TOTROWS]; 
		Path file = Paths.get(inputFile); 
		if (!file.toFile().exists()) {
			System.err.println("File " + inputFile + " does not exist.");
			return null;
		}
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			for(int i = 0; i < TOTROWS; i++) {
				array[i] = reader.readLine(); 
			}
		} catch (IOException err) {
			System.err.println(err.getMessage());
			return null;
		} 
		return array;
	}
	
	//generate error message if contents of string array are empty 
	public static void checkContents(String[] contents) {
		while (contents == null) {
			System.err.println("Empty contents in file!");
			return;
		}
	}
	
	//convert array of strings to 2-D array of doubles (tokens)
	//use StringTokenizer method
	public static double[][] arrayTokens(String[] elements) {
		
		StringTokenizer tokenizer;
		double log; 
		double[][] logData;
		logData = new double[TOTROWS][TOTCOLS];
		for(int row = 0; row < TOTROWS; row++) {
			tokenizer = new StringTokenizer(elements[row], ",");
				
			for(int col = 0; col < TOTCOLS; col++) {
				log = Double.parseDouble(tokenizer.nextToken());
				logData[row][col] = log; 
			}
		}
		return logData;
	}
	
	//calculate average current when motor is running
	public static double averageCurrent(double current, int startTime, int endTime) {
		double currentAvg = 0;
		if(current > 0)
			currentAvg = current/(endTime - startTime + 1);
			currentAvg = Math.round(currentAvg*1000)/1000.0;
			return currentAvg;
	}
	
	
	//generate output string for each motor based on logger data
	//only values of motor data are used when current is over the threshold of 1 amp
	//indicates when current has exceeded the max. of 8 amps
	public static String motorInfo(double[][] logData, int motor) {
		int runTime;
		int startTime = 0;
		int endTime = 0;
		double current = 0;
		double avgCurrent = 0; 
		String output = ""; 
		
		for(int row = 0; row < TOTROWS; row++) {
			current = logData[row][motor]; 
			runTime = (int)logData[row][0]; 
			
			if(current >= 1.0) {
				if (startTime == 0)
					startTime = runTime; 
				avgCurrent += current; 
			} else if (startTime > 0){
				endTime = runTime - 1;
				avgCurrent = averageCurrent(avgCurrent, startTime, endTime);
				output += startTime + ", " + endTime + ", " + avgCurrent; 
				
				if (avgCurrent >= MAXCURRENT)
					output += ", ***Current Exceeded***."; 
				output += "\r\n"; 
				startTime = 0;
				avgCurrent = 0;
			}
		}
		while(output.length() == 0)
			output += "Not used.\r\n";
		return output;
	}
	
	//generate report for one motor 
	public static void writeReport(String outputFile, String report) { 
		Path file = Paths.get(outputFile); 
		try (BufferedWriter writer = Files.newBufferedWriter(file)) {
			writer.write(report);
		} catch (IOException err) {
			System.err.println(err.getMessage()); 
		}
	}
	//compile report containing all motors
	public static void reportExecution() {
		String report; 
		double[][] loggerData;
		loggerData = arrayTokens(readCsv("Logger.csv")); 
		
		for (int motorNum = 1; motorNum < 8; motorNum++) {
			report = "start (sec), finish (sec), current (amps)\r\n"; 
			report += motorInfo(loggerData, motorNum); 
			writeReport("Motor" + motorNum + ".csv", report);
		}
	}
	
	//execute final analysis 
	public static void main(String[] args) {
		reportExecution();
		System.out.println("Motor data analysis is complete.");
	}

}
