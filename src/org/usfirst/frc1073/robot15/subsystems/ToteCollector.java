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

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class ToteCollector extends Subsystem {
	double wheelSpeed = 0.5;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    CANTalon toteCollectorTalon1 = RobotMap.toteCollectortoteCollectorTalon1;
    CANTalon toteCollectorTalon2 = RobotMap.toteCollectortoteCollectorTalon2;
    DoubleSolenoid toteCollectorDoubleSolenoid = RobotMap.toteCollectortoteCollectorDoubleSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void manipulateToteCollector(boolean collect) {
    	
    	if (collect == true) {
    		toteCollectorDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    	}
    	else {
    		toteCollectorDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    	}
    	
    	SmartDashboard.putBoolean("Tote Collector Collecting", collect);
    		
    }
    
    public void wheelsCollect() {
    	if (toteCollectorDoubleSolenoid.get() == DoubleSolenoid.Value.kForward) {
    		toteCollectorTalon1.set(wheelSpeed);
        	toteCollectorTalon2.set(-wheelSpeed);
    	}
    }
    
    public void wheelsPurge() {
    	if (toteCollectorDoubleSolenoid.get() == DoubleSolenoid.Value.kReverse) {
    		toteCollectorTalon1.set(-wheelSpeed);
        	toteCollectorTalon2.set(wheelSpeed);
    	}
    }
    
    public void wheelsOff() {
    	toteCollectorTalon1.set(0);
    	toteCollectorTalon2.set(0);
    }
}

