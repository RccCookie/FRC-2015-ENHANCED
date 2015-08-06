package org.usfirst.frc.team3140.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * RobotMap is the mapping of essential constants that can be store in one
 * easily located place, so that these values can be changed in RobotMap
 * without affecting the programming elsewhere.
 */
public interface RobotMap {

	/**
	 * Joystick port(s)
	 */
	public static int kDriveStick = 0;
	
	/**
	 * Joystick buttons
	 */
	//DriveStick's buttons
	public static int kGrabber = 1;
	public static int kArm = 2;
	
	/*
	 *  END OF EDITABLE CONSTANTS, DENOTED BY (!!!)
	 */
	
	/**
	 * Motors (!!!)
	 */
	public static int kLeftDriveMotorPWM = 1;
	public static int kLeftDriveMotorPDP1 = 14;
	public static int kLeftDriveMotorPDP2 = 15;
	
	public static int kRightDriveMotorPWM = 2;
	public static int kRightDriveMotorPDP1 = 0;
	public static int kRightDriveMotorPDP2 = 1;
	
	public static int kWinchMotorPWM = 3;
	public static int kWinchMotorPDP = 4;
	
	/**
	 * Digital I/O (!!!)
	 */
	public static int kLeftDriveEncoderA = 12;
	public static int kLeftDriveEncoderB = 13;
	
	public static int kRightDriveEncoderA = 0;
	public static int kRightDriveEncoderB = 1;
	
	/**
	 * Pneumatics (!!!)
	 */
	public static int kTopGrabberA = 0;
	public static int kTopGrabberB = 1;
	
	public static int kBottomGrabberA = 2;
	public static int kBottomGrabberB = 3;
	
	public static int kShifterA = 4;
	public static int kShifterB = 5;
	
	public static Value EXT = DoubleSolenoid.Value.kForward;
	public static Value RET = DoubleSolenoid.Value.kReverse;
	
}
