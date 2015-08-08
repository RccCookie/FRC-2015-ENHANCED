package org.usfirst.frc.team3140.robot;

import org.usfirst.frc.team3140.robot.library.SmartJoystick;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3140.robot.commands.*;
import org.usfirst.frc.team3140.robot.commands.auto.AutoLifter;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap {
	
	private static SmartJoystick dStick;
	private JoystickButton grab, leggo, up1, up2, down1, down2, auto1;
	
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
		grab = new JoystickButton(dStick, kGrab);
		leggo = new JoystickButton(dStick, kLeggo);
		up1 = new JoystickButton(dStick, kUp1);
		up2 = new JoystickButton(dStick, kUp2);
		down1 = new JoystickButton(dStick, kDown1);
		down2 = new JoystickButton(dStick, kDown2);
		auto1 = new JoystickButton(dStick, 11);
		check();
	}
	
	/**
	 * Listens to the joystick to determine if any buttons were pressed.
	 * If a button is pressed, call the respective command
	 * 
	 */
	private void check() {
		grab.whenPressed(new Grab());
		leggo.whenPressed(new Release());
		up1.whenPressed(new Lifter(-1.0));
		up2.whenPressed(new Lifter(-1.0));
		down1.whenPressed(new Lifter(1.0));
		down2.whenPressed(new Lifter(1.0));
		up1.whenReleased(new Lifter(0.0));
		up2.whenReleased(new Lifter(0.0));
		down1.whenReleased(new Lifter(0.0));
		down2.whenReleased(new Lifter(0.0));
		auto1.whenPressed(new AutoLifter(-0.5, 1000));
	}
	
	public static SmartJoystick getDriveStick() {
		return dStick;
	}
}


