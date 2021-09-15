package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase{
    private SpeedController eLeft, eRight;
    private DigitalInput rLimitSwitch, lLimitSwitch;
    private Encoder lEncoder, rEncoder;
    private double lSpeed, rSpeed;

    public Elevator(SpeedController eLeft, SpeedController eRight, DigitalInput rLimitSwitch, DigitalInput lLimitSwitch, Encoder rEncoder, Encoder lEncoder){
        this.eLeft=eLeft;
        this.rLimitSwitch = rLimitSwitch;
        this.eRight = eRight;
        this.rEncoder = rEncoder;
        this.lEncoder = lEncoder;

    }

    public void moveElevator(double lSpeed, double rSpeed){
        this.lSpeed = lSpeed;
        this.rSpeed = rSpeed;

        eLeft.set(lSpeed);
        eRight.set(rSpeed);
    }

    public void stopElevator(){
        eLeft.stopMotor();
        eRight.stopMotor();
    }    

    public boolean reachedEncoderLimit(){
        if(rEncoder.getDistance()>=Constants.RENCODER_LIMIT||lEncoder.getDistance()<=Constants.LENCODER_LIMIT){
            return true;
         }else{
           return false;
      }
    }

    public double getLSpeed(){
        return lSpeed;
    }

    public double getRSpeed(){
        return rSpeed;
    }

    public boolean getRLimitSwitch(){
        return rLimitSwitch.get();
    }

    public boolean getLLimitSwitch(){
        return lLimitSwitch.get();
    }

}