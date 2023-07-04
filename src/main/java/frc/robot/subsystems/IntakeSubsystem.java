package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {
  
  public CANSparkMax redline = new CANSparkMax(4, MotorType.kBrushed);
  public IntakeSubsystem() {}

  @Override
  public void periodic() {
  }

  public void intakeforward(double speed){
    redline.set(speed);
  }

  
}
