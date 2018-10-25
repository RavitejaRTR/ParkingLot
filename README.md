# ParkingLot
Parking slot allocation system (input-file/interactive mode)

Assumptions about messages to be displayed when the size entered is zero/negative are made.

Developed the application in Java using maven as build tool.

The jar file ParkingLotProblem/target/ParkingLotProblem-0.1.jar is the executable file.

If you are running bash files as mentioned in pdf
(Path in terminal should be the project directory where bin,src,pom.xml are present)

Now run:
for build: bin/./setup.txt
for running: bin/.parking_lot.txt <inputfile> (inputfile is optional)

Two ways to run the application if followed the below 'Note'

Input_file mode : java -jar ParkingLotProblem-0.1.jar <Input_file>      
Interactive mode: java -jar ParkingLotProblem-0.1.jar

Note: Have the command line opened to the exact folder the jar file is present.
