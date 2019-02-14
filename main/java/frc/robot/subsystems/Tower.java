/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class Tower extends Subsystem {
  

  private SpeedControllerGroup group;
  public DigitalInput limitUp;
  public DigitalInput limitDown;
  

  public Tower(){

    group = RobotMap.Controllers.Tower.Group;

    limitUp = RobotMap.Sensors.Tower.limitUp;
    limitDown = RobotMap.Sensors.Tower.limitDown; 

  }

  public void move(double vel) { 

    group.set(vel);
    
    /*
    if(!limitUp.get() && vel > 0 ){
     
      group.set(vel);
    
    }else if(!limitDown.get() && vel < 0){

      group.set(vel);

    }else{

      stop();

    }
    */
  }

 
  public void stop() {

    group.stopMotor();

  }

  

  @Override
  public void initDefaultCommand() {

  }
}