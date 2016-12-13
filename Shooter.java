
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


public class Shooter extends OpMode {

    final static double SPEED = 0.75; //must be between -1 and 1

    DcMotor ShooterLeft;
    DcMotor ShooterRight;

    public void init() {

        ShooterLeft = hardwareMap.dcMotor.get("shoot left");
        ShooterRight = hardwareMap.dcMotor.get("shoot right");

        ShooterRight.setDirection(DcMotor.Direction.REVERSE);
    }

    public void() {

        if (gamepad2.b) {
            ShooterLeft.setPower(SPEED);
            ShooterRight.setPower(-SPEED);
        }
    }
}

