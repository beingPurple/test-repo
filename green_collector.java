package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Noelle on 11/19/2015.
 */

@Disabled //prevents this code from giving errors when putting onto phone

public class green_collector extends OpMode {

    final static double SPEED = 0; //this must be between -1 and 1!

    DcMotor collectRight;
    DcMotor collectLeft;

    public void init() {
        collectRight = hardwareMap.dcMotor.get("collect left");
        collectLeft = hardwareMap.dcMotor.get("collect right"); //don't forget the semicolon(;)!
    }

    public void loop() {
        if (gamepad2.a) {//as long as the a button is pressed...
            collectLeft.setPower(SPEED);
            collectRight.setPower(SPEED);
            //spin the collector motors
        }
    }
}
//ヽ〳 ՞ ᗜ ՞ 〵ง so easy!