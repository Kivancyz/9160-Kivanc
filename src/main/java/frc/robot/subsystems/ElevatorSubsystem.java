
package frc.robot.subsystems;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
 import com.revrobotics.RelativeEncoder;


public class ElevatorSubsystem extends SubsystemBase {
  public CANSparkMax kol ;
  public RelativeEncoder kolEncoder;

  public final PIDController pid;
  
  
  public ElevatorSubsystem() {
    kol = new CANSparkMax(3, MotorType.kBrushless);
    kolEncoder = kol.getEncoder();

    pid = new PIDController(0.5, 0, 0);
  }

  public void elevatorforward(double speed){
    kol.set(speed);
  }

  public void elevatorSetPos( double Pos){
      kol.set(pid.calculate(kolEncoder.getPosition(), Pos));
  }

  

  

  @Override
  public void periodic() {
    kolEncoder.setPosition(0);
    SmartDashboard.putNumber("solsase mesafe", kolEncoder.getPosition());//sol sase encoder
  }
}
