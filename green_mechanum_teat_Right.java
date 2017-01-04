package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
// they don't move too far)

/**
* Created by Noelle on 11/19/2015.
*/
public class green_mechanum_Right extends OpMode { //make sure that you remember to extend OpMode!

    DcMotor LF;
    DcMotor RF;
    DcMotor LB;
    DcMotor RB;


    public void init() {

       LF = hardwareMap.dcMotor.get("motor_1");

    }

    public void loop() {

//________________________USING JOYSTICKS___________________________________________________

        double LeftF = 0;
        double RightF = 0;
        double LeftB = 0;
        double RightB = 0;
        double speed = .5;

        //speed is average of abs. value of x and y values
        //speed = Math.abs(gamepad1.left_stick_x) + Math.abs(gamepad1.left_stick_y);

        //forward(top left corner)
        if ((gamepad1.left_stick_x <= 0) && (gamepad1.left_stick_y <= 0)) {
            LeftF = -speed;
            RightF = speed;
            LeftB = -speed;
            RightB = speed;
        }



        LF.setPower(LeftF);
        RF.setPower(RightF);
        LB.setPower(LeftB);
        RB.setPower(RightB);

    }
}
