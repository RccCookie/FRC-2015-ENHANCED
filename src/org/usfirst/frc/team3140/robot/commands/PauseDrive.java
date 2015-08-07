package org.usfirst.frc.team3140.robot.commands;

import org.usfirst.frc.team3140.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PauseDrive extends Command {

	double time;
	
    public PauseDrive(double milli) {
    	requires(Robot.dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dt.startTime();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.dt.waitForComplete(time);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
