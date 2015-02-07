// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1073.robot15.subsystems;

import org.usfirst.frc1073.robot15.Robot;
import org.usfirst.frc1073.robot15.RobotMap;
import org.usfirst.frc1073.robot15.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Elevator extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput elevatorMagLow = RobotMap.elevatorelevatorMagLow;
    DigitalInput elevatorMagMed = RobotMap.elevatorelevatorMagMed;
    DigitalInput elevatorMagHigh = RobotMap.elevatorelevatorMagHigh;
    Solenoid elevatorFirstStageSolenoid = RobotMap.elevatorelevatorFirstStageSolenoid;
    Solenoid elevatorSecondStageSolenoid = RobotMap.elevatorelevatorSecondStageSolenoid;
    AnalogInput irSensor = RobotMap.elevatorirSensor;
    DigitalInput limitSwitch = RobotMap.elevatorlimitSwitch;
    Solenoid elevatorStackHolder = RobotMap.elevatorelevatorStackHolder;
    CANTalon elevatorRollerTalon = RobotMap.elevatorelevatorRollerTalon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
 // easy to call variables for pnuematics
    private final boolean OPEN = true; 
    private final boolean CLOSE = false;
    
    private int totesHeld = 0; // The number of totes in the robot
    private boolean magPassed = true;
    
    private int state = 0; // State of the elevator
    /*********************
     * 
     * 0 = stopped
     * 1 = piston out
     * 3 = piston in
     * 
     *********************/
    
    private int stopPoint = 0; //The point it is at
    /************************
     * 
     * 0 = all the way out
     * 1 = stop at scoring platform
     * 2 = put tote in stack in elevator
     * 3 = stack on top of another tote on field
     * 
     ************************/
    
    private int goToPoint = 0; // The point it is going to
    /************************
     * 
     * 0 = all the way out
     * 1 = stop at scoring platform
     * 2 = put tote in stack in elevator
     * 3 = stack on top of another tote on field
     * 
     ************************/

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new ToteElevatorCounter());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    // Method to set the totes amount
    public void setTotesHeld(int totes) {
    	totesHeld = totes;
    }
    
    // Returns the amount of totes
    public int getTotesHeld() {
    	return totesHeld;
    }
    
    // Returns the IR Sensor value
    public int getIrVal(){
    	return irSensor.getValue();
    }
    
    // Returns the limit switch value
    public boolean isSwitchHit(){
    	return limitSwitch.get();
    }
    
    // Method to collect the rollers to role in a tote
    public void rollersCollect(){
    	elevatorRollerTalon.set(0.7);
    }
    
    // Method ejects the totes on rolers
    public void rollersPurge(){
    	elevatorRollerTalon.set(-0.7);
    }
    
    // Method to turn the rolers off
    public void rollersOff(){
    	elevatorRollerTalon.set(0.0);
    }

    /* 
     * The sequence of solenoid transactions is significant. DO NOT reorder casually!!
     */
    
    // Method to pull the elevator pistons in
    private void pistonIn(){
//    	elevatorFirstStageSolenoid.set(OPEN);
    	elevatorFirstStageSolenoid.set(CLOSE);
    	elevatorSecondStageSolenoid.set(OPEN);
    	state = 2;
    }
    
    // Method to push the piston out
    private void pistonOut(){
    	elevatorSecondStageSolenoid.set(CLOSE);
    	elevatorFirstStageSolenoid.set(OPEN);
    	state = 1;
    }
    
    // Method to stop the piston where it is
    private void pistonStop(){
    	elevatorFirstStageSolenoid.set(CLOSE);
    	elevatorSecondStageSolenoid.set(CLOSE);
    	state = 0;
    }
    
    // Method to extend the holders that will hold the totes up
    public void stackHold(){
    	elevatorStackHolder.set(OPEN);
    }
    
    // Method to retract the holders that will hold the stack
    public void stackDrop(){
    	elevatorStackHolder.set(CLOSE);
    }
    
    // Returns the state of elevator
    public int getState(){
    	return state;
    }
    
    // Returns the stop point
    public int getStopPoint(){
    	return stopPoint;
    }
    
    public void resetMagPassed(){
    	magPassed = true;
    }
    
    // Method to move the elevator to a given position from any point
    // Elevator magnet switch is -ve polarity, i.e. false = "at magnet position"
    // Delete magPassed stuff - it doesn't add function
    public void move(int newGoTo){
    	goToPoint = newGoTo;
    	boolean theHeight;
    	if(goToPoint == stopPoint) pistonStop();
    	else if(goToPoint > stopPoint){
    		pistonIn(); // Unnecessary
    		if(goToPoint == 1) theHeight = elevatorMagLow.get();    // This is for the scoring platform
        	if(goToPoint == 2) theHeight = elevatorMagMed.get();    // This is for stacking the totes in the elevator
        	else theHeight = elevatorMagHigh.get();  // This is to stack on a tote that is already on platform
        	
        	// magPassed stores last stable value of theHeight, therefore also -ve polarity.
        	if(!theHeight) magPassed = false;
        	if(!theHeight || !magPassed){
        		pistonStop();
        		stopPoint = goToPoint;
        	}
        	else{
        		pistonIn();
        	}
    	}
    	else {
    		pistonOut();	// Unnecessary
    		if(goToPoint == 2){
    			theHeight = elevatorMagMed.get();
    			
    			if(!theHeight) magPassed = false;
            	if(!theHeight || !magPassed){
            		pistonStop();
            		stopPoint = goToPoint;
            	}
            	else{
            		pistonOut();
            	}
    		}
    		if(goToPoint == 1){
    			theHeight = elevatorMagLow.get();
    			
    			if(!theHeight) magPassed = false;
            	if(!theHeight || !magPassed){
            		pistonStop();
            		stopPoint = goToPoint;
            	}
            	else{
            		pistonOut();
            	}
    		}
    		else{	// goToPoint must have been 0
    			pistonOut();	// No stop condition needed, stops when cylinder full
    			stopPoint = 0;
    		}
    	}
    	
    }
    
}

