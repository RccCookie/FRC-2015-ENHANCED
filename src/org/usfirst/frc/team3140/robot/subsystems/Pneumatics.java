package org.usfirst.frc.team3140.robot.subsystems;

import org.usfirst.frc.team3140.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem implements RobotMap {
    
	private static Pneumatics instance;
	private DoubleSolenoid top;
	private Compressor comp;
	
	/**
	 * Constructor for Pneumatics.
	 * Sets the Compressor/DoubleSolenoid are assigned ports and
	 * initialized.
	 */
	private Pneumatics() {
		comp = new Compressor();
		comp.start();
		top = new DoubleSolenoid(kTopGrabberA, kTopGrabberB);
		//bottom = new DoubleSolenoid(kBottomGrabberA, kBottomGrabberB);
	}
	
	/**
	 * Singleton for Pneumatics constructor.
	 * Prevents the constructor from running more than once.
	 * If the constructor runs more than once, then ports are assigned
	 * that already have a spot, which results in an error upon building.
	 * @return instance
	 */
	public static Pneumatics getInstance() {
		if(instance == null) {
			instance = new Pneumatics();
		}
		return instance;
	}

    public void initDefaultCommand() {
	        setDefaultCommand(null);
    }
    
    /******************************************************************
     * The following methods are used in commands
     * Solenoids are either set to EXT or RET (extend or retract)
     * these values correspond to RobotMap variables
     ******************************************************************/
    public void ToggleOpen() {
    	top.set(EXT);
    }
    
    public void ToggleClose() {
    	top.set(RET);
    }
}

