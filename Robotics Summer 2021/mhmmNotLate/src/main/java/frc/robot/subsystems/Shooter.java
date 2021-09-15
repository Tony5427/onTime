package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private SpeedController shootLeft, shootRight;

    public Shooter(SpeedController shootLeft, SpeedController shootRight) {
        this.shootLeft = shootLeft;
        this.shootRight = shootRight;
    }

    public void moveShooter(double lSpeed, double rSpeed) {
        shootLeft.set(lSpeed);
        shootRight.set(rSpeed);
    }

    public void stopShooter() {
        shootLeft.stopMotor();
        shootRight.stopMotor();
    }
    
}