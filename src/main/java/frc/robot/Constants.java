/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int LEFT_1 = 0;
    public static final int LEFT_2 = 1;
    public static final int RIGHT_1 = 2;
    public static final int RIGHT_2 = 3;

    public static final int INTAKE_LEFT = 4;
    public static final int INTAKE_RIGHT = 5;
    public static final int INTAKE_IN_BUTTON = 7;
    public static final int INTAKE_OUT_BUTTON = 8;
    public static final double INTAKE_IN_SPEED = 0.5;
    public static final double INTAKE_OUT_SPEED = -0.8;

    public static final int HATCH_BUTTON = 9;
    public static final int HATCH_SOLENOID = 10;
    public static final boolean HATCH_DIRECTION = true;

    public static final int ARM_POTENT = 11;
    public static final int ARM_UP = 12;
    public static final int ARM_DOWN = 13;
    public static final int ARM_CONTROL = 14;
    public static final double ARM_TOP = 69;
    public static final double ARM_BOTTOM = 109.5;
    public static final double ARM_SPEED = 0.5;
    
    public static final double WRIST_TOP = 5.5;
    public static final double WRIST_BOTTOM = 56.4;
    public static final int WRIST_POTENT = 15;
    public static final int WRIST_CONTROL = 16;
    public static final int WRIST_UP = 17;
    public static final int WRIST_DOWN = 18;
    public static final double WRIST_SPEED = 0.5;

}
