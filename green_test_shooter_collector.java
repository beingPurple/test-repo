package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by ppg02 on 12/13/2016.
 */


//a compiled code built for testing. This iteration tests out shooter and collector code.

@TeleOp(name="Green Test", group="Green")//register the code so that you can see it in the app
@Disabled //prevents this code from making errors when being put onto phone

public class green_test_shooter_collector extends OpMode {

    final static double SPEED = .5; //this must be between -1 and 1!
    final static double STOP = 0;

    //establish motors
    DcMotor collectUp;
    DcMotor collectDown;

    DcMotor Shooter;

    public void init(){
        //hardware mapping
        collectUp = hardwareMap.dcMotor.get("co up");
        collectDown = hardwareMap.dcMotor.get("co do"); //don't forget the semicolon(;)!

        Shooter = hardwareMap.dcMotor.get("shoot");
    }
    public void loop(){
        if (gamepad2.a == true) {//as long as the a button is pressed...
            collectDown.setPower(SPEED);
            collectUp.setPower(SPEED);
            //spin the collector motors
        }
        if (gamepad2.a == false) {//as long as the a button is pressed...
            collectDown.setPower(STOP);
            collectUp.setPower(STOP);
            //spin the collector motors
        }

        if (gamepad2.b == true) {//if b is pressed...
            Shooter.setPower(SPEED);
            //spin shooter motors
        }
        if (gamepad2.b == false) {//if b is pressed...
            Shooter.setPower(STOP);
            //spin shooter motors
        }
    }
}
