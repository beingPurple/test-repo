<<<<<<< HEAD
package org.firstinspires.ftc.teamcode.Code;

=======
//package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
>>>>>>> 64de4dee387187d28d889be0f5e1e9a380040880
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


/**
 * Created by plankton_J on 1/23/17.
 */
<<<<<<< HEAD

public class Grewn_Wheels extends OpMode {
=======
@Disabled

public class Grewn_Wheels extends OpMode {

>>>>>>> 64de4dee387187d28d889be0f5e1e9a380040880
    DcMotor LF;
    DcMotor RF;
    DcMotor LB;
    DcMotor RB;
    double LeftF = 0;
    double RightF = 0;
    double LeftB = 0;
    double RightB = 0;
    double speed = .5;

<<<<<<< HEAD


    double x = gamepad1.left_stick_x;
    double y = gamepad1.left_stick_y;
   //NE:
    if( x> 0.3 && y >0){
        x = speed;
        y = speed;
        // move
    }
    //SE
    if(x>0.3 && y<0){
        x= speed;
        y = -speed;
    }
    //SW
    if(x<-0.3 && y <0){
        x=-speed;
        y=-speed;

    }
    //NW
    if(x<-0.3 && y>0){
        x=-speed;
        y= speed;

    }




=======
    public void init() {

    }

    public void loop() {

        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;
        //NE:
        if (x > 0.3 && y > 0) {
            x = speed;
            y = speed;
            // move
        }
        //SE
        if (x > 0.3 && y < 0) {
            x = speed;
            y = -speed;
        }
        //SW
        if (x < -0.3 && y < 0) {
            x = -speed;
            y = -speed;

        }
        //NW
        if (x < -0.3 && y > 0) {
            x = -speed;
            y = speed;

        }


    }
>>>>>>> 64de4dee387187d28d889be0f5e1e9a380040880
}


