package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * Created by ppg02 on 1/23/2017.
 */

/*this list inclused 4 of the 8 principal directions our robotuses to drive

Directions incllude: forward, backwars, (strafe) left, (strafe) right

it will be in psudocode, partially, as the specific directions for the motors will not be listed in
this specific document

*/

double x=gamepad1.left_stick_x;
        double y=gamepad1.left_stick_y;

//forward
        if((-0.3<x<0.3)&&(y>0)){
        //move forward
        }

//backward
        if((-0.3<x<0.3)&&(y<0)){
        //move backward
        }

//strafe left
        if(( x < 0)&&( -0.3 < y < 0.3 )){
        //move left
        }
//strafe right
        if(( x > 0)&&( -0.3 < y < 0.3 )){
        //move right
        }