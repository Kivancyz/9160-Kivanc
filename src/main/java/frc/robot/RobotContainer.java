package frc.robot;

import frc.robot.commands.Autonomous;
import frc.robot.commands.Driveauto;
import frc.robot.commands.ElevatorCmd;
import frc.robot.commands.IntakeCmd;
import frc.robot.commands.OperatedJoy;
import frc.robot.commands.PidCmd;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {
  public PidCmd pidCmd;
  public RobotContainer m_robotcontainer = new RobotContainer();

  public ElevatorSubsystem elevator;
  public IntakeSubsystem intake;
  public DriveTrain drivetrain;
  public OperatedJoy OpCmd;
  public Driveauto driveCmd;
  public static Joystick joy ;
  public Autonomous auto;
  public ElevatorCmd ElCmd;
  public IntakeCmd intakeCmd;
  

  public RobotContainer() {
    joy = new Joystick(0);
    
    drivetrain = new DriveTrain();
    drivetrain.setDefaultCommand(new OperatedJoy(drivetrain,()-> -joy.getRawAxis(1), ()-> -joy.getRawAxis(4)));//drive
    OpCmd.addRequirements(drivetrain);

    driveCmd = new Driveauto(drivetrain);
    driveCmd.addRequirements(drivetrain);//auto
    auto = new Autonomous(drivetrain);

    intake = new IntakeSubsystem();
    intake.setDefaultCommand(intakeCmd);//intake
    intakeCmd.addRequirements(intake);

    elevator = new ElevatorSubsystem();
    elevator.setDefaultCommand(ElCmd);
    pidCmd.addRequirements(elevator);//elevator
    ElCmd.addRequirements(elevator);

    configureBindings();
  }

  
  private void configureBindings() {
   new JoystickButton(joy, 1).onTrue(new ElevatorCmd(elevator, 0.4));
   new JoystickButton(joy, 2).onTrue(new ElevatorCmd(elevator, -0.4));

   new JoystickButton(joy, 3).onTrue(new IntakeCmd(intake, 0.4));
   new JoystickButton(joy, 4).onTrue(new IntakeCmd(intake, -0.4));

   new JoystickButton(joy, 5).onTrue(new PidCmd(elevator, 45));
   new JoystickButton(joy, 5).onTrue(new PidCmd(elevator, 25));
   new JoystickButton(joy, 5).onTrue(new PidCmd(elevator, 5));

  }

  
   public Command getAutonomousCommand() {
    return auto;
   }
}
