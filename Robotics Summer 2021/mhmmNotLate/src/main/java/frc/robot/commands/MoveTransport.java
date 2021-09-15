package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class MoveTransport extends CommandBase {

    private double speed;

    public MoveTransport(double speed) {
        this.speed = speed;
    }

    @Override
    public void initialize() {
        Robot.m_robotContainer.getTransport().moveTransport(speed);
    }

    @Override
    public void execute() {
        Robot.m_robotContainer.getTransport().moveTransport(speed);
    }

    @Override
    public boolean isFinished() {
        if(speed > 0) {
            return Robot.m_robotContainer.getJoystick().getRawButton(Constants.TRANSPORT_BUTTON);
        } else {
            return !Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.TRANSPORT_BUTTON);
        }
    }

    @Override
    public void end(boolean interrupted) {
        Robot.m_robotContainer.getTransport().stopTransport();
    }
    
}