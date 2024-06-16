package frc.robot.Commands;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveSubsytems;

public class ArcadeDriveCommand extends Command {
    DriveSubsytems m_DriveSubsytems;
    DoubleSupplier speed;
    DoubleSupplier rotation;

    public  ArcadeDriveCommand(DriveSubsytems driveSubsytem, DoubleSupplier speed, DoubleSupplier rotation){
        m_DriveSubsytems = driveSubsytem;
        addRequirements(m_DriveSubsytems);
        this.speed = speed;
        this.rotation = rotation;
    }

    public void execute(){
        m_DriveSubsytems.Drive(speed.getAsDouble(), rotation.getAsDouble());
    }
}
