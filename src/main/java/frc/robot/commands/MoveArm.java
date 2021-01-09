package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveArm extends CommandBase {

    private double speed;

    public MoveArm(double speed) {
        this.speed = speed;
    }

    @Override
    public void initialize() {
        Robot.m_robotContainer.getArm().moveArm(speed);
    }

    @Override
    public void execute() {
        Robot.m_robotContainer.getArm().moveArm(speed);
    }

    @Override
    public boolean isFinished()
    {

        if(Robot.m_robotContainer.getArm().armChecker(Robot.m_robotContainer.getArm().getArmAngle()))
            return true;

        else if(speed > 0)
            return !Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.ARM_UP);

        else
            return !Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.ARM_DOWN);

    }

    @Override
    public void end(boolean interrupted)
    {
        Robot.m_robotContainer.getArm().stopArm();
    }

}