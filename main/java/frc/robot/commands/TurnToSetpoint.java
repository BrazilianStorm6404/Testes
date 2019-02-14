/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;

 
/**
 * <p> {@link Command} that set a angle to the robot turn </p>
 */
public class TurnToSetpoint extends Command {

  /**
   * <p> {@link Command} that set a angle to the robot turn </p>
   */
  public TurnToSetpoint() {
    requires(Robot.m_drive); 
  }

  /**
   * 
   */
  @Override
  protected void initialize() { 

  }

  /**
   * <p> Starts the {@link DifferentialDrive} of the DriveTrain subsystem </p>
   * @see DriveTrain
   */
  @Override
  protected void execute() {
    Robot.m_drive.arcadeDrive(0, Robot.m_drive.pidOutput);
  }

  @Override
  protected boolean isFinished() {
    return Robot.m_drive.onTarget();
  } 
  
  @Override
  protected void end() {
   new Drive().start();
  }


  @Override
  protected void interrupted() {
    new Drive().start();
  }
}
