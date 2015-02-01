// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1073.robot15;

import org.usfirst.frc1073.robot15.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton resetGyro;
    public JoystickButton setFieldRel;
    public Joystick driver;
    public JoystickButton binCollectorButton;
    public JoystickButton binCollectorUpButton;
    public JoystickButton binCollectorDownButton;
    public JoystickButton toteElevatorLifterButton;
    public JoystickButton totePuchButton;
    public JoystickButton toteArmsToggleButton;
    public JoystickButton toteCollectorPurgeButton;
    public JoystickButton toteCollectorCollectButton;
    public Joystick operator;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        operator = new Joystick(1);
        
        toteCollectorCollectButton = new JoystickButton(operator, 11);
        toteCollectorCollectButton.whileHeld(new ToteCollectorCollect());
        toteCollectorPurgeButton = new JoystickButton(operator, 12);
        toteCollectorPurgeButton.whileHeld(new ToteCollectorPurge());
        toteArmsToggleButton = new JoystickButton(operator, 3);
        toteArmsToggleButton.whenPressed(new ToteArmsToggle());
        totePuchButton = new JoystickButton(operator, 6);
        totePuchButton.whileHeld(new Puch());
        toteElevatorLifterButton = new JoystickButton(operator, 1);
        toteElevatorLifterButton.whileHeld(new ToteElevatorLifter());
        binCollectorDownButton = new JoystickButton(operator, 1);
        binCollectorDownButton.whileHeld(new BinCollectorDown());
        binCollectorUpButton = new JoystickButton(operator, 1);
        binCollectorUpButton.whileHeld(new BinCollectorUp());
        binCollectorButton = new JoystickButton(operator, 15);
        binCollectorButton.whenPressed(new BinCollect());
        driver = new Joystick(0);
        
        setFieldRel = new JoystickButton(driver, 1);
        setFieldRel.whenPressed(new FieldRel());
        resetGyro = new JoystickButton(driver, 4);
        resetGyro.whenPressed(new ResetGyroCommand());

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("ResetGyroCommand", new ResetGyroCommand());

        SmartDashboard.putData("FieldRel", new FieldRel());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriver() {
        return driver;
    }

    public Joystick getOperator() {
        return operator;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

