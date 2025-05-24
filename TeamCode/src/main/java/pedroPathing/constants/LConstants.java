package pedroPathing.constants;

import com.pedropathing.localization.*;
import com.pedropathing.localization.constants.*;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

public class LConstants {
    static {
        TwoWheelConstants.forwardTicksToInches = .003;
        TwoWheelConstants.strafeTicksToInches = .003;
        TwoWheelConstants.forwardY = 6.8125;
        TwoWheelConstants.strafeX = -0.109375;
        TwoWheelConstants.forwardEncoder_HardwareMapName = "suck";
        TwoWheelConstants.strafeEncoder_HardwareMapName = "par";
        TwoWheelConstants.forwardEncoderDirection = Encoder.REVERSE;
        TwoWheelConstants.strafeEncoderDirection = Encoder.FORWARD;
        TwoWheelConstants.IMU_HardwareMapName = "imu";
        TwoWheelConstants.IMU_Orientation = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.LEFT, RevHubOrientationOnRobot.UsbFacingDirection.UP);
    }
}