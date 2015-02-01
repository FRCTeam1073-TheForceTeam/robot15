// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1073.robot15.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1073.robot15.Robot;

/**
 *
 */
public class  DriveAutonomous extends Command {

	private float driveSpeed = 0.7f;
	
    public DriveAutonomous() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

    	
    	setTimeout(5.0);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	Robot.driveTrain.move(0.0f, driveSpeed, 0.0f);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean isIt = false;
    	
    	if(isTimedOut())
        {
        	isIt = true;;
        }
        if(Robot.rangeFinder.getDistance() > 25)
        {
        	isIt = true;
        }
        return isIt;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.move(0.0f, 0.0f, 0.0f);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
