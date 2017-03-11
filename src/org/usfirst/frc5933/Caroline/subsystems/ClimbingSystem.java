// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5933.Caroline.subsystems;

import org.usfirst.frc5933.Caroline.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimbingSystem extends Subsystem {

	private boolean running_ = false;

	// so a button press can move it between 4 states:
	// stopped, forward, stopped, backward and repeat that forever.
	private int claw_running_ = 1;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon climbingSpindleMotor = RobotMap.climbingSystemClimbingSpindleMotor;
    private final SpeedController cLimbingClawMotor = RobotMap.climbingSystemCLimbingClawMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void robotInit() {
	}

	public void teleopInit() {
		
	}

	public void autonomousInit() {
	}

	public void teleopPeriodic() {
		if (running_) {
			climbingSpindleMotor.set(-10000);
		} else {
			climbingSpindleMotor.set(0);
		}

		// tests for the 'case' of claw_running_
		if (claw_running_ == 1) {
			// case 1: go forward (close) at full
			cLimbingClawMotor.set(0.75);
		} else {
			// case 3: go backwards(open)
			cLimbingClawMotor.set(-0.75);
		}
	}

	public void autonomousPeriodic() {
	}

	public boolean isRunning() {
		return running_;
	}

	public void toggle() {
		running_ = !running_;
	}

	/*
	 * toggleClaw is called at a button press to toggle through the 4 states of
	 * what the claw motor will/can do. Hardware limit switches stop it so the
	 * code doesn't have to.
	 */
	public void toggleClaw() {
		claw_running_++;
		SmartDashboard.putNumber("Claw Motor Running Case ", claw_running_);

		if (claw_running_ > 1)
			claw_running_ = 0;
		
		SmartDashboard.putNumber("Climbing Motor Running Case ", claw_running_);
	}
}
