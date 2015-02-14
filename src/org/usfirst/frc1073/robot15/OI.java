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
    public JoystickButton setFieldRel;
    public JoystickButton totePuchButton;
    public Joystick driver;
    public JoystickButton clawButton;
    public JoystickButton collectorPrepButton;
    public JoystickButton collectButton;
    public JoystickButton stackButton;
    public JoystickButton ejectPrepButton;
    public JoystickButton toGroundFloorButton;
    public JoystickButton toStepFloorButton;
    public JoystickButton toToteFloorButton;
    public JoystickButton toStepToteFloorButton;
    public JoystickButton clawToggleButton;
    public JoystickButton winchUpButton;
    public JoystickButton winchDownButton;
    public Joystick operator;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        operator = new Joystick(1);
        
        winchDownButton = new JoystickButton(operator, 4);
        winchDownButton.whileHeld(new WinchDown());
        winchUpButton = new JoystickButton(operator, 6);
        winchUpButton.whileHeld(new WinchUp());
        clawToggleButton = new JoystickButton(operator, 3);
        clawToggleButton.whenPressed(new ClawToggle());
        toStepToteFloorButton = new JoystickButton(operator, 9);
        toStepToteFloorButton.whileHeld(new ToStepToteFloor());
        toToteFloorButton = new JoystickButton(operator, 10);
        toToteFloorButton.whileHeld(new ToToteFloor());
        toStepFloorButton = new JoystickButton(operator, 7);
        toStepFloorButton.whileHeld(new ToStepFloor());
        toGroundFloorButton = new JoystickButton(operator, 8);
        toGroundFloorButton.whileHeld(new ToGroundFloor());
        ejectPrepButton = new JoystickButton(operator, 12);
        ejectPrepButton.whenPressed(new EjectPrep());
        stackButton = new JoystickButton(operator, 5);
        stackButton.whenPressed(new Stack());
        collectButton = new JoystickButton(operator, 1);
        collectButton.whileHeld(new Collect());
        collectorPrepButton = new JoystickButton(operator, 2);
        collectorPrepButton.whenPressed(new CollectorPrep());
        clawButton = new JoystickButton(operator, 11);
        clawButton.whileHeld(new Claw());
        driver = new Joystick(0);
        
        totePuchButton = new JoystickButton(driver, 1);
        totePuchButton.whileHeld(new Puch());
        setFieldRel = new JoystickButton(driver, 3);
        setFieldRel.whenPressed(new FieldRel());

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("FieldRel", new FieldRel());

        SmartDashboard.putData("AutonomousBackup", new AutonomousBackup());

        SmartDashboard.putData("ToToteFloor", new ToToteFloor());


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

