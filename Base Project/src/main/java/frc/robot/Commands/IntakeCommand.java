package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.IntakeSubsystem;

public class IntakeCommand extends Command {
    IntakeSubsystem m_IntakeSubsystem;
    double velocity;

    public IntakeCommand(IntakeSubsystem intakeSubsystem ,double speed){
        m_IntakeSubsystem = intakeSubsystem;
        addRequirements(m_IntakeSubsystem);
        velocity = speed;
    }


    @Override
    public void execute() {
        m_IntakeSubsystem.setSpeed(velocity);
    }
    
}
