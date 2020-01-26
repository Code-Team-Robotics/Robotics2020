/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.I2C;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    // PORTS
    public final static int Port_0 = 0;
    public final static int Port_1 = 1;
    public final static int Port_2 = 2;
    public final static int Port_3 = 3;
    public final static int Port_4 = 4;

    // JOYSTICK IDS
    public final static int ID_0 = 0;
    public final static int ID_1 = 1;
    public final static int ID_2 = 2;
    public final static int ID_3 = 3;
    public final static int ID_4 = 4;

    // I2C Ports
    public final static I2C.Port i2cPort = I2C.Port.kOnboard;


    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
