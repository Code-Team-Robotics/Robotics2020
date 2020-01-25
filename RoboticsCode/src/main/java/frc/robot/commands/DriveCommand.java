package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.DriveTrainSubsystem;

import java.util.HashSet;
import java.util.Set;

public class DriveCommand implements Command {
    private final DriveTrainSubsystem driveTrainSubsystem;


    public DriveCommand(DriveTrainSubsystem driveTrainSubsystem) {
        this.driveTrainSubsystem = driveTrainSubsystem;
    }

    @Override
    public Set<Subsystem> getRequirements() {
        Set<Subsystem> subsystems = new HashSet<>();
        subsystems.add((Subsystem) this.driveTrainSubsystem);
        return subsystems;
    }

    @Override
    public void initialize() {
        // Called once before the Command is executed
        // Reset any counters here
    }

    @Override
    public void execute() {
        // Called repeatedly when this Command is scheduled to run:  driveTrainSubsystem.setVictorToMax();
        driveTrainSubsystem.Motor();
    }

    @Override
    public boolean isFinished(){
        System.out.println("Command is finished");
        return false;
    }

    protected void end() {
        // Called once isFinished returns 'true':  driveTrainSubsystem.setVictorToZero();
        driveTrainSubsystem.StopDriving();
    }

    protected void interrupted() {
        // Called when another command which requires one
        // or more of the same subsystems is scheduled to run

        // Usually just end the command here, although it is
        // a case by case scenario

        end();
    }
}

