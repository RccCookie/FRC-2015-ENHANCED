package robot;

import robot.commands.Grab;
import robot.commands.Lifter;
import robot.commands.Release;
import robot.commands.auto.AutoLifter;
import robot.commands.groups.GrabAndLift;
import library.SmartJoystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap {
	
	private static SmartJoystick dStick;
	private JoystickButton grab, leggo, up1, up2, down1, down2, auto1, gl;
	
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
		gl = new JoystickButton(dStick, 12);
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
		up1.whenPressed(new Lifter(-0.8));
		up2.whenPressed(new Lifter(-0.8));
		down1.whenPressed(new Lifter(0.8));
		down2.whenPressed(new Lifter(0.8));
		up1.whenReleased(new Lifter(0.8));
		up2.whenReleased(new Lifter(0.8));
		down1.whenReleased(new Lifter(0.8));
		down2.whenReleased(new Lifter(0.8));
		auto1.whenPressed(new AutoLifter(-0.5, 1000));
		gl.whenPressed(new GrabAndLift());
	}
	
	public static SmartJoystick getDriveStick() {
		return dStick;
	}
}


