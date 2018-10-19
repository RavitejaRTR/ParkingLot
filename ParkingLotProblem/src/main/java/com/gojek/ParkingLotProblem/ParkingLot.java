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
			this.size = Integer.parseInt(size)>0?Integer.parseInt(size):0;
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
	
	public void leave(String slotNo) {
        if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (this.slotCar.size() > 0) {
            Car carToLeave = this.slotCar.get(slotNo);
            if (carToLeave != null) {
                this.slotCar.remove(slotNo);
                this.slotRegno.remove(carToLeave.regno);
                ArrayList<String> regNoList = this.colorRegno.get(carToLeave.color);
                if (regNoList.contains(carToLeave.regno)) {
                    regNoList.remove(carToLeave.regno);
                }
                this.slotsAvailable.add(Integer.parseInt(slotNo));
                System.out.println("Slot number " + slotNo + " is free");
            } else {
                System.out.println("Slot number " + slotNo + " is already empty");
            }
        }
    }
	
	public void status() {
		if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (this.slotCar.size() > 0) {
            // Print the current status.
            System.out.println("Slot No.\tRegistration No.\tColor");
            Car car;
            for (int i = 1; i <= this.size; i++) {
                String key = Integer.toString(i);
                if (this.slotCar.containsKey(key)) {
                    car = this.slotCar.get(key);
                    System.out.println(i + "\t" + car.regno + "\t" + car.color);
                }
            }
        } else {
            System.out.println("Parking lot is empty");
        }
	}
	
	public void getRegistrationNumbersFromColor(String color) {
		if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (this.colorRegno.containsKey(color)) {
            ArrayList<String> regNoList = this.colorRegno.get(color);
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                if (!(i==regNoList.size() - 1)){
                    System.out.print(regNoList.get(i) + ",");
                } else {
                    System.out.print(regNoList.get(i));
                }
            }
        } else {
            System.out.println("Not found");
        }
	}
	
	public void getSlotNumbersFromColor(String color) {
		if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (this.colorRegno.containsKey(color)) {
            ArrayList<String> regNoList = this.colorRegno.get(color);
            ArrayList<Integer> slotList = new ArrayList<Integer>();
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                slotList.add(Integer.valueOf(this.slotRegno.get(regNoList.get(i))));
            }
            Collections.sort(slotList);
            for (int j=0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ",");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            System.out.println();
        } else {
            System.out.println("Not found");
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
