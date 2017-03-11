// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5933.Caroline;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5933.Caroline.commands.*;
import org.usfirst.frc5933.Caroline.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	private Command teleopCommand;
	private Command autonomousCommand;

	public static OI oi;

	public static boolean show_debug_flywheel = true;
	public static boolean show_debug_vision = true;

	private static SocketVision vision_boiler_;
	private static SocketVision vision_peg_;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static GearCollectionSystem gearCollectionSystem;
    public static ClimbingSystem climbingSystem;
    public static FlyWheelSystem flyWheelSystem;
    public static HopperSystem hopperSystem;
    public static DriveTrainSystem driveTrainSystem;
    public static PowerSystem powerSystem;
    public static RoboRioSystem roboRioSystem;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public Robot() {
		super();
	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        gearCollectionSystem = new GearCollectionSystem();
        climbingSystem = new ClimbingSystem();
        flyWheelSystem = new FlyWheelSystem();
        hopperSystem = new HopperSystem();
        driveTrainSystem = new DriveTrainSystem();
        powerSystem = new PowerSystem();
        roboRioSystem = new RoboRioSystem();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new DefaultAutonomousCommand();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		teleopCommand = new DefaultTeleopCommand();

		gearCollectionSystem.robotInit();
		climbingSystem.robotInit();
		flyWheelSystem.robotInit();
		hopperSystem.robotInit();
		driveTrainSystem.robotInit();
		roboRioSystem.robotInit();

		configAutonomousCommand();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

		if (vision_boiler_ != null) {
			try {
				vision_boiler_.stoprunning();
				vision_boiler_.join();
				vision_boiler_ = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (vision_peg_ != null) {
			try {
				vision_peg_.stoprunning();
				vision_peg_.join();
				vision_peg_ = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	private void visionInit() {
		if (vision_boiler_ == null) {
			vision_boiler_ = new SocketVision("10.59.33.255", 5800);
			if (show_debug_vision) {
				System.out.println("Vision to Boiler started.");
			}
			vision_boiler_.start();

			if (!vision_boiler_.is_connected()) {
				if (!vision_boiler_.connect()) {
					if (show_debug_vision) {
						System.err.println("Failed to connect to the Helmsman and I really need my boiled mayonnaise");
					}
				} else {
					if (show_debug_vision) {
						System.out.println("Connected. Love me some boiled mayo.");
					}
				}
			}
		}

		if (vision_peg_ == null) {
			vision_peg_ = new SocketVision("10.59.33.255", 5801);
			if (show_debug_vision) {
				System.out.println("Vision to Peg started.");
			}
			vision_peg_.start();

			if (!vision_peg_.is_connected()) {
				if (!vision_peg_.connect()) {
					if (show_debug_vision) {
						System.err.println("Failed to connect to the Helmsman and I really need my mayonnaise");
					}
				} else {
					if (show_debug_vision) {
						System.out.println("Connected. Love that mayo.");
					}
				}
			}
		}
	}

	public void autonomousInit() {
		gearCollectionSystem.autonomousInit();
		climbingSystem.autonomousInit();
		flyWheelSystem.autonomousInit();
		hopperSystem.autonomousInit();
		driveTrainSystem.autonomousInit();
		powerSystem.autonomousInit();
		roboRioSystem.autonomousInit();

		// schedule the autonomous command (example)
		configAutonomousCommand();
		if (autonomousCommand != null)
			autonomousCommand.start();

		if (teleopCommand != null)
			teleopCommand.cancel();

		visionInit();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		gearCollectionSystem.autonomousPeriodic();
		climbingSystem.autonomousPeriodic();
		flyWheelSystem.autonomousPeriodic();
		hopperSystem.autonomousPeriodic();
		driveTrainSystem.autonomousPeriodic();
		powerSystem.autonomousPeriodic();
		roboRioSystem.autonomousPeriodic();

		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		gearCollectionSystem.teleopInit();
		climbingSystem.teleopInit();
		flyWheelSystem.teleopInit();
		hopperSystem.teleopInit();
		driveTrainSystem.teleopInit();
		powerSystem.teleopInit();
		roboRioSystem.teleopInit();

		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

		if (teleopCommand != null) {
			teleopCommand.start();
		}

		visionInit();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		gearCollectionSystem.teleopPeriodic();
		climbingSystem.teleopPeriodic();
		flyWheelSystem.teleopPeriodic();
		hopperSystem.teleopPeriodic();
		driveTrainSystem.teleopPeriodic();
		powerSystem.teleopPeriodic();
		roboRioSystem.teleopPeriodic();

		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

	private void configAutonomousCommand() {
		switch (roboRioSystem.getDIP() - 112) {	//the -112 is for the busted switches. All binary is reversed here.
		case 0:		//0000000
			autonomousCommand = new RedAttackGearPosition1();
			break;
		case 1:		//0000001
			autonomousCommand = new RedAttackGearPosition2();
			break;
		case 2:		//0000010
			autonomousCommand = new RedAttackGearPosition3();
			break;
		case 3:		//0000011
			autonomousCommand = new BlueAttackGearPosition1();
			break;
		case 4:		//0000100
			autonomousCommand = new BlueAttackGearPosition2();
			break;
		case 5:		//0000101
			autonomousCommand = new BlueAttackGearPosition3();
			break;
		case 6:		//0000110
			autonomousCommand = new SimpleDriveStraight();
			break;
		default:	//1111111
			autonomousCommand = new NullCommand();
			break;
		}
		//autonomousCommand = new SimpleDriveStraight();
		SmartDashboard.putString("Autonomous Command is: ", autonomousCommand.getName());
		SmartDashboard.putNumber("Auto Run Case: ", roboRioSystem.getDIP() - 112);
	}

	public static String get_boiler_direction() {
		return vision_boiler_.get_direction();
	}

	public static double get_boiler_degress_x() {
		return vision_boiler_.get_degrees_x();
	}

	public static double get_peg_distance_height() {
		return vision_peg_.get_distance_height();
	}

	public static double get_peg_degrees_x() {
		return vision_peg_.get_degrees_x();

	}

	public static String get_peg_direction() {
		return vision_peg_.get_direction();
	}

	public static boolean peg_vision_working() {
		return vision_peg_.is_connected();
	}

	public static double get_boiler_distance_height() {
		return vision_boiler_.get_distance_height();
	}
}
