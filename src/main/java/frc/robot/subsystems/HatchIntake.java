package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.*;

public class HatchIntake extends SubsystemBase 
{
    // Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.INTAKE_IN_BUTTON)
    public Solenoid solenoid;
    public boolean onf;
    public HatchIntake(boolean onf, Solenoid solenoid)
    {
        this.solenoid = solenoid;
        this.onf = onf;
        this.solenoid.set(onf);
    }

    public void setHatch(boolean onf)
    {
        solenoid.set(onf);
    }

    public void stopHatch(){
        solenoid.set(!onf);
    }
}