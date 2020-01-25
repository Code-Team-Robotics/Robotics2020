package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandHelper;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DriveTrainSubsystem;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class DriveCommandUnitTest {
    private CommandScheduler commandScheduler;

    @Test
    public void itRegistersTheCorrectSubsystems() {
        // Assemble
        DriveTrainSubsystem mockDriveTrainSubsystem = mock(DriveTrainSubsystem.class);

        // Act
        DriveCommand classUnderTest = new DriveCommand(mockDriveTrainSubsystem);

        // Assert
        Assert.assertTrue(CommandHelper.doesRequire(classUnderTest, mockDriveTrainSubsystem));
    }
}
