package frc.robot.subsystems;


import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends SubsystemBase {
  
  public AHRS imu;
  public PWMTalonSRX left1 ;
  public PWMTalonSRX left2 ;
  public PWMTalonSRX right1  ;
  public PWMTalonSRX right2 ;
  public MotorControllerGroup righControllerGroup; //= new MotorControllerGroup(right1,right2);
  public MotorControllerGroup lefMotorControllerGroup ;//= new MotorControllerGroup(left1,left2);
  public DifferentialDrive differentialDrive; //= new DifferentialDrive(lefMotorControllerGroup, righControllerGroup);
  public Encoder leftEncoder ;
  public Encoder rightencoder ;
  
  public DriveTrain() {
    left1 = new PWMTalonSRX(0);
    left1.setInverted(false);
    left2 = new PWMTalonSRX(1);
    left2.setInverted(false);
    right1 = new PWMTalonSRX(3);
    right1.setInverted(true);
    right2 = new PWMTalonSRX(2);
    right2.setInverted(true);

    righControllerGroup = new MotorControllerGroup(right1,right2);
    lefMotorControllerGroup = new MotorControllerGroup(left1,left2);
    differentialDrive = new DifferentialDrive(lefMotorControllerGroup, righControllerGroup);

    leftEncoder = new Encoder(0, 1, false,Encoder.EncodingType.k4X);
    rightencoder = new Encoder(3, 2, false,Encoder.EncodingType.k4X);
    imu = new AHRS();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("solsase mesafe", leftEncoder.getDistancePerPulse());//sol sase encoder

  }

  public void tankDrive(double rightspeed, double leftspeed){
    differentialDrive.tankDrive(leftspeed, rightspeed);
    
  }

  public void arcadedrive(double forward, double rot){
    differentialDrive.arcadeDrive(forward, rot);
  }

  public void UseGyro(AHRS imu){
    if(imu.getPitch() < 1.0 && imu.getPitch() > -1.0){
      
      differentialDrive.stopMotor();
    }
    else if(imu.getPitch() > 1.0 && imu.getPitch() < 5.0){
      differentialDrive.tankDrive(-0.05, 0.05);
    }
    else if(imu.getPitch() < -1.0 && imu.getPitch() > -5.0){
      differentialDrive.tankDrive(0.05, -0.05);
    }
    else if(imu.getPitch() > 5.0 && imu.getPitch() < 15.0){
      differentialDrive.tankDrive(-0.1, 0.1);
    }
    else if(imu.getPitch() > 15.0 && imu.getPitch() < 45.0){
      differentialDrive.tankDrive(-0.2, 0.2);
    }
    else if(imu.getPitch() < -5.0 && imu.getPitch() > -15.0){
      differentialDrive.tankDrive(0.1, -0.1);
    }
    
  }

  public void stop(){
    differentialDrive.stopMotor();
  }

}
