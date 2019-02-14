package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.TowerDown;
import frc.robot.commands.TowerStop;
import frc.robot.commands.TowerUp;

/**
 * <p>
 * the {@link OI} is used to map the joystic to the controller
 * </p>
 */
public class OI {

    public final Joystick driverController = RobotMap.OI.driverController;

    // We named the variables based on the xbox controller buttons
    Button buttonA = new JoystickButton(driverController, 1);
    Button buttonB = new JoystickButton(driverController, 2);
    Button buttonX = new JoystickButton(driverController, 3);
    Button buttonY = new JoystickButton(driverController, 4);
    Button buttonL = new JoystickButton(driverController, 5);
    Button buttonR = new JoystickButton(driverController, 6);
    Button select = new JoystickButton(driverController, 7);
    Button start = new JoystickButton(driverController, 8);

    private static int angle = 45;

    public static void setAngle(int angle) {
        OI.angle = angle;
    }

    public static int getAngle() {
        return OI.angle;
    }

    /**
     * <p>
     * Sets the {@link Button} Config and what method it activates in what state
     * </p>
     */
    public OI() {

        buttonA.whileHeld(new TowerDown());
        buttonA.whenReleased(new TowerStop());

        buttonB.whileHeld(new TowerUp());
        buttonB.whenReleased(new TowerStop());
    }

}
