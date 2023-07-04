package frc.robot.commands;


import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class OperatedJoy extends CommandBase {

  public DoubleSupplier left;
  public DoubleSupplier right;


  public DriveTrain drivetrain;
  double leftAxis;
  double rightAxis;

  public OperatedJoy(DriveTrain driveTrain,DoubleSupplier left,DoubleSupplier right) {
    this.left = left;
    this.right = right;
    this.drivetrain = driveTrain;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    drivetrain.arcadedrive(right.getAsDouble(), left.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
