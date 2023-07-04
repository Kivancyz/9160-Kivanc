package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Driveauto extends CommandBase {

  DriveTrain drivetrain;
  public boolean finish = false;
  Timer timer;


  public Driveauto(DriveTrain drivetrain) {
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
    timer = new Timer();
  }

  @Override
  public void initialize() {
    
    timer.reset();
    timer.start();
    drivetrain.leftEncoder.setDistancePerPulse(1/256);
    drivetrain.leftEncoder.setDistancePerPulse(1/256);
    drivetrain.leftEncoder.reset();
    drivetrain.rightencoder.reset();

  
  }

  @Override
  public void execute() {
    if(timer.get() < 5.0 ){
      if(drivetrain.leftEncoder.getDistance() < 1.0){
        drivetrain.tankDrive(0.6, -0.5);
      }
      else if(drivetrain.leftEncoder.getDistance() > 0.0 && drivetrain.leftEncoder.getDistance() < 1.0){
        drivetrain.tankDrive(-0.6, 0.5);
      }
      else if(drivetrain.leftEncoder.getDistance() > 1.0 && drivetrain.leftEncoder.getDistance() < 3.0){
        drivetrain.tankDrive(0.6, -0.5);
      }
    }

    else if(timer.get() > 5.0 && timer.get() < 15.0){
      drivetrain.UseGyro(drivetrain.imu);
    }
    else {
       drivetrain.stop();
    }
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  @Override
  public boolean isFinished() {
    return finish;
  }
}
