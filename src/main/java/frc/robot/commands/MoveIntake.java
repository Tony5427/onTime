package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class MoveIntake extends CommandBase{

    private double speed;

    public MovieIntake(double speed){
        this.speed = speed;
    }

    @Override
    public void initialize(){
        Robot.m_robotContainer.getIntake().moveIntake(speed);
    }

    @Override
    public void execute(){
        Robot.m_robotContainer.getIntake().moveIntake(speed);
    }

    @Override
    public boolean isFinished(){
        if(speed>0){
            return Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.INTAKE_IN_BUTTON);
        }
        return !return Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.INTAKE_IN_BUTTON);
    }

    @Override
    public void end(boolean interrupted){
        Robot.m_robotContainer.getIntake().stopIntake();    
    }

}