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

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearCollectionSystem extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController frontFlapperMotor = RobotMap.gearCollectionSystemFrontFlapperMotor;
    private final SpeedController backFlapperMotor = RobotMap.gearCollectionSystemBackFlapperMotor;
    private final DigitalInput closeBackFlapperLimitSwitch = RobotMap.gearCollectionSystemCloseBackFlapperLimitSwitch;
    private final DigitalInput closeFrontFlapperLimitSwitch = RobotMap.gearCollectionSystemCloseFrontFlapperLimitSwitch;
    private final DigitalInput openBackFlapperLimitSwitch = RobotMap.gearCollectionSystemOpenBackFlapperLimitSwitch;
    private final DigitalInput openFrontFlapperLimitSwitch = RobotMap.gearCollectionSystemOpenFrontFlapperLimitSwitch;

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

    public void openFrontFlapper() {
        frontFlapperMotor.set(1);
    }

    public void closeFrontFlapper() {
        frontFlapperMotor.set(-1);
    }

    public void openBackFlapper() {
        backFlapperMotor.set(1);
    }

    public void closeBackFlapper() {
        backFlapperMotor.set(-1);
    }

    public void stop() {
        frontFlapperMotor.stopMotor();
        backFlapperMotor.stopMotor();
    }
    public void teleopPeriodic() {
        
    }

    public void autonomousPeriodic() {
        
    }
}
