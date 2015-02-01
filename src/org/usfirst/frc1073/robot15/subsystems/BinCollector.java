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
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class BinCollector extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DoubleSolenoid binCollectorDoubleSolenoid = RobotMap.binCollectorbinCollectorDoubleSolenoid;
    CANTalon binCollectorTalon = RobotMap.binCollectorbinCollectorTalon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private boolean isClosed; //State of the bin holder
    private final double SPEED = 0.4; //May need to be changed
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void binLift(){
    	binCollectorTalon.set(SPEED);
    }
    
    public void binLower(){
    	binCollectorTalon.set(-SPEED);
    }
    
    public void close() {
    	binCollectorTalon.set(-1);
    	binCollectorDoubleSolenoid.set(Value.kReverse);
    	isClosed = true;
    	SmartDashboard.putBoolean("Bin Collector Collecting", isClosed);
    	
    }
    
    public boolean getState(){
    	return isClosed;
    }
    
	public void open() {
		binCollectorTalon.set(1);
		binCollectorDoubleSolenoid.set(Value.kForward);
		isClosed = false;
		SmartDashboard.putBoolean("Bin Collector Collecting", isClosed);
	}		
	
}

