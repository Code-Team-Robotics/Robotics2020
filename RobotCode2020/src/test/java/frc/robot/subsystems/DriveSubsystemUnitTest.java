package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.RobotJoystick;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;

/*
    This UnitTest ensures that all of our subsystems methods return values that they should,
    or run according to what the developer had in mind.
*/
public class DriveSubsystemUnitTest {

    /*
        Ensures that the DriveTrainSubsystem
        can be instantiated given all of its required dependencies.
    */
    @Test(expected = Test.None.class)
    public void itShouldInstantiateGivenDependencies() {
        VictorSPX mock_frontLeft = mock(VictorSPX.class);
        VictorSPX mock_frontRight = mock(VictorSPX.class);
        VictorSPX mock_backLeft = mock(VictorSPX.class);
        VictorSPX mock_backRight = mock(VictorSPX.class);
        RobotJoystick mock_joystick = mock(RobotJoystick.class);

        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem
                (mock_frontLeft, mock_frontRight, mock_backLeft, mock_backRight, mock_joystick);
    }

    /*
        Ensures that the Subsystem is not instantiated with a null.
        We check for an IllegalArgumentException case, which means that
        when this test returns this exception or error, it will be doing
        what we want.
    */
    @Test(expected = IllegalArgumentException.class)
    public void itShouldNotInstantiateWithANull() {
        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem
                (null, null, null, null, null);
    }

    /*
        Ensures that the Subsystem is not instantiated with no dependencies.
        We check for an IllegalAccessError case, which means that
        when this test returns this exception or error, it will be doing
        what we want.
    */
    @Test(expected = IllegalAccessError.class)
    public void itShouldNotInstantiateWithNoDependencies() {
        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem();
    }

    /*
        This test verifies that the motor controllers are set to the correct values
        when the method is run
    */
    @Test
    public void itShouldDriveForward() {
        // Assemble
        VictorSPX mock_frontLeft = mock(VictorSPX.class);
        VictorSPX mock_frontRight = mock(VictorSPX.class);
        VictorSPX mock_backLeft = mock(VictorSPX.class);
        VictorSPX mock_backRight = mock(VictorSPX.class);
        RobotJoystick mock_joystick = mock(RobotJoystick.class);
        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem
                (mock_frontLeft, mock_frontRight, mock_backLeft, mock_backRight, mock_joystick);

        // Act
        classUnderTest.DriveForward();

        // Assert
        Mockito.verify(mock_frontLeft, atLeastOnce()).set(ControlMode.PercentOutput, 1);
        Mockito.verify(mock_backLeft, atLeastOnce()).set(ControlMode.PercentOutput, 1);
        Mockito.verify(mock_frontRight, atLeastOnce()).set(ControlMode.PercentOutput, -1);
        Mockito.verify(mock_backRight, atLeastOnce()).set(ControlMode.PercentOutput, -1);
    }
}
