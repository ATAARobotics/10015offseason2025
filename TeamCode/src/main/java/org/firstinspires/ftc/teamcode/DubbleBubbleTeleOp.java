package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


// the "name=" here is what shows up on the driver station
@TeleOp(name="TeleOp")
public class DubbleBubbleTeleOp extends OpMode
{
    // note that MANY examples on the Internet will use e.g. "DcMotor", which is
    // the FTC SDK motor -- but we us FTCLib's "Motor" class, see:
    // https://docs.ftclib.org/ftclib/features/hardware/motors

    public Motor left_motor;
    public GamepadEx driver;
    public int loops = 0;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        // the "hardwareMap" comes from our "base class", OpMode
        left_motor = new Motor(hardwareMap, "left");

        // similarly we use FTCLib's GamepadEx, see:
        // https://docs.ftclib.org/ftclib/features/gamepad-extensions
        // the "gamepad1" variable comes from our OpMode base class
        driver = new GamepadEx(gamepad1);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }


    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit START
     * (on Trident, we used this in Auto to set options up, for example)
     * (on Dubble Bubble we said what game-element position was detected)
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits START
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits START but before they hit STOP
     *
     * When forums talk about "FPS" or "frames per second", they mean how many
     * times per second this loop() functions runs. It is called by the FTC SDK code
     * running on the robot.
     *
     * In some tutorials you might see "sleep()" calls; you can't do that here
     */
    @Override
    public void loop() {
        // Setup a variable for motor power
        double left_power = 0.0;

        // first exercise: hook up "driver" (our gamepad) to the motor
        // power. For example, make moving the right joystick up or down
        // set the motor power.

        // motor power may only be from -1.0 up to 1.0, so we check first
        if (left_power < -1.0) {
            left_power = -1.0;
        } else if (left_power > 1.0) {
            left_power = 1.0;
        }

        // once per loop, we set the powers of our motors -- so the faster
        // this loop runs, the more quickly we will change the motor power
        // to match what the driver is doing to their controls
        loops += 1;
        left_motor.set(left_power);
        telemetry.addData("message", "Hello, world!");
        telemetry.addData("loops", loops);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
