package org.usfirst.frc.team3140.robot;

import org.usfirst.frc.team3140.robot.library.SmartJoystick;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3140.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap {
	
	private static SmartJoystick dStick;
	private JoystickButton bottomGrab, topGrab;
	
	/**
	 * Assigns joysticks to a port
	 * Calls the tie() method
	 */
	public OI() {
		dStick = new SmartJoystick(kDriveStick);
		tie();
	}
	
	/**
	 * Initializes JoystickButtons and assigns button on joystick
	 * Calls check() method
	 */
	private void tie() {
		bottomGrab = new JoystickButton(dStick, kGrabber);
		topGrab = new JoystickButton(dStick, kArm);
		check();
	}
	
	/**
	 * Listens to the joystick to determine if any buttons were pressed.
	 * If a button is pressed, call the respective command
	 * @throws InterruptedException
	 */
	private void check() {
		bottomGrab.whenPressed(new BottomGrabber());
		topGrab.whenPressed(new TopGrabber());
	}
	
	public static SmartJoystick getDriveStick() {
		return dStick;
	}
}


