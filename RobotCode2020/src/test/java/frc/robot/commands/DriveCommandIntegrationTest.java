package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SchedulerTestHelper;
import frc.robot.RobotJoystick;
import frc.robot.subsystems.DriveTrainSubsystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

/*
    This integration test is to ensure that our subsystems "integrate" or can be called with our commands.
*/

public class DriveCommandIntegrationTest {

    private SchedulerTestHelper schedulerTestHelper;

    @Before
    public void setupSchedulerHelper() {
        schedulerTestHelper = new SchedulerTestHelper(20);
    }

    @After
    public void cleanUpSchedulerHelper() {
        schedulerTestHelper.destroy();
    }

    /*
        Ensures that no signals are sent to the motor-controllers without
        input from the Joystick
    */
    @Test
    public void itDoesntMoveWithoutJoystickInput() throws InterruptedException {
        // Assemble
        VictorSPX mock_frontLeft = mock(VictorSPX.class);
        VictorSPX mock_frontRight = mock(VictorSPX.class);
        VictorSPX mock_backLeft = mock(VictorSPX.class);
        VictorSPX mock_backRight = mock(VictorSPX.class);
        RobotJoystick mock_joystick = mock(RobotJoystick.class);

        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem
                (mock_frontLeft, mock_frontRight, mock_backLeft, mock_backRight, mock_joystick);
        DriveCommand driveCommand = new DriveCommand(classUnderTest);

        // Act
        schedulerTestHelper.run(driveCommand).forDuration(1);

        // Assert
        Mockito.verifyNoInteractions(mock_frontLeft, mock_frontRight, mock_backLeft, mock_backRight);
    }
}
