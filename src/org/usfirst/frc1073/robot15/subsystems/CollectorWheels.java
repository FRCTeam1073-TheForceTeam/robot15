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

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class CollectorWheels extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    CANTalon toteCollectorLeftTalon = RobotMap.collectorWheelstoteCollectorLeftTalon;
    CANTalon toteCollectorRightTalon = RobotMap.collectorWheelstoteCollectorRightTalon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private final double WHEEL_SPEED = 0.5; // constant to define speed... MIGHT NEED TO BE CHANGED
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new CollectorWheelsHatCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    // Method to use hat control for the collector wheels
    public void hatControl(){
    	int hatPos = Robot.oi.operator.getPOV(0);
    	
    	switch(hatPos){
	    	case -1:
	    		// Do Nothing
	    		wheelsOff();
	    	break;
	    	case 0:
	    		// Forward
	    		wheelsPurge();
	    	break;
	    	case 270:
	    		// Left
	    		wheelsBothLeft();
	    	break;
	    	case 180:
	    		// Backwards
	    		wheelsCollect();
	    	break;
	    	case 90:
	    		// Right
	    		wheelsBothRight();
	    	break;
    	}
    }
    
    // Method to spin the wheels to collect a tote
    public void wheelsCollect() {
    	toteCollectorLeftTalon.set(-WHEEL_SPEED);
        toteCollectorRightTalon.set(WHEEL_SPEED);
    }
    
    public void wheelsBothLeft(){
    	toteCollectorLeftTalon.set(WHEEL_SPEED);
    	toteCollectorRightTalon.set(WHEEL_SPEED);
    }
    
    public void wheelsBothRight(){
    	toteCollectorLeftTalon.set(-WHEEL_SPEED);
    	toteCollectorRightTalon.set(-WHEEL_SPEED);
    }
    
    // Method to spin the wheels to purge a tote
    public void wheelsPurge() {
    	toteCollectorLeftTalon.set(WHEEL_SPEED);
        toteCollectorRightTalon.set(-WHEEL_SPEED);
    }
    
    // Method to turn the wheel motors off
    public void wheelsOff() {
    	toteCollectorLeftTalon.set(0);
    	toteCollectorRightTalon.set(0);
    }
    
    // Returns true if it is collecting
    public boolean isCollecting(){
    	if(toteCollectorLeftTalon.getSetpoint() > 0){
    		return true;
    	}
    	return false;
    }
    
    // Returns true if it is purging
    public boolean isPurging(){
    	if(toteCollectorLeftTalon.getSetpoint() < 0){
    		return true;
    	}
    	return false;
    }
}

