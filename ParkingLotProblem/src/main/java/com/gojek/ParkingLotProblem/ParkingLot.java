package com.gojek.ParkingLotProblem;

import java.util.ArrayList;
import java.util.Map;

public class ParkingLot {
	int size = 0;
	
	ArrayList<Integer> slotsAvailable;
	Map<String,Car> slotCar;
	Map<String, String> slotRegno;
	Map<String, ArrayList<String>> colorRegno;
	
	public void createParkingLot(String size) {
		try {
			this.size = Integer.parseInt(size);
		} catch(Exception e) {
			System.out.println("Invalid lot size, Parking lot is not created.");
		}
	}
}
