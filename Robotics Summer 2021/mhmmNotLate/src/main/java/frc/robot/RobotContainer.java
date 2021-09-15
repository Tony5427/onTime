/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.*;
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

  private SpeedController lSpeed1, lSpeed2, rSpeed1, rSpeed2;
  private SpeedControllerGroup lSpeedGroup, rSpeedGroup;
  private DifferentialDrive differ;
  private static DriveTrain driveTrain;

  private Joystick joystick;

  private SpeedController intakeSpeed;//Left, intakeRight;
  private Intake intake;
  private Button intakeIn;//, intakeOut;

  // private HatchIntake hatch;
  // private Solenoid hatchSolenoid;
  // private Button hatchButton;

  // private AnalogPotentiometer armPotent;
  // private SpeedController armController;
  // private Arm arm;
  // private Button armUp, armDown;

  // private AnalogPotentiometer wristPotent;
  // private SpeedController wristController;
  // private Wrist wrist;
  // private Button wristUp, wristDown;

  private Button pulleyButton;
  private SpeedController pulleySpeed;
  private static Pulley pulley;

  private Button shoot;
  private SpeedController shootLeft, shootRight;
  private static Shooter shooter;

  private SpeedController eLeft, eRight;
  private DigitalInput rLimitSwitch, lLimitSwitch;
  private Encoder lEncoder, rEncoder;
  private Button eUP, eDOWN;
  private static Elevator elevator;

  private SpeedController transportSpeed;
  private AnalogInput tInput;
  private Button transportButton;
  private static Transport transport;



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    lSpeed1 = new SteelTalonsController(Constants.LEFT_1, false, 1);
    lSpeed2 = new SteelTalonsController(Constants.LEFT_2, false, 1);
    rSpeed1 = new SteelTalonsController(Constants.RIGHT_1, false, 1);
    rSpeed2 = new SteelTalonsController(Constants.RIGHT_2, false, 1);

    lSpeedGroup = new SpeedControllerGroup(lSpeed1, lSpeed2);
    rSpeedGroup = new SpeedControllerGroup(rSpeed1, rSpeed2);

    differ = new DifferentialDrive(lSpeedGroup, rSpeedGroup);
    driveTrain = new DriveTrain(lSpeedGroup, rSpeedGroup, differ);
    driveTrain.setDefaultCommand(new DriveWithJoystick());

    intakeSpeed = new SteelTalonsController(Constants.INTAKE_SPEED, false, 1);
    intake = new Intake(intakeSpeed);

    transportSpeed = new SteelTalonsController(Constants.TRANSPORT_SPEED,false,1);
    transport = new Transport(transportSpeed);

    pulleySpeed = new SteelTalonsController(Constants.PULLEY_SPEED,false,1);
    pulley = new Pulley(pulleySpeed);

    shootLeft = new SteelTalonsController(Constants.SHOOTER_LEFT, false, 1);
    shootRight = new SteelTalonsController(Constants.SHOOTER_RIGHT, false, 1);
    shooter = new Shooter(shootLeft, shootRight);

    eLeft = new SteelTalonsController(Constants.E_LEFT, false, 1);
    eRight = new SteelTalonsController(Constants.E_RIGHT, false, 1);
    rLimitSwitch = new DigitalInput(Constants.R_LIMIT);
    lLimitSwitch = new DigitalInput(Constants.L_LIMIT);
    lEncoder = new Encoder(Constants.L_ENCODER1,Constants.L_ENCODER2);
    rEncoder = new Encoder(Constants.R_ENCODER1,Constants.R_ENCODER2);
    elevator = new Elevator(eLeft,eRight,rLimitSwitch,lLimitSwitch,rEncoder,lEncoder);

    // armPotent = new AnalogPotentiometer(Constants.ARM_POTENT);
    // armController = new SteelTalonsController(Constants.ARM_CONTROL, false, 1);
    // arm = new Arm(armController, armPotent);

    // hatchSolenoid = new Solenoid(Constants.HATCH_SOLENOID);
    // hatch = new HatchIntake(Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.INTAKE_IN_BUTTON), hatchSolenoid);

    // wristPotent = new AnalogPotentiometer(Constants.WRIST_POTENT);
    // wristController = new SteelTalonsController(Constants.WRIST_CONTROL, false, 1);
    // wrist = new Wrist(wristController, wristPotent);

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

    intakeIn.whileHeld(new MoveIntake(Constants.INTAKE_IN_SPEED));

    transportButton = new JoystickButton(joystick, Constants.TRANSPORT_BUTTON);

    transportButton.whileHeld(new MoveTransport(Constants.TRANSPORT_SPEED));

    pulleyButton = new JoystickButton(joystick, Constants.PULLEY_BUTTON);

    pulleyButton.whileHeld(new MovePulley(Constants.PULLEY_SPEED));

    shoot = new JoystickButton(joystick, Constants.SHOOTER_BUTTON);
    shoot.whileHeld(new MoveShooter(Constants.SHOOTER_SPEED, Constants.SHOOTER_SPEED));

    eUP = new JoystickButton(joystick, Constants.ELEVATOR_UP);
    eUP.whileHeld(new MoveElevator(Constants.ELEVATOR_SPEED, Constants.ELEVATOR_SPEED));
    eDOWN = new JoystickButton(joystick, Constants.ELEVATOR_DOWN);
    eDOWN.whileHeld(new MoveElevator(Constants.ELEVATOR_SPEED,Constants.ELEVATOR_SPEED));
    

    // hatchButton = new JoystickButton(joystick, Constants.HATCH_BUTTON);
    // hatchButton.whileHeld(new Pneumatics(Constants.HATCH_DIRECTION));

    // armUp = new JoystickButton(joystick, Constants.ARM_UP);
    // armDown = new JoystickButton(joystick, Constants.ARM_DOWN);

    // armUp.whileHeld(new MoveArm(Constants.ARM_SPEED));
    // armDown.whileHeld(new MoveArm(-Constants.ARM_SPEED));

    // wristUp = new JoystickButton(joystick, Constants.WRIST_UP);
    // wristDown = new JoystickButton(joystick, Constants.WRIST_DOWN);
    // wristUp.whileHeld(new MoveArm(Constants.WRIST_SPEED));
    // wristDown.whileHeld(new MoveArm(-Constants.WRIST_SPEED));
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

  public static DriveTrain getDriveTrain(){
    return driveTrain;
  }

  public Joystick getJoystick(){
    return joystick;
  }

  public Intake getIntake(){
    return intake;
  }

  public Elevator getElevator(){
    return elevator;
  }

  public Pulley getPulley(){
    return pulley;
  }

  public Shooter getShooter(){
    return shooter;
  }

  public Transport getTransport(){
    return transport;
  }

  // public HatchIntake getHatch(){
  //   return hatch;
  // }

  // public Wrist getWrist(){
  //   return wrist;
  // }

  // public Arm getArm(){
  //   return arm;
  // }
}
