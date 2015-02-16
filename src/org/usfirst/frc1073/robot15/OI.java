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
    public JoystickButton winchUpButton;
    public JoystickButton winchDownButton;
    public JoystickButton clawToggleButton;
    public Joystick driver;
    public JoystickButton ratchetToggleButton;
    public JoystickButton collectButton;
    public JoystickButton armsToggleButton;
    public JoystickButton elevatorUpButton;
    public JoystickButton elevatorDownButton;
    public JoystickButton purgeStackButton;
    public JoystickButton rollersCollectButton;
    public JoystickButton floor0Button;
    public JoystickButton floor1Button;
    public JoystickButton floor2Button;
    public JoystickButton floor3Button;
    public Joystick operator;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        operator = new Joystick(1);
        
        floor3Button = new JoystickButton(operator, 7);
        floor3Button.whileHeld(new ToFloor3());
        floor2Button = new JoystickButton(operator, 8);
        floor2Button.whileHeld(new ToFloor2());
        floor1Button = new JoystickButton(operator, 9);
        floor1Button.whileHeld(new ToFloor1());
        floor0Button = new JoystickButton(operator, 10);
        floor0Button.whileHeld(new ToFloor0());
        rollersCollectButton = new JoystickButton(operator, 5);
        rollersCollectButton.whileHeld(new RollersCollect());
        purgeStackButton = new JoystickButton(operator, 2);
        purgeStackButton.whileHeld(new PurgeRollers());
        elevatorDownButton = new JoystickButton(operator, 4);
        elevatorDownButton.whileHeld(new ElevatorDownManual());
        elevatorUpButton = new JoystickButton(operator, 6);
        elevatorUpButton.whileHeld(new ElevatorUpManual());
        armsToggleButton = new JoystickButton(operator, 11);
        armsToggleButton.whenPressed(new ArmsToggle());
        collectButton = new JoystickButton(operator, 1);
        collectButton.whileHeld(new Collect());
        ratchetToggleButton = new JoystickButton(operator, 12);
        ratchetToggleButton.whenPressed(new ToggleHolders());
        driver = new Joystick(0);
        
        clawToggleButton = new JoystickButton(driver, 12);
        clawToggleButton.whenPressed(new ClawToggle());
        winchDownButton = new JoystickButton(driver, 3);
        winchDownButton.whileHeld(new WinchDown());
        winchUpButton = new JoystickButton(driver, 5);
        winchUpButton.whileHeld(new WinchUp());

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("PurgeRollers", new PurgeRollers());

        SmartDashboard.putData("FieldRel", new FieldRel());

        SmartDashboard.putData("WinchUp", new WinchUp());

        SmartDashboard.putData("WinchDown", new WinchDown());

        SmartDashboard.putData("ElevatorUpManual", new ElevatorUpManual());

        SmartDashboard.putData("ElevatorDownManual", new ElevatorDownManual());

        SmartDashboard.putData("ArmsToggle", new ArmsToggle());


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

