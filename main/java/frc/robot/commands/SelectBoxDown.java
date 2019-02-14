/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.OI;
import frc.robot.RobotMap;

/**
 * <p> A {@link InstantCommand} that go down 1 level from the shuffleboard at the tab angles </p>
 * @see RobotMap.ShuffleBoard#chooser5
 * @see OI#getAngle()
 */
public class SelectBoxDown extends InstantCommand {
  
  private int angle;
  private int newAngle = 0;

  /**
   * <p> A {@link InstantCommand} that go down 1 level from the shuffleboard at the tab angles </p>
   * @see RobotMap.ShuffleBoard#chooser5
   * @see OI#getAngle()
   */
  public SelectBoxDown() {
    super();
  }

  /**
   * <p> the method gets the angle from {@link OI}, then: </p>
   * <p>    * it searches for what angle it is </p>
   * <p>    * set that angle chooser to true </p>
   * <p>    * set the others chooser to false </p>
   * <p>    * set the angle to the next value (the nearest lower than this) </p>
   * <p>    * set the new angle to be seen </p>
   */
  @Override
  protected void initialize() {
    // gets the angle from OI
    angle = OI.getAngle();

    // select the tab Angles from the ShuffleBoard
    Shuffleboard.selectTab("Angles");

    // select the corresponding angle 
    switch(angle){
      case 45:
        RobotMap.ShuffleBoard.chooser1.setBoolean(false);
        RobotMap.ShuffleBoard.chooser2.setBoolean(true);
        RobotMap.ShuffleBoard.chooser3.setBoolean(false);
        RobotMap.ShuffleBoard.chooser4.setBoolean(false);

        newAngle = 90;
        break;
      case 90: 
        RobotMap.ShuffleBoard.chooser1.setBoolean(false);
        RobotMap.ShuffleBoard.chooser2.setBoolean(false);
        RobotMap.ShuffleBoard.chooser3.setBoolean(true);
        RobotMap.ShuffleBoard.chooser4.setBoolean(false);

        newAngle = 135;
        break;
      case 135:
        RobotMap.ShuffleBoard.chooser1.setBoolean(false);
        RobotMap.ShuffleBoard.chooser2.setBoolean(false);
        RobotMap.ShuffleBoard.chooser3.setBoolean(false);
        RobotMap.ShuffleBoard.chooser4.setBoolean(true);

        newAngle = 180;
        break;
      case 180:
        RobotMap.ShuffleBoard.chooser1.setBoolean(true);
        RobotMap.ShuffleBoard.chooser2.setBoolean(false);
        RobotMap.ShuffleBoard.chooser3.setBoolean(false);
        RobotMap.ShuffleBoard.chooser4.setBoolean(false);

        newAngle = 45;
        break;
    }

    // set the new angle to OI and the ShuffleBoard
    OI.setAngle(newAngle);
    RobotMap.ShuffleBoard.chooser5.setNumber(newAngle);
  }

}
