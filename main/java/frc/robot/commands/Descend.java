/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

/**
 * <p> This is an {@link InstantCommand} that activates the mechanism to make the robot climb down </p>
 */
public class Descend extends InstantCommand {
  
  /**
   * <p> This is an {@link InstantCommand} that activates the mechanism to make the robot climb down </p>
   */
  public Descend() {
    super();
    requires(Robot.m_climber);
  }

  /**
   * <p> call the descend method in the Climber subsystem </p>
   * @see Climber#descend()
   */
  @Override
  protected void initialize() {
    Robot.m_climber.descend();
  }

}
