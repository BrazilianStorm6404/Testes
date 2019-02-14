/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * This subsystem was created to implement cargo and hatch panel intake in the
 * claw mechanism. Motors and sensors are defined in the RobotMap class.
 * 
 * @todo Implement elevator functionality.
 */
public class Claw extends Subsystem {

  private enum Modo{
    CARGO,
    HATCH_PANEL
  }

  private static Modo modo;

  /**
   * Motor that controls cargo intake.
   */
  VictorSPX victorIntake;
  VictorSPX victorControl;

  /**
   * Solenoid that controls hatch panel intake.
   */
  DoubleSolenoid solenoidHatch; 

  DigitalInput limitCargo;
  DigitalInput limitHatchPanel;
  



  public Claw() { 

    victorControl = RobotMap.Controllers.Claw.ControlVictorSPX;
    victorIntake = RobotMap.Controllers.Claw.IntakeVictorSPX;    
    solenoidHatch = RobotMap.Controllers.Claw.solenoidHatch;
    limitCargo = RobotMap.Sensors.Claw.CargoLimit;
    limitHatchPanel = RobotMap.Sensors.Claw.HatchPanelLimit;

    modo = Modo.HATCH_PANEL; //TEMPORARIO, MUDE ISSO O QUANTO ANTES
  }

  public Modo getModo(){

    return modo;

  }


  /**
   * Controls the cargo mechanism, grabbing the cargo.
   * Don't let the speed go higher than 0.5, otherwise it'll break the mechanism.
   * @see dropCargo()
   */
  public void pullCargo() {

    if(modo.equals(Modo.CARGO)){
      victorIntake.set(ControlMode.PercentOutput, 0.95); // Anything higher than 0.5 may break our mechanism.
    }

  }

  /**
   * Stops the motor to keep the cargo state.
   */
  public void stopCargo() { 
    victorIntake.set(ControlMode.PercentOutput, 0);
  }

  /**
   * Controls the cargo mechanism, dropping the cargo.
   * Don't let the speed go higher than 0.5, otherwise it'll break the mechanism.
   * @see pullCargo()
   */
  public void dropCargo() { 

    if (modo.equals(Modo.CARGO)) {
      victorIntake.set(ControlMode.PercentOutput, -0.95); // Anything higher than 0.5 may break our mechanism
    }

  }

  public void CargoMode (){

    RecallHatch();

    if (!limitCargo.get()) {  
      
      victorControl.set(ControlMode.PercentOutput, 0.8);

    } else {

      victorControl.set(ControlMode.PercentOutput, 0);
      modo = Modo.CARGO;

    }
  
  }

  public void HatchPanelMode(){

    stopCargo();

    if (!limitHatchPanel.get()) {

      victorControl.set(ControlMode.PercentOutput, -0.8);

    } else {

      victorControl.set(ControlMode.PercentOutput, 0);
      modo = Modo.HATCH_PANEL;

    }

  }
  /**
    * Deploys the hatch panel using our piston (controls the solenoid)
    * @see pitchDetractHatch()
    */
  public void ExtendHatch(){
    
    if (modo.equals(Modo.CARGO)) {
      solenoidHatch.set(Value.kForward); // This method raises the piston.
    }

  }
  
  /**
    * Picks up the hatch panel using our piston (controls the solenoid).
    * @see pitchDeployHatch()
    */
  public void RecallHatch(){
    
    if (modo.equals(Modo.CARGO)) {
      solenoidHatch.set(Value.kForward); // This method descends the piston.
    } 

  }  

  /**
   * Method that WPILib forces us to use, but we don't need to.
   */
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
