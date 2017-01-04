package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Jasmine on 1/4/17.
 */

public class OmnisWheels extends OpMode{

    DcMotor LF;
    DcMotor RF;
    DcMotor LB;
    DcMotor RB;

    public void loop(){
        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;

        double LeftF;
        double RightF;
        double LeftB;
        double RightB;

        double move;
        double speed = .5;

        if (x>=0&&y<=0){
            LeftF=speed;
            RightF=-speed;
            LeftB=speed;
            RightB=-speed;
        }
        LF.setPower(LeftF);
        RF.setPower(RightF);
        LB.setPower(LeftB);
        RB.setPower(RightB);


    }

}
