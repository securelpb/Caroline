// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5933.Caroline.commands;

import org.usfirst.frc5933.Caroline.OI;
import org.usfirst.frc5933.Caroline.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DefaultTeleopCommand extends Command {
	static boolean tapped = false;
	static boolean tapped2 = false;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public DefaultTeleopCommand() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.driveTrainSystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() { // do we want to cut this based off of
								// is_shifting?
		Robot.driveTrainSystem.arcadeDrive(Robot.oi.driverJoystick);
		distinguishPOV(Robot.oi.driverJoystick.getPOV(), Robot.oi.subsystemJoystick.getPOV()); // Shudder
																								// conga!!
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

	public void distinguishPOV(int POV, int POV2) { // step one in the shudder
													// chain
		if (tapped2) { // Stay away from a constant movement
			if (POV2 == -1) {
				tapped2 = false; // allow the next shudder to happen
				// Robot.driveTrainSystem.stop();
			}
		} else {
			tapped2 = true; // Stop the shudder chain next time around

			if (POV2 == 0) { // up
				Robot.driveTrainSystem.incrementShudder();
			}

			if (POV2 == 90) { // right
				Robot.driveTrainSystem.shudder_right();
			}

			if (POV2 == 180) { // down
				Robot.driveTrainSystem.decrementShudder();
			}

			if (POV2 == 270) { // left
				Robot.driveTrainSystem.shudder_left();
			}

			if (POV2 == -1) { // not pressed
				tapped2 = false;
			}
		}

		if (tapped) { // Stay away from a constant movement
			if (POV == -1) {
				tapped = false; // allow the next shudder to happen
				Robot.driveTrainSystem.stop();
			}
		} else {
			tapped = true; // Stop the shudder chain next time around

			if (POV == 0) { // up
				Robot.driveTrainSystem.incrementShudder();
			}

			if (POV == 90) { // right
				Robot.driveTrainSystem.shudder_right();
			}

			if (POV == 180) { // down
				Robot.driveTrainSystem.decrementShudder();
			}

			if (POV == 270) { // left
				Robot.driveTrainSystem.shudder_left();
			}

			if (POV == -1) { // not pressed
				tapped = false;
			}
		}
	}
}
