/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveTrainSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
    // Declare hardware
    public final VictorSPX victorSPX_frontLeft;
    public final VictorSPX victorSPX_frontRight;
    public final VictorSPX victorSPX_backLeft;
    public final VictorSPX victorSPX_backRight;

    public final ColorSensorV3 colorSensorV3;

    // Declare Operator Interface (Joysticks, Controllers)
    private final RobotJoystick joystick;
    private final JoystickButton button;

    // The robot's subsystems and commands are defined here...
    private final DriveTrainSubsystem driveTrainSubsystem;
    private final DriveCommand driveCommand;

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer()
    {
        super();
        this.victorSPX_frontLeft = new VictorSPX(RobotMap.ID_1);
        this.victorSPX_frontRight = new VictorSPX(RobotMap.ID_2);
        this.victorSPX_backLeft = new VictorSPX(RobotMap.ID_3);
        this.victorSPX_backRight = new VictorSPX(RobotMap.ID_4);

        this.colorSensorV3 = new ColorSensorV3(RobotMap.i2cPort);

        this.joystick = new RobotJoystick(RobotMap.Port_0);
        this.button = new JoystickButton(joystick, RobotMap.ID_1);

        this.driveTrainSubsystem = new DriveTrainSubsystem
                (victorSPX_frontLeft, victorSPX_frontRight,
                victorSPX_backLeft, victorSPX_backRight, joystick);

        this.driveCommand = new DriveCommand(driveTrainSubsystem);

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton JoystickButton}.
     */

    private void configureButtonBindings()
    {
        this.button.whileHeld(driveCommand);
    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // An ExampleCommand will run in autonomous
        return null;
    }
}
