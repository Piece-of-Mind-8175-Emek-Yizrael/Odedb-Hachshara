package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.ArmSubsystem;

public class ResistGravityCommad extends Command {

    ArmSubsystem m_armSubsystem;
    
    public ResistGravityCommad(ArmSubsystem armSubsystem){
        m_armSubsystem = armSubsystem;
        addRequirements(armSubsystem);


    }

    @Override
    public void execute() {
        m_armSubsystem.arm.set(0 + m_armSubsystem.resistGravity());
    }
    
}
