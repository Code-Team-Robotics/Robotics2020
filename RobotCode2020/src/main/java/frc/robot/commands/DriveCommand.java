package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.DriveTrainSubsystem;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BooleanSupplier;

public class DriveCommand implements Command {
    private final DriveTrainSubsystem driveTrainSubsystem;

    public DriveCommand(DriveTrainSubsystem driveTrainSubsystem) {
        this.driveTrainSubsystem = driveTrainSubsystem;
    }

    // Called to determine a list of dependencies that must be passed into this Subsystem to correctly work
    @Override
    public Set<Subsystem> getRequirements() {
        Set<Subsystem> subsystems = new HashSet<>();
        subsystems.add((Subsystem) this.driveTrainSubsystem);
        return subsystems;
    }


    // Called once before the Command is executed
    // Reset any counters here
    @Override
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run:  driveTrainSubsystem.setVictorToMax();
    // driveTrainSubsystem.Motor();
    @Override
    public void execute() {
        driveTrainSubsystem.DriveForward();
    }

    // This returns a boolean that will stop the command from executing
    @Override
    public boolean isFinished(){
        System.out.println("Command is finished");
        return false;
    }

    // Called once isFinished returns 'true':  driveTrainSubsystem.setVictorToZero();
    @Override
    public void end(boolean interrupted) {
        driveTrainSubsystem.StopDriving();
    }

    // Called when another command which requires one
    // or more of the same subsystems is scheduled to run

    // Usually just end the command here, although it is
    // a case by case scenario
    @Override
    public ParallelRaceGroup withInterrupt(BooleanSupplier condition) {
        return null;
    }
}

