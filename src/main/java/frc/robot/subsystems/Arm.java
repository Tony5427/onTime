package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.Constants;
import frc.robot.Robot;

public class Arm extends SubsystemBase {
    private SpeedController armController;
    public Potentiometer armPotent;
    public double armSpeed;
    public double armAngle;

    public Arm(SpeedController armController, Potentiometer armPotent) {
        this.armPotent = armPotent;
        this.armController = armController;
    }

    public boolean armChecker(double potentiometervalue) {
        if (potentiometervalue < Constants.ARM_BOTTOM) {
            return false;
        } else if (potentiometervalue > Constants.ARM_TOP) {
        return false;
        } else {
            return true;
        }
    }
    public double getSpeed() {
        return armSpeed;
    }

    public void stopArm() {
        armController.stopMotor();
    }
    
    public void moveArm(double armspeed) {
        if(Math.abs(armSpeed)>0&&armChecker(getArmAngle()))
            armController.set(armspeed);
        else 
            armController.set(0);
    }

    public void setArmAngle(double angle) {
        this.armAngle = angle;
    }

    public double getArmAngle()
    {
        return armAngle;
    }
}