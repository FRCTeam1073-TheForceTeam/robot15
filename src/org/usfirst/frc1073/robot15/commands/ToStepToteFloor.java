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
public class  ToStepToteFloor extends Command {

    public ToStepToteFloor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.elevator);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.move(3);
    	Robot.binCollector.open();
    	Robot.binCollector.binLift();
    	Robot.toteCollector.open();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.elevator.getStopPoint() == 3 && Robot.elevator.getState() == 0) {
    		Robot.toteCollector.wheelsPurge();
    		Robot.elevator.rollersPurge();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.toteCollector.wheelsOff();
    	Robot.elevator.rollersOff();
    	Robot.binCollector.close();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
