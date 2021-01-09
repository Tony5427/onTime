package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;

public class Pneumatics extends CommandBase{

    private boolean direction;

    public Pneumatics(boolean direction){
        this.direction = direction;
    }

    @Override
    public void initialize()
    {
        Robot.m_robotContainer.getHatch().setHatch(direction);
    }

    @Override
    public void execute()
    {
        Robot.m_robotContainer.getHatch().setHatch(direction);
    }

    @Override
    public boolean isFinished()
    {
        return !Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.HATCH_BUTTON);
    }

    @Override
    public void end(boolean interrupted)
    {
        Robot.m_robotContainer.getHatch().stopHatch();
    }

}