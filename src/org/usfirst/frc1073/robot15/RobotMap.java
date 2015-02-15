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
    
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Gyro driveTraingyro;
    public static CANTalon driveTraindriveFrontRight;
    public static CANTalon driveTraindriveBackLeft;
    public static CANTalon driveTraindriveBackRight;
    public static CANTalon driveTraindriveFrontLeft;
    public static AnalogInput rangeFinderultrasonic;
    public static CANTalon collectorWheelstoteCollectorLeftTalon;
    public static CANTalon collectorWheelstoteCollectorRightTalon;
    public static Solenoid elevatorelevatorSecondStageSolenoid;
    public static Solenoid elevatorelevatorFirstStageSolenoid;
    public static DigitalInput elevatorelevatorMagBottom;
    public static DigitalInput elevatorelevatorMagLow;
    public static DigitalInput elevatorelevatorMagMed;
    public static DigitalInput elevatorelevatorMagHigh;
    public static AnalogInput elevatorirSensor;
    public static DigitalInput elevatorlimitSwitch;
    public static Solenoid elevatorelevatorStackHolderSolenoid;
    public static CANTalon elevatorelevatorRollerTalon;
    public static CANTalon binCollectorbinCollectorTalon;
    public static Solenoid binCollectorbinCollectorSolenoid;
    public static Solenoid collectorWriststoteCollectorSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static BuiltInAccelerometer driveTrainaccelerometer;

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTraingyro = new Gyro(0);
        LiveWindow.addSensor("DriveTrain", "gyro", driveTraingyro);
        driveTraingyro.setSensitivity(0.007);
        driveTraindriveFrontRight = new CANTalon(8);
        
        
        driveTraindriveBackLeft = new CANTalon(2);
        
        
        driveTraindriveBackRight = new CANTalon(9);
        
        
        driveTraindriveFrontLeft = new CANTalon(3);
        
        
        rangeFinderultrasonic = new AnalogInput(2);
        LiveWindow.addSensor("RangeFinder", "ultrasonic", rangeFinderultrasonic);
        
        collectorWheelstoteCollectorLeftTalon = new CANTalon(4);
        
        
        collectorWheelstoteCollectorRightTalon = new CANTalon(7);
        
        
        elevatorelevatorSecondStageSolenoid = new Solenoid(1, 5);
        LiveWindow.addActuator("Elevator", "elevatorSecondStageSolenoid", elevatorelevatorSecondStageSolenoid);
        
        elevatorelevatorFirstStageSolenoid = new Solenoid(1, 4);
        LiveWindow.addActuator("Elevator", "elevatorFirstStageSolenoid", elevatorelevatorFirstStageSolenoid);
        
        elevatorelevatorMagBottom = new DigitalInput(0);
        LiveWindow.addSensor("Elevator", "elevatorMagBottom", elevatorelevatorMagBottom);
        
        elevatorelevatorMagLow = new DigitalInput(3);
        LiveWindow.addSensor("Elevator", "elevatorMagLow", elevatorelevatorMagLow);
        
        elevatorelevatorMagMed = new DigitalInput(4);
        LiveWindow.addSensor("Elevator", "elevatorMagMed", elevatorelevatorMagMed);
        
        elevatorelevatorMagHigh = new DigitalInput(5);
        LiveWindow.addSensor("Elevator", "elevatorMagHigh", elevatorelevatorMagHigh);
        
        elevatorirSensor = new AnalogInput(1);
        LiveWindow.addSensor("Elevator", "irSensor", elevatorirSensor);
        
        elevatorlimitSwitch = new DigitalInput(2);
        LiveWindow.addSensor("Elevator", "limitSwitch", elevatorlimitSwitch);
        
        elevatorelevatorStackHolderSolenoid = new Solenoid(1, 1);
        LiveWindow.addActuator("Elevator", "elevatorStackHolderSolenoid", elevatorelevatorStackHolderSolenoid);
        
        elevatorelevatorRollerTalon = new CANTalon(6);
        
        
        binCollectorbinCollectorTalon = new CANTalon(5);
        
        
        binCollectorbinCollectorSolenoid = new Solenoid(1, 2);
        LiveWindow.addActuator("BinCollector", "binCollectorSolenoid", binCollectorbinCollectorSolenoid);
        
        collectorWriststoteCollectorSolenoid = new Solenoid(1, 0);
        LiveWindow.addActuator("CollectorWrists", "toteCollectorSolenoid", collectorWriststoteCollectorSolenoid);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    
    driveTrainaccelerometer = new BuiltInAccelerometer();    
        
    }
}
