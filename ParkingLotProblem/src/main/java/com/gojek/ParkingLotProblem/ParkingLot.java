package com.gojek.ParkingLotProblem;

import java.util.ArrayList;
import java.util.HashMap;
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
		this.slotsAvailable = new ArrayList<Integer>() {};
        for (int i=1; i<= this.size; i++) {
            slotsAvailable.add(i);
        }
        this.slotCar = new HashMap<String, Car>();
        this.slotRegno = new HashMap<String, String>();
        this.colorRegno = new HashMap<String, ArrayList<String>>();
        System.out.println("Created parking lot with " + size + " slots");
	}
}
