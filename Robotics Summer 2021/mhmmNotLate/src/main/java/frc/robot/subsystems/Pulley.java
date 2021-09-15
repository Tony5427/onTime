package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pulley extends SubsystemBase {
    private SpeedController pulleySpeed;

    public Pulley(SpeedController pulleySpeed) {
        this.pulleySpeed = pulleySpeed;

    }

    public void movePulley(double speed) {
        pulleySpeed.set(speed);
    }

    public void stopPulley() {
        pulleySpeed.stopMotor();
    }
}