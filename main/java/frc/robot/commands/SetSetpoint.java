/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;



/**
 * <p> {@link InstantComand} that set the point in the Navx </p>
 */
public class SetSetpoint extends InstantCommand {

  
  /**
   * <p> {@link InstantComand} that set the point in the Navx </p>
   */
  public SetSetpoint() {
    super();
    requires(Robot.m_drive); 
  }

  /**
   * set the point in the DriveTrain subsystem based on the Yaw of the Navx
   * @see DriveTrain 
   */
  @Override
  protected void initialize() {
    Robot.m_drive.setSetpoint(RobotMap.Sensors.navX.getYaw());
  }

}
