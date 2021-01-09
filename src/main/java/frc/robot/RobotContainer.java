/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private SpeedController left1, left2, right1, right2;
  private SpeedControllerGroup left, right;
  private DifferentialDrive drive;
  private static DriveTrain driveTrain;

  private Joystick joystick;

  private SpeedController intakeLeft, intakeRight;
  private Intake intake;
  private Button intakeIn, intakeOut;

  private HatchIntake hatch;
  private Solenoid hatchSolenoid;
  private Button hatchButton;

  private AnalogPotentiometer armPotent;
  private SpeedController armController;
  private Arm arm;
  private Button armUp, armDown;

  private AnalogPotentiometer wristPotent;
  private SpeedController wristController;
  private Wrist wrist;
  private Button wristUp, wristDown;


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    left1 = new SteelTalonsController(Constants.LEFT_1, false, 1);
    left2 = new SteelTalonsController(Constants.LEFT_2, false, 1);
    right1 = new SteelTalonsController(Constants.RIGHT_1, false, 1);
    right2 = new SteelTalonsController(Constants.RIGHT_2, false, 1);

    left = new SpeedControllerGroup(left1, left2);
    right = new SpeedControllerGroup(right1, right2);

    drive = new DifferentialDrive(left, right);
    driveTrain = new DriveTrain(left, right, drive);
    driveTrain.setDefaultCommand(new DriveWithJoystick());

    intakeLeft = new SteelTalonsController(Constants.INTAKE_LEFT, false, 1);
    intakeRight = new SteelTalonsController(Constants.INTAKE_RIGHT, false, 1);
    intake = new Intake(intakeLeft, intakeRight);

    armPotent = new AnalogPotentiometer(Constants.ARM_POTENT);
    armController = new SteelTalonsController(Constants.ARM_CONTROL, false, 1);
    arm = new Arm(armController, armPotent);

    hatchSolenoid = new Solenoid(Constants.HATCH_SOLENOID);
    hatch = new HatchIntake(Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.INTAKE_IN_BUTTON), hatchSolenoid);

    wristPotent = new AnalogPotentiometer(Constants.WRIST_POTENT);
    wristController = new SteelTalonsController(Constants.WRIST_CONTROL, false, 1);
    wrist = new Wrist(wristController, wristPotent);

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    joystick = new Joystick(0);
    intakeIn = new JoystickButton(joystick, Constants.INTAKE_IN_BUTTON);
    intakeOut = new JoystickButton(joystick, Constants.INTAKE_OUT_BUTTON);

    intakeIn.whileHeld(new MoveIntake(Constants.INTAKE_IN_SPEED));
    intakeOut.whileHeld(new MoveIntake(Constants.INTAKE_OUT_SPEED));

    hatchButton = new JoystickButton(joystick, Constants.HATCH_BUTTON);
    hatchButton.whileHeld(new Pneumatics(Constants.HATCH_DIRECTION));

    armUp = new JoystickButton(joystick, Constants.ARM_UP);
    armDown = new JoystickButton(joystick, Constants.ARM_DOWN);

    armUp.whileHeld(new MoveArm(Constants.ARM_SPEED));
    armDown.whileHeld(new MoveArm(-Constants.ARM_SPEED));

    wristUp = new JoystickButton(joystick, Constants.WRIST_UP);
    wristDown = new JoystickButton(joystick, Constants.WRIST_DOWN);
    wristUp.whileHeld(new MoveArm(Constants.WRIST_SPEED));
    wristDown.whileHeld(new MoveArm(-Constants.WRIST_SPEED));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public DriveTrain getDriveTrain(){
    return driveTrain;
  }

  public Joystick getJoystick(){
    return joystick;
  }

  public Intake getIntake(){
    return intake;
  }

  public HatchIntake getHatch(){
    return hatch;
  }

  public Wrist getWrist(){
    return wrist;
  }

  public Arm getArm(){
    return arm;
  }
}
