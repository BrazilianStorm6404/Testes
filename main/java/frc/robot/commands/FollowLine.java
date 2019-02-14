/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
   * <p> this {@link Comand} is used to recgnize the line </p>
   */
public class FollowLine extends Command {

  AHRS navX;
  DigitalInput optico;
  Boolean testeOtico = false;

  /**
   * <p> this {@link Comand} is used to recgnize the line </p>
   */
  public FollowLine() {

    requires(Robot.m_drive);

    navX = RobotMap.Sensors.navX;
    optico = RobotMap.Sensors.optical;
  }


  /**
   * 
   */
  @Override
  protected void initialize() {
    
  }
  
  /**
   * <p> this method verifies if the sensor is on the line. </p>
   * <p> If it is, it sets the setpoint and try to follow straight </p>
   * <p> Else, it turns left until it finds again </p>
   */
  @Override
  protected void execute() {
    
    if(this.optico.get()){
      testeOtico = true;
      Robot.m_drive.arcadeDrive(-0.7, Robot.m_drive.pidOutput);
    } else {
      Robot.m_drive.setSetpoint(this.navX.getYaw());
      Robot.m_drive.arcadeDrive(0.0, 0.7);
    }
    
  }

  /**
   * <p> returns false so it doesn`t execute more than once </p> 
   * @return boolean false so it doesn`t execute more than once 
   */
  @Override
  protected boolean isFinished() {
    return false;
  }

  /**
   * 
   */
  @Override
  protected void end() {
  }

  /**
   * 
   */
  @Override
  protected void interrupted() {
  }
}
