package org.usfirst.frc.team3140.robot.subsystems;

import org.usfirst.frc.team3140.robot.OI;
import org.usfirst.frc.team3140.robot.RobotMap;
import org.usfirst.frc.team3140.robot.commands.Lifter;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchLifter extends Subsystem implements RobotMap {
    
	public static WinchLifter instance;
	protected Talon lift;
	private final PowerDistributionPanel pdp;
	private double lT;
	private Timer timer;
	
	private WinchLifter() {
		pdp = new PowerDistributionPanel();
		lift = new Talon(kWinchMotorPWM);
	}
	
	public static WinchLifter getInstance() {
		if (instance == null) {
			instance = new WinchLifter();
		}
		return instance;
	}
	
	public void winchLifter() {
		if(OI.getDriveStick().getSmartPOV() == 360) {
			lT = 1.0;
		}else if(OI.getDriveStick().getSmartPOV() == 180) {
			lT = -1.0;
		}else{
			lT = 0.0;
		}
		
		lift.set(lT);
	}
	
	public void autoWinchLifter(double speed) {
		lift.set(speed);
		
		
	}
	
	public void startTime(){
    	System.out.println("timer started");
    	timer.start();
    	timer.reset();
    }
    
    public boolean waitForComplete(double milli){
    	System.out.println("time currently: " + timer.get() + " - waiting for: " + milli);
    	if(timer.get() <= milli)
    		return false;
    	else{
    		return true;
    	}
    }

    public void initDefaultCommand() {
    	setDefaultCommand(null);
    }
}

