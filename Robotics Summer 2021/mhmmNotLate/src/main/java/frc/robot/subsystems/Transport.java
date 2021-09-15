package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Transport extends SubsystemBase {

    private SpeedController transportSpeed;

    public Transport(SpeedController transportSpeed) {
        this.transportSpeed = transportSpeed;
    }

    public void moveTransport(double speed) {
        transportSpeed.set(speed);
    }

    public void stopTransport() {
        transportSpeed.stopMotor();
    }
}