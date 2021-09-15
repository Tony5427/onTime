package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.*;

public class MoveElevator extends CommandBase{
    private double lSpeed;
    private double rSpeed;

    public MoveElevator(double lSpeed, double rSpeed){
        this.lSpeed = lSpeed;
        this.rSpeed = rSpeed;
    }

    @Override
    public void initialize(){
        Robot.m_robotContainer.getElevator().moveElevator(lSpeed, rSpeed);
    }

    @Override
    public void execute(){
        Robot.m_robotContainer.getElevator().moveElevator(lSpeed, rSpeed);
        
        if(lSpeed<0&&rSpeed<0){
            if(Robot.m_robotContainer.getElevator().getLLimitSwitch()||Robot.m_robotContainer.getElevator().getRLimitSwitch()){
                Robot.m_robotContainer.getElevator().stopElevator();
            }
        }else if(lSpeed >0&&rSpeed>0){
            if(Robot.m_robotContainer.getElevator().reachedEncoderLimit()){
                Robot.m_robotContainer.getElevator().stopElevator();
            }
        }
    }

    @Override
    public boolean isFinished() {
        if(Robot.m_robotContainer.getJoystick().getRawButton(Constants.ELEVATOR_UP) || Robot.m_robotContainer.getJoystick().getRawButton(Constants.ELEVATOR_DOWN)) {
           return false;
        } else {
            return true;
        }
    }

    @Override
    public void end(boolean override) {
        Robot.m_robotContainer.getElevator().stopElevator();
    }
}