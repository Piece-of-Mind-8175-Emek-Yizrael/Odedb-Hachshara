package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.ArmSubsystem;

public class OpenArmCommand extends Command {
    ArmSubsystem m_ArmSubsystem;
    double speed;

    public OpenArmCommand(ArmSubsystem armSubsystem, double speed){
        m_ArmSubsystem = armSubsystem;
        addRequirements(m_ArmSubsystem);
        this.speed = speed;
    }

    public void execute(){
        m_ArmSubsystem.OpenArm(speed);
    }

    
}
