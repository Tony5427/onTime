package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;

public class DriveWithJoystick extends CommandBase{

    public DriveWithJoystick(){
        addRequirements(RobotContainer.getDriveTrain());
    }
    
    public void initalize(){
        Robot.m_robotContainer.getDriveTrain().takeJoystickInputs(Robot.m_robotContainer.getJoystick());
    }

    @Override
    public void execute(){
        Robot.m_robotContainer.getDriveTrain().takeJoystickInputs(Robot.m_robotContainer.getJoystick());
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){
        Robot.m_robotContainer.getDriveTrain().stop();
    }
}