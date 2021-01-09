package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.Constants;
import frc.robot.Robot;

public class Wrist extends SubsystemBase {
    private SpeedController wristController;
    public Potentiometer wristPotent;
    public double wristSpeed;
    public double wristAngle;

    public Wrist(SpeedController wristController, Potentiometer wristPotent) {
        this.wristPotent = wristPotent;
        this.wristController = wristController;
    }

    public boolean wristChecker(double potentiometervalue) {
        if (potentiometervalue < Constants.WRIST_BOTTOM) {
            return false;
        } else if (potentiometervalue > Constants.WRIST_TOP) {
        return false;
        } else {
            return true;
        }
    }
    public double getSpeed() {
        return wristSpeed;
    }

    public void movewrist(double wristspeed) {
        if(Math.abs(wristSpeed)>0&&wristChecker(getWristAngle()))
            wristController.set(wristspeed);
        else 
            wristController.set(0);
    }

    public void setWristAngle(double angle) {
        this.wristAngle = angle;
    }

    public double getWristAngle()
    {
        return wristAngle;
    }

    public void stopWrist() {
        wristController.stopMotor();
    }
}