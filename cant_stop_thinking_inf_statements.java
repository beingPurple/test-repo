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
<<<<<<< HEAD
        if((-0.3<x<0 && 0<x<0.3)&&(y >= 0.3)){
=======
        if((-0.3<x && x<0.3)&&(y >= 0.3)){
>>>>>>> aa13aa1c7d12be88b24e43721023dba98a2f44b5
        //move forward
        }

//backward
<<<<<<< HEAD
        if((-0.3<x<0 && 0<x<0.3)&&(y <= -0.3)){
=======
        if((-0.3<x && x<0.3)&&(y <= -0.3)){
>>>>>>> aa13aa1c7d12be88b24e43721023dba98a2f44b5
        //move backward
        }

//strafe left
<<<<<<< HEAD
        if(( x <= -0.3)&&( -0.3 <y<0 && 0<y< 0.3 )){
        //move left
        }
//strafe right
        if(( x >= 0.3 )&&( -0.3 <y<0 && 0<y< 0.3 )){
=======
        if(( x <= -0.3)&&(-0.3 < y && y < 0.3)){
        //move left
        }
//strafe right
        if(( x >= 0.3 )&&(-0.3 < y && y < 0.3)){
>>>>>>> aa13aa1c7d12be88b24e43721023dba98a2f44b5
        //move right
        }

//brakes
<<<<<<< HEAD
        if( x==0 && y==0){
=======
        if( (-0.3<x && x<0.3) && (-0.3 < y ** y < 0.3))){
>>>>>>> aa13aa1c7d12be88b24e43721023dba98a2f44b5
        //stop
        }