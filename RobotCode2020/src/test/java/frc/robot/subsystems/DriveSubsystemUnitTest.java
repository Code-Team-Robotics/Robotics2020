package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
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
        // Assemble
        Victor mock_frontLeft = mock(Victor.class);
        Victor mock_frontRight = mock(Victor.class);
        Victor mock_backLeft = mock(Victor.class);
        Victor mock_backRight = mock(Victor.class);
        Joystick mock_joystick = mock(Joystick.class);

        // Act
        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem
                (mock_frontLeft, mock_frontRight, mock_backLeft, mock_backRight, mock_joystick);

        // Assert
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
//    @Test
//    public void itShouldDriveForward() {
//        // Assemble
//        Victor mock_frontLeft = mock(Victor.class);
//        Victor mock_frontRight = mock(Victor.class);
//        Victor mock_backLeft = mock(Victor.class);
//        Victor mock_backRight = mock(Victor.class);
//        Joystick mock_joystick = mock(Joystick.class);
//        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem
//                (mock_frontLeft, mock_frontRight, mock_backLeft, mock_backRight, mock_joystick);
//
//        // Act
//        classUnderTest.Motor();
//
//        // Assert
//        Mockito.verify
//    }
}
