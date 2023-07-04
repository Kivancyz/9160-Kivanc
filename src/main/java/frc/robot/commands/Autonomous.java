package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;


public class Autonomous extends SequentialCommandGroup {

  public Autonomous(DriveTrain drivetrain) {

    addCommands(new Driveauto(drivetrain));
  }
}
