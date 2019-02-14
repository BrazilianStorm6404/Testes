/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * <p> This subsystem was created to instantiate all the methods and motor controllers for the climber mechanism of the robot. </p>
 * <p> All declarations are stored on the RobotMap Class. </p>
 */
public class Climber extends Subsystem {
  
  /**
   * <p> We are using VictorSPX to this mechanism. Be careful not to mess with it's CAN ID. </p>
   * <p> Any doubt, consider looking at the tool CTRE Phoenix. </p>
   */
  public SpeedControllerGroup climbSparks;

  public Climber(){
    climbSparks = RobotMap.Controllers.Climb.Group;
  }

  /**
   * <p> This one makes the robot climb up. </p>
   * <p> Both
   * 8 motors should move in the same way. </p>
   * <p> Else, the mechanism will break. </p>
   * <p> Be sure to test both Victors individually before running it. </p>
   */
  public void ascend() { 

    climbSparks.set(0.8);
    
  }

  /**
   * <p> This one makes the robot climb down. </p>
   * <p> Both motors should move in the same way. </p>
   * <p> Else, the mechanism will break. </p>
   * <p> Be sure to test both Victors individually before running it. </p>
   */
  public void descend() {

    climbSparks.set(-0.8);

  }

  /**
   * <p> This method makes the mechanism stop. </p>
   */
  public void stop() {

    climbSparks.stopMotor();

  }

  /**
   * Method that WPILib forces us to use, but we don't need to.
   */ 
  @Override
  public void initDefaultCommand() {
    // no default command yet
  }
}
