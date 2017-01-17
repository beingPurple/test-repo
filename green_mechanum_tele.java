package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
// they don't move too far)

/**
 * Created by Noelle on 11/19/2015.
 */

@TeleOp(name="Green TeleOp Mechanum", group="Green")//register the code so that you can see it in the app

public class green_mechanum_tele extends OpMode { //make sure that you remember to extend OpMode!

    DcMotor LF;
    DcMotor RF;
    DcMotor LB;
    DcMotor RB;

    //establish motors
    DcMotor collectUp;


    DcMotor Shooter;

    final static double STOP = 0;

    public void init() {

        RF = hardwareMap.dcMotor.get("rf");
        LF = hardwareMap.dcMotor.get("lf");
        LB = hardwareMap.dcMotor.get("lb");
        RB = hardwareMap.dcMotor.get("rb");


        collectUp = hardwareMap.dcMotor.get("co up");


        Shooter = hardwareMap.dcMotor.get("shoot");
    }

    public void loop() {

//________________________USING JOYSTICKS___________________________________________________

        double LeftF = 0;
        double RightF = 0;
        double LeftB = 0;
        double RightB = 0;
        double speed = .5;
        double colu = 0;
        double shoot = 0;

        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;

        //speed is average of abs. value of x and y values
        //speed = Math.abs(x) + Math.abs(y);

        //forward(top left corner)
        if ((x <= 0) && (y <= 0)) {
            LeftF = -speed;
            RightF = speed;
            LeftB = -speed;
            RightB = speed;

        }

        //left
        else if (x >= 0 && y>=0) {
            LeftF = -speed;
            RightF = -speed;
            LeftB = speed;
            RightB = speed;
        }

        //right
        else if(x<=0 && y<=0){
            LeftF = speed;
            RightF = speed;
            LeftB = -speed;
            RightB = -speed;
        }

        //back
        else if ( x>=0 && y<=0){
            LeftF=speed;
            RightF=-speed;
            LeftB=speed;
            RightB=-speed;
        }

        //set bumpers to turn the robot
//code in testing, not tested yet. likely needs  a boolean added to bumber pieces
        if(gamepad1.left_bumper){//turn left
            LeftF=speed;
            RightF=speed;
            LeftB=speed;
            RightB=speed;

        }

        else if(gamepad1.right_bumper){//turn right
            LeftF=-speed;
            RightF=-speed;
            LeftB=-speed;
            RightB=-speed;

        }
//code in testing. this area not tested yet. an equal mark was deleted from inside each function
        if (gamepad2.a = true) {//as long as the a button is pressed...
            colu = speed;
            //spin the collector motors
        }
        else if (gamepad2.a = false) {//as long as the a button is pressed...
            colu = STOP;
            //spin the collector motors
        }

        else if (gamepad2.b = true) {//if b is pressed...
            shoot = speed;
            //spin shooter motors
        }
        else if (gamepad2.b = false) {//if b is pressed...
           shoot = STOP;
            //spin shooter motors
        }


        LF.setPower(LeftF);
        RF.setPower(RightF);
        LB.setPower(LeftB);
        RB.setPower(RightB);

        telemetry.addData("left front", LeftF);
        telemetry.addData("right front",RightF);
        telemetry.addData("left back",LeftB);
        telemetry.addData("right back", RightB);

        collectUp.setPower(colu);
        Shooter.setPower(shoot);

    }
}
