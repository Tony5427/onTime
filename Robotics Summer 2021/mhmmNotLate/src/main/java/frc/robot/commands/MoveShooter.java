  
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;

public class MoveShooter extends CommandBase {
    private double lSpeed;
    private double rSpeed;

    public MoveShooter(double lSpeed, double rSpeed) {
        this.lSpeed = lSpeed;
        this.rSpeed = rSpeed;
    }

    @Override
    public void initialize() {
        Robot.m_robotContainer.getShooter().moveShooter(lSpeed, rSpeed);
    }

    @Override
    public void execute() {
        Robot.m_robotContainer.getShooter().moveShooter(lSpeed, rSpeed);
    }

    @Override
    public boolean isFinished() {
        return (!Robot.m_robotContainer.getJoystick().getRawButton(Constants.SHOOTER_BUTTON));
        
    }

    @Override
    public void end(boolean interrupted) {
        Robot.m_robotContainer.getShooter().stopShooter();
    }
}