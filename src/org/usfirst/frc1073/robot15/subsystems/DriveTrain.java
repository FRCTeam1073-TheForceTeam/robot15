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

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Gyro gyro = RobotMap.driveTraingyro;
    CANTalon driveFrontRight = RobotMap.driveTraindriveFrontRight;
    CANTalon driveBackLeft = RobotMap.driveTraindriveBackLeft;
    CANTalon driveBackRight = RobotMap.driveTraindriveBackRight;
    CANTalon driveFrontLeft = RobotMap.driveTraindriveFrontLeft;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public final float cubicConstant = (float) 0.12;
    
    BuiltInAccelerometer accelerometer = RobotMap.driveTrainaccelerometer;
    
    private boolean isFieldRel = false;
    private RobotDrive drive;
    private boolean isCubic;
    private boolean isStraight;
    private double gyroAngle;
    private float twistCorrectionSpeed = 1;
    
    // Constructs the DriveTrain
    public DriveTrain(){
        drive = new RobotDrive(driveFrontLeft, driveBackLeft, driveFrontRight, driveBackRight);
    	isCubic = true; // set to true so we can test it with it on
    	drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true); // Inverts the motor because it is facing the other direction
		// drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false); unneeded but not tested
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true); // Inverts the motor because it is facing the other direction
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true); // Inverts the motor because it is facing the other direction
		gyro.reset(); //Resets gyro once so field relative has one 'true' North direction
    }
    
    // Method to toggle Field Relative
    public void setFieldRel(){
    	isFieldRel = !isFieldRel;
    	// SmartDashboard.putBoolean("FieldRelative", isFieldRel); this was for testing
    }
    
    /******************************************
     * 
     * @param x is the joystick x value
     * @param y is the joystick y value
     * @param z is the joystick twist value
     ******************************************/
    public void move(float x, float y, float z){
    	
    	// For testing
    	SmartDashboard.putNumber("Unramped X: ", x); 
    	SmartDashboard.putNumber("Unramped Y: ", y); 
    	SmartDashboard.putNumber("Twist value: ", z);
    	
    	if(isCubic){
    		x = cubicScale(x);
    		y = cubicScale(y);
    		z = cubicScale(z);
    		 SmartDashboard.putNumber("Ramped X: ", x);
        	 SmartDashboard.putNumber("Ramped Y: ", y); 
    	}
    	
    	/* if (y != 0 && x == 0 && z == 0){
    		if(!isStraight){
    			gyroAngle = getGyroAngle();
    			isStraight = true;
    		}
    		if(getGyroAngle() > gyroAngle + 0.05){                         KEENAN WAS CLEARLY HERE 
    			z = twistCorrectionSpeed;
    		}
    		if(getGyroAngle() < gyroAngle - 0.05 ){
    			z = -twistCorrectionSpeed;
    		}
    	}
    	else isStraight = false; */
    	
    	if(!isFieldRel){
    		drive.mecanumDrive_Cartesian(x, y, z, 0); //0 is in place of gyro value for field relative
    	}
    	else drive.mecanumDrive_Cartesian(x, y, z, gyro.getAngle());
    	
    	//For testing
    	SmartDashboard.putNumber("The front left val:", driveFrontLeft.get());
    	SmartDashboard.putNumber("The back left val:", driveBackLeft.get());
    	SmartDashboard.putNumber("The front right val:", driveFrontRight.get());
    	SmartDashboard.putNumber("The back right val:", driveBackRight.get());
    	
    	SmartDashboard.putNumber("Gyro value is:", Math.abs(gyro.getAngle() % 360)); //Sets the gyro values to always be positive and never go above 360 degrees
    	SmartDashboard.putNumber("The accelerometer x value is:", accelerometer.getX());
    	SmartDashboard.putNumber("The accelerometer y value is:", accelerometer.getY());
    }
    
    // Method to do the cubic scaling
    private float cubicScale(float arg){
    	float a;
    	a = (float) (cubicConstant*arg + (1-cubicConstant)*Math.pow((double)arg, 3));
    	return a;
    }
    public void setCubic(){
    	isCubic = !isCubic;
    }
    
    // Method to reset the gyro
    public void resetGyro(){
    	gyro.reset();
    }
    
    // Returns the gyro angle
    public double getGyroAngle(){
    	return(gyro.getAngle());
    }
    
    // Returns if the robot is in cubic drive
    public boolean isCubicDrive(){
    	return isCubic;
    }
    
    // Returns if the robot is in field relative
    public boolean isFieldRelative(){
    	return isFieldRel;
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand(){
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new Drive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
    }
    
}

