package frc.robot.Subsystems;

import static frc.robot.Constants.IntakeConstants.LeftTalonSRX;
import static frc.robot.Constants.IntakeConstants.LeftVictorSPX;
import static frc.robot.Constants.IntakeConstants.RightTalonSRX;
import static frc.robot.Constants.IntakeConstants.RightVictorSPX;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.POM_lib.PomSubsystem;

public class DriveSubsytems extends PomSubsystem {

    
    private WPI_TalonSRX leftMaster;
    private WPI_VictorSPX leftSlave;
    private WPI_TalonSRX rightMaster;
    private WPI_VictorSPX rightSlave;
    

    private DifferentialDrive differentialDrive;


    public DriveSubsytems(){
        leftMaster = new WPI_TalonSRX(LeftTalonSRX);
        leftSlave = new WPI_VictorSPX(LeftVictorSPX);
        rightMaster = new WPI_TalonSRX(RightTalonSRX);  
        rightSlave = new WPI_VictorSPX(RightVictorSPX);
        differentialDrive = new DifferentialDrive(leftMaster::set, rightMaster::set);
    }

    public void Drive(Double speed, Double rotation){
        differentialDrive.arcadeDrive(speed, rotation);
    }
    
}
