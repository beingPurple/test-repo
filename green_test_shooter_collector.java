package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by ppg02 on 12/13/2016.
 */


//a compiled code built for testing. This iteration tests out shooter and collector code.

@TeleOp(name="Green Test", group="Green")//register the code so that you can see it in the app

public class green_test_shooter_collector extends OpMode {

    final static double SPEED = 0; //this must be between -1 and 1!

    //establish motors
    DcMotor collectRight;
    DcMotor collectLeft;

    DcMotor ShooterLeft;
    DcMotor ShooterRight;

    public void init(){
        //hardware mapping
        collectRight = hardwareMap.dcMotor.get("collect left");
        collectLeft = hardwareMap.dcMotor.get("collect right"); //don't forget the semicolon(;)!
    }
    public void loop(){
        if (gamepad2.a) {//as long as the a button is pressed...
            collectLeft.setPower(SPEED);
            collectRight.setPower(SPEED);
            //spin the collector motors
        }

        if (gamepad2.b) {//if b is pressed...
            ShooterLeft.setPower(SPEED);
            ShooterRight.setPower(SPEED);
            //spin shooter motors
        }
    }
}
