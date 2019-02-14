package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap.ShuffleBoard;
import frc.robot.commands.FollowLine;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Tower;

public class Robot extends TimedRobot {

  public static OI m_oi;
  public static Drivetrain m_drive;
  public static Climber m_climber;
  public static Claw m_claw;
  public static Tower m_tower;
  
  public ShuffleBoard m_ShuffleBoard = new ShuffleBoard();

  Command m_autonomousCommand;

  @Override
  public void robotInit() {
    
    m_oi = new OI();
    m_drive = new Drivetrain();
    m_climber = new Climber();
    m_claw = new Claw();
    m_tower = new Tower();

    m_autonomousCommand = new FollowLine();

    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(640, 360);
    
    RobotMap.Sensors.navX.reset();
    
  }

  @Override
  public void robotPeriodic() {
    m_ShuffleBoard.defAbsPoisition();
    m_ShuffleBoard.defAbsAngleInTape();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
    m_ShuffleBoard.getInitialPosition();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    // data for the ShuffleBoard
    SmartDashboard.putNumber("Yaw", RobotMap.Sensors.navX.getYaw());
    SmartDashboard.putNumber("setpoint", Robot.m_drive.getSetpoint());
    SmartDashboard.putBoolean("optico", RobotMap.Sensors.optical.get());
    SmartDashboard.putNumber("DirAxis", m_oi.driverController.getRawAxis(5));
    SmartDashboard.putBoolean("LimitUp", RobotMap.Sensors.Tower.limitUp.get());
    SmartDashboard.putBoolean("LimitDOWN", RobotMap.Sensors.Tower.limitDown.get());

  }

  @Override
  public void testPeriodic() {
  }
}
