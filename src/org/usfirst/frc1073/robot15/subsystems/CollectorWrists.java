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

import org.usfirst.frc1073.robot15.RobotMap;
import org.usfirst.frc1073.robot15.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class CollectorWrists extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Solenoid toteCollectorSolenoid = RobotMap.collectorWriststoteCollectorSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private final boolean CLOSE = true;
    private final boolean OPEN = false;
    
    private boolean isOpen;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    // Method to spread to collector open
    public void close(){
    	isOpen = false;
    	toteCollectorSolenoid.set(CLOSE);
    }
    
    // Method to close the collector together
    public void open(){
    	isOpen = true;
    	toteCollectorSolenoid.set(OPEN);
    }
    
    // Returns the state of the collector wrists
    public boolean getState(){
    	return isOpen;
    }
    
    // Method that can be called while testing
    public void testInformation(){
    	SmartDashboard.putBoolean("Tote Collector Collecting", isOpen);
    }
    
}

