// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalSource;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //DriveTrain
	public static final int LEFT_1 = 1;
	public static final int LEFT_2 = 1;
	public static final int RIGHT_1 = 1;
    public static final int RIGHT_2 = 1;
    
    //Elevator
	public static final int E_LEFT = 1;
	public static final int E_RIGHT = 1;
	public static final int R_LIMIT = 1;
	public static final int L_LIMIT = 1;
	public static final DigitalSource L_ENCODER1 = null;
	public static final DigitalSource L_ENCODER2 = null;
	public static final DigitalSource R_ENCODER2 = null;
	public static final DigitalSource R_ENCODER1 = null;
	public static final int ELEVATOR_UP = 1;
	public static final double ELEVATOR_SPEED = 1;
	public static final int ELEVATOR_DOWN = 1;
    public static double RENCODER_LIMIT = 1;
    public static double LENCODER_LIMIT = 1;

    //Shooter
	public static final int SHOOTER_LEFT = 1;
	public static final int SHOOTER_RIGHT = 1;
	public static final int SHOOTER_BUTTON = 1;
	public static double SHOOTER_SPEED = 1;

    //Intake
    public static final int INTAKE_IN_BUTTON = 1;
	public static final double INTAKE_IN_SPEED = 1;
	public static final int INTAKE_SPEED = 1;

    //Transport
	public static final int TRANSPORT_SPEED = 1;
	public static final int TRANSPORT_BUTTON = 1;

    //Pulley
	public static final int PULLEY_SPEED = 1;
	public static final int PULLEY_BUTTON = 1;
}
