package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotJoystick;

public class DriveTrainSubsystem implements Subsystem {
    // Only make the hardware components 'final'
    public final VictorSPX victorSPX_frontLeft;
    public final VictorSPX victorSPX_frontRight;
    public final VictorSPX victorSPX_backLeft;
    public final VictorSPX victorSPX_backRight;
    public final RobotJoystick joystick;

    // All other variables should not be final because they may
    // not have been initialized.

    public DriveTrainSubsystem(VictorSPX frontLeft, VictorSPX frontRight, VictorSPX backLeft, VictorSPX backRight, RobotJoystick joystick) {
        if (frontLeft == null || frontRight == null || backLeft == null || backRight == null || joystick == null) {
            throw new IllegalArgumentException("Not all motor controllers are assigned! Please Declare them!");
        }
        this.victorSPX_frontLeft = frontLeft;
        this.victorSPX_backLeft = backLeft;

        this.victorSPX_frontRight = frontRight;
        this.victorSPX_backRight = backRight;

        this.joystick = joystick;
    }

    public DriveTrainSubsystem() {
        throw new IllegalAccessError("Only construct this subsystem with all its dependencies");
    }

    public void Motor() {
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, (joystick.getDY() + joystick.getDX() + joystick.getDZ()));
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, (-joystick.getDY() + joystick.getDX() + joystick.getDZ()));
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, (-joystick.getDY() - joystick.getDX() + joystick.getDZ()));
        this.victorSPX_backRight.set(ControlMode.PercentOutput, (joystick.getDY() -joystick.getDX() + joystick.getDZ()));
    }

    public void DriveForward() {
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, 1);
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, 1);
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, -1);
        this.victorSPX_backRight.set(ControlMode.PercentOutput, -1);
    }

    public void DriveBackward() {
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, -1);
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, -1);
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, 1);
        this.victorSPX_backRight.set(ControlMode.PercentOutput, 1);
    }

    public void StrafeRight() {
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, 1);
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, -1);
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, 1);
        this.victorSPX_backRight.set(ControlMode.PercentOutput, -1);
    }

    public void StrafeLeft() {
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, -1);
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, 1);
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, -1);
        this.victorSPX_backRight.set(ControlMode.PercentOutput, 1);
    }

    public void StrafeNorthEast() {
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, 1);
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, 0);
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, 0);
        this.victorSPX_backRight.set(ControlMode.PercentOutput, -1);
    }

    public void StrafeNorthWest() {
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, 0);
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, 1);
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, -1);
        this.victorSPX_backRight.set(ControlMode.PercentOutput, 0);
    }

    public void StrafeSouthEast() {
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, -1);
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, 0);
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, 0);
        this.victorSPX_backRight.set(ControlMode.PercentOutput, 1);
    }

    public void StrafeSouthWest() {
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, 0);
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, -1);
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, 1);
        this.victorSPX_backRight.set(ControlMode.PercentOutput, 0);
    }

    public void RotateClockwise() {
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, 1);
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, 1);
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, -1);
        this.victorSPX_backRight.set(ControlMode.PercentOutput, -1);
    }

    public void RotateCounterClockwise() {
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, -1);
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, -1);
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, 1);
        this.victorSPX_backRight.set(ControlMode.PercentOutput, 1);
    }

    public void StopDriving() {
        this.victorSPX_frontLeft.set(ControlMode.PercentOutput, 0);
        this.victorSPX_backLeft.set(ControlMode.PercentOutput, 0);
        this.victorSPX_frontRight.set(ControlMode.PercentOutput, 0);
        this.victorSPX_backRight.set(ControlMode.PercentOutput, 0);
    }


    @Override
    public void setDefaultCommand(Command defaultCommand) {
    }
}

