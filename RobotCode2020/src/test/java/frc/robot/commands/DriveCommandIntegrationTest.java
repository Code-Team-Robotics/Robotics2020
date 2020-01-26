package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SchedulerTestHelper;
import frc.robot.RobotJoystick;
import frc.robot.subsystems.DriveTrainSubsystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;

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

    @Test
    public void itDoesntMoveWithoutJoystick() throws InterruptedException, ExecutionException {
        VictorSPX mock_frontLeft = mock(VictorSPX.class);
        VictorSPX mock_frontRight = mock(VictorSPX.class);
        VictorSPX mock_backLeft = mock(VictorSPX.class);
        VictorSPX mock_backRight = mock(VictorSPX.class);
        RobotJoystick mock_joystick = mock(RobotJoystick.class);

        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem
                (mock_frontLeft, mock_frontRight,
                        mock_backLeft, mock_backRight, mock_joystick);
        System.out.println("Successfully created subsystem with mock dependencies");

        DriveCommand driveCommand = new DriveCommand(classUnderTest);

        schedulerTestHelper.run(driveCommand).forDuration(1);

        Mockito.verifyNoInteractions(mock_frontLeft, mock_frontRight, mock_backLeft, mock_backRight);
    }
}
