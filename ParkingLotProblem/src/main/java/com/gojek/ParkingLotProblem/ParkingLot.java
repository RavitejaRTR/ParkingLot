package com.gojek.ParkingLotProblem;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public void park(String regNo, String color) {
		if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (this.slotCar.size() == this.size) {
            System.out.println("Sorry, parking lot is full");
        } else {
        	Collections.sort(slotsAvailable);
            String slot = slotsAvailable.get(0).toString();
            Car car = new Car(regNo, color);
            this.slotCar.put(slot, car);
            this.slotRegno.put(regNo, slot);
            if (this.colorRegno.containsKey(color)) {
                ArrayList<String> regNoList = this.colorRegno.get(color);
                this.colorRegno.remove(color);
                regNoList.add(regNo);
                this.colorRegno.put(color, regNoList);
            } else {
                ArrayList<String> regNoList = new ArrayList<String>();
                regNoList.add(regNo);
                this.colorRegno.put(color, regNoList);
            }
            System.out.println("Allocated slot number: " + slot);
            slotsAvailable.remove(0);
            return;
        }
	}
	
	public void getSlotNumberFromRegNo(String regNo) {
		if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (this.slotRegno.containsKey(regNo)) {
            System.out.println(this.slotRegno.get(regNo));
        } else {
            System.out.println("Not found");
        }
	}
	
	
}
