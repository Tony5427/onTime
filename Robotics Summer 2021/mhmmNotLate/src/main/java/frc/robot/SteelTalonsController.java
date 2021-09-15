package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController; 

public class SteelTalonsController extends WPI_VictorSPX implements SpeedController{

    private boolean reverse;
    private double bias;

    public SteelTalonsController(final int deviceNumber, final boolean reverse, final double bias) {
        super(deviceNumber);
        this.reverse = reverse;
        this.bias = bias;
        setInverted(reverse);

    }

    @Override
    public void set(double speed){
        super.set(speed*bias);
    }

}