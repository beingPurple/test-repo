
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


public class Shooter extends OpMode {

    final static double SPEED = 0.75; //must be between -1 and 1

    DcMotor Shooter;

    public void init() {
        Shooter = hardwareMap.dcMotor.get("shooter");
    }

    public void() {

        if (gamepad2.b) {
            Shooter.setPower(SPEED);
        }
    }
}

