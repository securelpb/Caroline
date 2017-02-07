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


// TODO: Do we want a driving camera ??
// TODO: Turn degrees ?
// TODO: Use the gyro ?
// TODO: Use the accelerometer ?
// TODO: Maintain the fly wheel rpm.
// TODO: Use encoders from the new gear boxes.
// TODO: Use the servos on the near gear boxes to switch speeds.
// TODO: Add shuttering to drive train.
// TODO: Add a TurnDegrees command.
// TODO: Add sequential and parallel commands to autonomous commands.
// TODO: Add field elements contants so that we can use them in calculations.
// TODO: Add a lookup table (if neccesary) that allows us to map drive train encoder values to actual feet/inches.
// TODO: Do we need to take image recognition values and map to inches ?
// TODO: Add a drive to peg command.
// TODO: Change UDP from broadcast to unicast.
// TODO: Makes sure prefs work in dumb dashboard.
// TOOD: Lookup code on CTRE git hub site as an example of how to do MagEncoders.
// TODO: Makes sure that limit switches work on Flappers.

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc5933.Caroline.commands.*;
import org.usfirst.frc5933.Caroline.subsystems.*;
import org.usfirst.frc5933.Caroline.commands.DefaultAutonomousCommand;
import org.usfirst.frc5933.Caroline.commands.DefaultTeleopCommand;

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
    public static boolean is_sonny = false;
    public static boolean show_debug_flywheel = false;
    public static boolean show_debug_vision = false;

    private SocketVision vision_;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static GearCollectionSystem gearCollectionSystem;
    public static ClimbingSystem climbingSystem;
    public static FlyWheelSystem flyWheelSystem;
    public static BallCollectionSystem ballCollectionSystem;
    public static HopperSystem hopperSystem;
    public static DriveTrainSystem driveTrainSystem;
    public static PowerSystem powerSystem;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Robot() {
        super();
        vision_ = new SocketVision("10.59.33.25", 59330);
        if (show_debug_vision) {
            System.out.println("Vision Started");
        }
        vision_.start();
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
        ballCollectionSystem = new BallCollectionSystem();
        hopperSystem = new HopperSystem();
        driveTrainSystem = new DriveTrainSystem();
        powerSystem = new PowerSystem();

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
        ballCollectionSystem.robotInit();
        hopperSystem.robotInit();
        driveTrainSystem.robotInit();

        if (vision_ != null) {
            if (!vision_.is_connected()) {
                if (!vision_.connect()) {
                    if (show_debug_vision) {
                        System.err.println("Failed to connect to the Helmsman and I really need my mayonnaise");
                    }
                } else {
                    if (show_debug_vision) {
                        System.out.println("Connected. No mayo for me.");
                    }
                }
            }
        }

        configAutonomousCommand();
    }

    /**
     * This function is called when the disabled button is hit. You can use it
     * to reset subsystems before shutting down.
     */
    public void disabledInit() {
        if (vision_ != null) {
            try {
                vision_.stoprunning();
                vision_.join();
                vision_ = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        gearCollectionSystem.autonomousInit();
        climbingSystem.autonomousInit();
        flyWheelSystem.autonomousInit();
        ballCollectionSystem.autonomousInit();
        hopperSystem.autonomousInit();
        driveTrainSystem.autonomousInit();
        powerSystem.autonomousInit();
        
        // schedule the autonomous command (example)
        if (autonomousCommand != null)
            autonomousCommand.start();

        if (teleopCommand != null)
            teleopCommand.cancel();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        gearCollectionSystem.autonomousPeriodic();
        climbingSystem.autonomousPeriodic();
        flyWheelSystem.autonomousPeriodic();
        ballCollectionSystem.autonomousPeriodic();
        hopperSystem.autonomousPeriodic();
        driveTrainSystem.autonomousPeriodic();
        powerSystem.autonomousPeriodic();
        
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        gearCollectionSystem.teleopInit();
        climbingSystem.teleopInit();
        flyWheelSystem.teleopInit();
        ballCollectionSystem.teleopInit();
        hopperSystem.teleopInit();
        driveTrainSystem.teleopInit();
        powerSystem.teleopInit();
        
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
            autonomousCommand.cancel();

        if (teleopCommand != null) {
            teleopCommand.start();
        }
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        gearCollectionSystem.teleopPeriodic();
        climbingSystem.teleopPeriodic();
        flyWheelSystem.teleopPeriodic();
        ballCollectionSystem.teleopPeriodic();
        hopperSystem.teleopPeriodic();
        driveTrainSystem.teleopPeriodic();
        powerSystem.teleopPeriodic();
        
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    private void configAutonomousCommand() {
        Preferences prefs = Preferences.getInstance();
        if (!prefs.containsKey(PreferenceConstants.AUTONOMOUS_COMMAND_KEY)) {
            return;
        }
        switch (prefs.getString(PreferenceConstants.AUTONOMOUS_COMMAND_KEY, PreferenceConstants.BACKUP_VALUE)) {
        case PreferenceConstants.AUTONOMOUS_COMMAND_ATTACK_GEAR_POSTION_1:
            autonomousCommand = new AttackGearPosition1();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_ATTACK_GEAR_POSTION_2:
            autonomousCommand = new AttackGearPosition2();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_ATTACK_GEAR_POSTION_3:
            autonomousCommand = new AttackGearPosition3();
            break;
        }
        System.out.println("Autonomous Command is: "+autonomousCommand.getName());
        // TODO: Create other prefs
    }
}
