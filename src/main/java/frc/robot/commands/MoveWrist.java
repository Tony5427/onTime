package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveWrist extends CommandBase {

    private double speed;

    public MoveWrist(double speed) {
        this.speed = speed;
    }

    @Override
    public void initialize() {
        Robot.m_robotContainer.getWrist().movewrist(speed);
    }

    @Override
    public void execute() {
        Robot.m_robotContainer.getWrist().movewrist(speed);
    }

    @Override
    public boolean isFinished()
    {

        if(Robot.m_robotContainer.getWrist().wristChecker(Robot.m_robotContainer.getWrist().getWristAngle()))
            return true;

        else if(speed > 0)
            return !Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.WRIST_UP);

        else
            return !Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.WRIST_DOWN);

    }

    @Override
    public void end(boolean interrupted)
    {
        Robot.m_robotContainer.getWrist().stopWrist();
    }

}