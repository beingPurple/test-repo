package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by ppg02 on 1/23/2017.
 */

/*this list inclused 4 of the 8 principal directions our robotuses to drive

Directions incllude: forward, backwars, (strafe) left, (strafe) right

it will be in psudocode, partially, as the specific directions for the motors will not be listed in
this specific document

*/
@Disabled //prevents this code from giving errors when being put onto phone

public class cant_stop_thinkin_if_statements extends OpMode {
    double x = gamepad1.left_stick_x;
    double y = gamepad1.left_stick_y;

    public void init() {

    }

    public void loop() {
//forward
        if ((-0.3 < x && x < 0.3) && (y >= 0.3))

        {
            //move forward
        }

//backward
        if ((-0.3 < x && x < 0.3) && (y <= -0.3))

        {
            //move backward
        }

//strafe left
        if ((x <= -0.3) && (-0.3 < y && y < 0.3))

        {
            //move left
        }
//strafe right
        if ((x >= 0.3) && (-0.3 < y && y < 0.3))

        {
            //move right
        }

//brakes
        if ((-0.3 < x && x < 0.3) && (-0.3 < y && y < 0.3))

        {
            //stop
        }
    }
}