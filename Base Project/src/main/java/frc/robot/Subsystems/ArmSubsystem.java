package frc.robot.Subsystems;

import static frc.robot.Constants.IntakeConstants.ARM_PORT;
import static frc.robot.Constants.IntakeConstants.GROUND_SWITCH;
import static frc.robot.Constants.IntakeConstants.LIMIT_SWITCH;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.POM_lib.PomSubsystem;

public class ArmSubsystem extends PomSubsystem {

    public CANSparkMax arm;
    private RelativeEncoder arm_encoder;
    public ArmFeedforward armFeedforward;
    private DigitalInput foldLimitSwitch;
    private DigitalInput groundLimitSwitch;


    public ArmSubsystem(){
        
        arm = new CANSparkMax(ARM_PORT, MotorType.kBrushless);
        arm_encoder = arm.getEncoder();
        arm_encoder.setPositionConversionFactor(1/50.0 * 16/42.0 * 2 * Math.PI);
        armFeedforward = new ArmFeedforward(0, 0.048, 0);
        foldLimitSwitch  = new DigitalInput(LIMIT_SWITCH);
        groundLimitSwitch = new DigitalInput(GROUND_SWITCH);
        

    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("arm encoder" ,arm_encoder.getPosition());
        SmartDashboard.putNumber("feed forward" ,resistGravity());
        // SmartDashboard.putBoolean("flag" ,fold_flag);
        SmartDashboard.putBoolean("Limit Switch" ,!foldLimitSwitch.get());
        SmartDashboard.putBoolean("Ground Switch" ,!groundLimitSwitch.get());
    }

    public void OpenArm(double speed){
        if(groundLimitSwitch.get()){
            arm.set(speed + resistGravity());

        }
        else if(!groundLimitSwitch.get()){
            arm.set(0);
        }
    }

    public void CloseArm(double speed){
        if(foldLimitSwitch.get()){
            arm.set(speed + resistGravity());

        }
        else if(!foldLimitSwitch.get()){
            arm.set(0);
        }
    }






        
        // if(!foldLimitSwitch.get()){
        //     arm_encoder.setPosition(-0.323);
        // }

    

        public double resistGravity(){
            return armFeedforward.calculate(arm_encoder.getPosition(),0);   
        }
    
}

