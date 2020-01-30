package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotJoystick;

public class DriveTrainSubsystem implements Subsystem {
    // Only make the hardware components 'final'
    public final Victor victorSPX_frontLeft;
    public final Victor victorSPX_frontRight;
    public final Victor victorSPX_backLeft;
    public final Victor victorSPX_backRight;
    private MecanumDrive robotDrive;
    private Joystick joystick;


    // All other variables should not be final because they may
    // not have been initialized.

    public DriveTrainSubsystem(Victor frontLeft, Victor frontRight, Victor backLeft, Victor backRight, Joystick joystick) {
        if (frontLeft == null || frontRight == null || backLeft == null || backRight == null || joystick == null) {
            throw new IllegalArgumentException("Not all motor controllers are assigned! Please Declare them!");
        }
        this.victorSPX_frontLeft = frontLeft;
        this.victorSPX_frontLeft.setInverted(true);

        this.victorSPX_backLeft = backLeft;
        this.victorSPX_backLeft.setInverted(true);

        this.victorSPX_frontRight = frontRight;
        this.victorSPX_backRight = backRight;


        this.joystick = joystick;

        robotDrive = new MecanumDrive(victorSPX_frontLeft, victorSPX_backLeft, victorSPX_frontRight, victorSPX_backRight);
    }

    public DriveTrainSubsystem() {
        throw new IllegalAccessError("Only construct this subsystem with all its dependencies");
    }

    public void Motor() {
        robotDrive.driveCartesian(joystick.getX(), joystick.getY(), joystick.getZ());
    }

    public void Stop() {
        robotDrive.stopMotor();
    }


    @Override
    public void setDefaultCommand(Command defaultCommand) {
    }
}

