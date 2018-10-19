package com.gojek.ParkingLotProblem;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ParkingLot p = new ParkingLot();
        p.createParkingLot("0");
        p.park("ABC", "White");
        p.getSlotNumberFromRegNo("ABC");
        p.leave("6");
    }
}
