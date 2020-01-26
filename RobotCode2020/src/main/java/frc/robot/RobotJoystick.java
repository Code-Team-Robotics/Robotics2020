package frc.robot;
import edu.wpi.first.wpilibj.Joystick;

import java.util.Arrays;

public class RobotJoystick extends Joystick {


    boolean[] buttonState;

    public RobotJoystick(int port) {
        super(port);
        buttonState = new boolean[12];

        Arrays.fill(buttonState, false);

    }

    public double deadZone(double input) {
        double dead = .30;
        if (input < dead && input > -dead)
            return 0;
        else
            return input;
    }


    public double getDX(){
        return deadZone(this.getRawAxis(0));
    }

    public double getDY(){
        return deadZone(this.getRawAxis(1));
    }

    public double getDZ(){
        return .7 * deadZone(this.getRawAxis(2));
    }
}