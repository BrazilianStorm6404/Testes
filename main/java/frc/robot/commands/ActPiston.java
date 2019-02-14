package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Claw;

/**
 * This is an {@link InstantCommand} that makes the pneumatic actuator go further
 */
public class ActPiston extends InstantCommand {

  /**
   * This is an {@link InstantCommand} that makes the pneumatic actuator go further
   */
  public ActPiston() {
    super();
    requires(Robot.m_claw);
  }

  /**
   * <p> Calls the pitchDeployHatch method in the Claw subsystem </p>
   * @see Claw#pitchDeployHatch()
   */
  @Override
  protected void initialize() {
    Robot.m_claw.ExtendHatch();
   
    try {
      Thread.sleep(500);
    } catch(InterruptedException ex){
      System.err.print(ex);
    }
    Robot.m_claw.RecallHatch();
  }

}
