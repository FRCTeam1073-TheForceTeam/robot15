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

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Dashboard extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new SendToDashboard());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    }
    private int CubicRel(boolean cubic, boolean fieldRel)
    {
    	if(!cubic && !fieldRel)
    	{
    		return 0;
    	}
    	else if(cubic && !fieldRel)
    	{
    		return 1;
    	}
    	else if(!cubic && fieldRel)
    	{
    		return 2;
    	}
    	else if(cubic && fieldRel)
    	{
    		return 3;
    	}
    	return -1;
    }
    
    private int collectPunch(boolean collectingTote, boolean purgingTote, boolean collectingBin, boolean purgingBin)
    {
    	if(collectingTote || collectingBin)
    	{
    		return 0;
    	}
    	else if(purgingTote || purgingBin)
    	{
    		return 1;
    	}
    	return 1;
    }
    
	public void sendData()
	{
		SmartDashboard.putNumber("Driving Mode", CubicRel(Robot.driveTrain.isCubicDrive(), Robot.driveTrain.isFieldRelative()));
		SmartDashboard.putNumber("Tote Count", Robot.elevator.getTotesHeld());
		// SmartDashboard.putNumber("Distance Widget", Robot.rangeFinder.getDistance()); needs to be reworked
		SmartDashboard.putNumber("ToteCollectorInfo", collectPunch(Robot.toteCollector.isCollecting(), Robot.toteCollector.isPurging(), Robot.binCollector.isCollecting(), Robot.binCollector.islowering()));
		SmartDashboard.putNumber("Battery", DriverStation.getInstance().getBatteryVoltage());
		SmartDashboard.putBoolean("Claw", Robot.binCollector.getState());
		SmartDashboard.putBoolean("Wrist", Robot.toteCollector.getState());
		SmartDashboard.putNumber("Elevator Level", Robot.elevator.getState());
		//SmartDashboard.putNumber("Current", )
		//SmartDashboard.putNumber("PSI Gauge", )
		
	}
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
}

