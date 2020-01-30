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

/*
    This CommandUnitTest runs the "execute" and "end" methods in our Command,
    and verifies that the correct methods have been called.

    (It does not verify WHEN they are called... this can be further implemented)
*/
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

    /*
        This test makes sure that the subsystem can be passed into the Command
        and that it runs the "execute" method within the Command.
    */
    @Test
    public void itCanRunExecuteMethod() throws InterruptedException, ExecutionException {
        // Assemble
        DriveTrainSubsystem mockDriveTrainSubsystem = mock(DriveTrainSubsystem.class);
        DriveCommand classUnderTest = new DriveCommand(mockDriveTrainSubsystem);

        // Act
        schedulerTestHelper.run(classUnderTest).forDuration(1).get();

        // Assert
        Mockito.verify(mockDriveTrainSubsystem, atLeastOnce()).DriveForward();
    }

    /*
        This test makes sure that the subsystem can be passed into the Command
        and that it runs the "end" method within the Command.
    */
    @Test
    public void itCanRunEndMethod() throws InterruptedException, ExecutionException {
        // Assemble
        DriveTrainSubsystem mockDriveTrainSubsystem = mock(DriveTrainSubsystem.class);
        DriveCommand classUnderTest = new DriveCommand(mockDriveTrainSubsystem);

        // Act
        schedulerTestHelper.run(classUnderTest).forDuration(1).get();

        // Assert
        verify(mockDriveTrainSubsystem, times(1)).StopDriving();
    }

    /*
        This test ensures that the DriveCommand requires the corresponding subsystems in order to run
    */
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
