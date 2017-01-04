package org.firstinspires.ftc.teamcode.Code;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Joanna on 1/4/17.
 */

public class Omniswheels extends OpMode{
    double LF;
    double LB;
    double RF;
    double RB;
    double speed = 1.0 ;

    DcMotor LeftForward;
    DcMotor LeftBackward;
    DcMotor RightForward;
    DcMotor RightBackward;
    @Override
    public void init() {
        LeftForward = hardwareMap.dcMotor.get("motor_1");
        LeftBackward = hardwareMap.dcMotor.get("motor_2");
        RightForward = hardwareMap.dcMotor.get("motor_3");
        RightBackward = hardwareMap.dcMotor.get("motor_4");


    }

    @Override
    public void loop() {
        float x = gamepad1.left_stick_x;
        float y = gamepad1.left_stick_y;

        //left
        if (x >= 0 && y>=0) {
            LF = -speed;
            RF = -speed;
            LB = speed;
            RB = speed;

            LeftForward.setPower(LF);
            LeftBackward.setPower(LB);
            RightForward.setPower(RF);
            RightBackward.setPower(RB);




            //move forward
        }
        }
        //Backward:

    }
