package org.firstinspires.ftc.teamcode.Code;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Joanna and Gemma on 1/24/17.
 */
@TeleOp (name = "Green Shooter and Collector", group ="Green")


public class ShooterAndCollecting extends OpMode {
    DcMotor shoot1;
    DcMotor shoot2;
    DcMotor collect;


    double speedcol =1.0;
    double speedshoot= 1.0;
    double col =0;
    double sh1=0;
    double sh2=0;



    public void init(){

        shoot1 = hardwareMap.dcMotor.get("star1");
        shoot2 = hardwareMap.dcMotor.get("star2");
        collect = hardwareMap.dcMotor.get("collow");
    }

    public void loop(){


        //the code for collecting (press botton a):
        if( gamepad1.a ){
            col= speedcol;

        }


        //the code for shooter(press botton b):
        if( gamepad1.b ){
            sh1= speedshoot;
            sh2= -speedshoot;
        }


        shoot1.setPower(sh1);
        shoot2.setPower(sh2);
        collect.setPower(col);

    }







}
