package frc.robot.Subsystems;

import static frc.robot.Constants.IntakeConstants.INTAKE_PORT;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;

import frc.robot.POM_lib.PomSubsystem;

public class IntakeSubsystem extends PomSubsystem {
    


    public CANSparkMax intake;

    public IntakeSubsystem(){
         intake = new CANSparkMax(INTAKE_PORT, MotorType.kBrushless);
    }


    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake Speed", intake.getEncoder().getVelocity());
    }



    public void setSpeed(Double speed){
        intake.set(speed);
    }
    
    public void stop(){
        intake.set(0);
    }

}
