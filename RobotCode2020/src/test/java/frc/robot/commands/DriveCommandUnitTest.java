package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandHelper;
import edu.wpi.first.wpilibj2.command.SchedulerTestHelper;
import frc.robot.subsystems.DriveTrainSubsystem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;

public class DriveCommandUnitTest {
    private SchedulerTestHelper schedulerTestHelper;

    @Before
    public void setUpSchedulerHelper() {
        schedulerTestHelper = new SchedulerTestHelper(20);
    }

    @After
    public void cleanUpSchedulerHelper() {
        schedulerTestHelper.destroy();
    }

    @Test
    public void itCanDriveForward() throws InterruptedException, ExecutionException {
        // Assemble
        DriveTrainSubsystem mockDriveTrainSubsystem = mock(DriveTrainSubsystem.class);
        DriveCommand classUnderTest = new DriveCommand(mockDriveTrainSubsystem);

        // Act
        schedulerTestHelper.run(classUnderTest).forDuration(1);

        // Assert
        Mockito.verify(mockDriveTrainSubsystem, atLeastOnce()).DriveForward();
    }

//    @Test
//    public void itTurnsOffMotorWhenStopping() throws InterruptedException, ExecutionException {
//        // Assemble
//        DriveTrainSubsystem mockDriveTrainSubsystem = mock(DriveTrainSubsystem.class);
//        DriveCommand classUnderTest = new DriveCommand(mockDriveTrainSubsystem);
//
//        // Act
//        schedulerTestHelper.run(classUnderTest).forDuration(3).get();
//
//        // Assert
//        verify(mockDriveTrainSubsystem, times(1)).StopDriving();
//    }

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
