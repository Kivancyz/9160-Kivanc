package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class PidCmd extends CommandBase {
  ElevatorSubsystem elevator;
  double Pos;

  public PidCmd(ElevatorSubsystem elevator,double Pos) {
    this.elevator = elevator;
    this.Pos = Pos;
    addRequirements(elevator);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    elevator.elevatorSetPos(Pos);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
