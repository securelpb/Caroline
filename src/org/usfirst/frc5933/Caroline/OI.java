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

import org.usfirst.frc5933.Caroline.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton rBumper;
    public JoystickButton xButton;
    public JoystickButton aButton;
    public JoystickButton yButton;
    public JoystickButton bButton;
    public JoystickButton backButton;
    public JoystickButton lBumper;
    public JoystickButton rToggle;
    public JoystickButton lToggle;
    public JoystickButton startButton;
    public Joystick driverJoystick;
    public JoystickButton xButtonSub;
    public JoystickButton aButtonSub;
    public JoystickButton bButtonSub;
    public JoystickButton yButtonSub;
    public JoystickButton rBumperSub;
    public JoystickButton lBumperSub;
    public JoystickButton rToggleSub;
    public JoystickButton lToggleSub;
    public JoystickButton backButtonSub;
    public JoystickButton startButtonSub;
    public Joystick subsystemJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        subsystemJoystick = new Joystick(1);
        
        startButtonSub = new JoystickButton(subsystemJoystick, 8);
        startButtonSub.whenPressed(new ToggleClimber());
        backButtonSub = new JoystickButton(subsystemJoystick, 7);
        backButtonSub.whenPressed(new ToggleClaw());
        lToggleSub = new JoystickButton(subsystemJoystick, 9);
        lToggleSub.whenPressed(new FlyFaster());
        rToggleSub = new JoystickButton(subsystemJoystick, 10);
        rToggleSub.whenPressed(new FlySlower());
        lBumperSub = new JoystickButton(subsystemJoystick, 5);
        lBumperSub.whenPressed(new ToggleHopper());
        rBumperSub = new JoystickButton(subsystemJoystick, 6);
        rBumperSub.whenPressed(new ToggleFlywheel());
        yButtonSub = new JoystickButton(subsystemJoystick, 4);
        yButtonSub.whenPressed(new ToggleShootingVision());
        bButtonSub = new JoystickButton(subsystemJoystick, 2);
        bButtonSub.whenPressed(new AgitateSlower());
        aButtonSub = new JoystickButton(subsystemJoystick, 1);
        aButtonSub.whenPressed(new AgitateFaster());
        xButtonSub = new JoystickButton(subsystemJoystick, 3);
        xButtonSub.whenPressed(new FlyWheelMode());
       
        driverJoystick = new Joystick(0);
        
        startButton = new JoystickButton(driverJoystick, 8);
        startButton.whileHeld(new StopFlaps());
        lToggle = new JoystickButton(driverJoystick, 9);
        lToggle.whenPressed(new DriveToPeg());
        rToggle = new JoystickButton(driverJoystick, 10);
        rToggle.whenPressed(new AlignToBoiler());
        lBumper = new JoystickButton(driverJoystick, 5);
        lBumper.whileHeld(new NullCommand());
        backButton = new JoystickButton(driverJoystick, 7);
        backButton.whenPressed(new NullCommand());
        bButton = new JoystickButton(driverJoystick, 2);
        bButton.whenPressed(new FrontFlapClose());
        yButton = new JoystickButton(driverJoystick, 4);
        yButton.whenPressed(new BackFlapClose());
        aButton = new JoystickButton(driverJoystick, 1);
        aButton.whenPressed(new FrontFlapOpen());
        xButton = new JoystickButton(driverJoystick, 3);
        xButton.whenPressed(new NullCommand());
        rBumper = new JoystickButton(driverJoystick, 6);
        rBumper.whileHeld(new NullCommand());


        // SmartDashboard Buttons
        SmartDashboard.putData("ComplexDriveStraight", new ComplexDriveStraight());
        SmartDashboard.putData("RedAttackGearPosition1", new RedAttackGearPosition1());
        SmartDashboard.putData("RedAttackGearPosition2", new RedAttackGearPosition2());
        SmartDashboard.putData("RedAttackGearPosition3", new RedAttackGearPosition3());
        SmartDashboard.putData("BlueAttackGearPosition1", new BlueAttackGearPosition1());
        SmartDashboard.putData("BlueAttackGearPosition2", new BlueAttackGearPosition2());
        SmartDashboard.putData("BlueAttackGearPosition3", new BlueAttackGearPosition3());
        SmartDashboard.putData("SimpleDriveStraight", new SimpleDriveStraight());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriverJoystick() {
        return driverJoystick;
    }

    public Joystick getSubsystemJoystick() {
        return subsystemJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
