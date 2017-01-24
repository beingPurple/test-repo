package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
// they don't move too far)

/**
 * Created by Noelle on 11/19/2015.
 */


//register the code so that you can see it in the app
@TeleOp(name = "Green TeleOp Mechanum", group = "Green")

public class green_mechanum_tele extends OpMode { //make sure that you remember to extend OpMode!

    //<editor-fold desc="motors used">
    DcMotor LF;
    DcMotor RF;
    DcMotor LB;
    DcMotor RB;

    //establish motors
    DcMotor collectUp;


    DcMotor shooter1;
    DcMotor shooter2;
    //</editor-fold>

    //<editor-fold desc="variables used">
    final static double STOP = 0;
    public double LeftF = 0;
    public double RightF = 0;
    public double LeftB = 0;
    public double RightB = 0;
    public double speed = .5;
    public double colu = 0;
    public double shoot1 = 0;
    public double shoot2 = 0;
    public double collectingspeed = 1.5;
    //</editor-fold>

    //<editor-fold desc="'x' is x axis, 'y' is y axis, both on left joystick of gamepad 1">
    double x = gamepad1.left_stick_x;
    double y = gamepad1.left_stick_y;
    //</editor-fold>

    public void init() {

        //<editor-fold desc="hardware mapping all motors">
        RF = hardwareMap.dcMotor.get("rf");
        LF = hardwareMap.dcMotor.get("lf");
        LB = hardwareMap.dcMotor.get("lb");
        RB = hardwareMap.dcMotor.get("rb");



        collectUp = hardwareMap.dcMotor.get("co up");


        shooter1 = hardwareMap.dcMotor.get("shooter1");
        shooter2 = hardwareMap.dcMotor.get("shooter2");
        //</editor-fold>

        //<editor-fold desc="clip joystick range to -1 and 1">
        x = Range.clip(x, -1, 1);
        y = Range.clip(y, -1, 1);
        //</editor-fold>
    }

    public void loop() {
        //speed is average of abs. value of x and y values
        //speed = Math.abs(x) + Math.abs(y);

        //<editor-fold desc="reverse wheels so that posetive is to the front">
        //reverses wheels so that everything is in the same direction
        LF.setDirection(DcMotor.Direction.REVERSE);
        RF.setDirection(DcMotor.Direction.REVERSE);
        //</editor-fold>

        //<editor-fold desc="8 directions. currently in testing">
        //forward
        if ((-0.3 < x && x < 0.3) && (y >= 0.3)) {
            //move forward
            LeftF = speed;
            LeftB = speed;
            RightF = speed;
            RightB = speed;
        }

        //backward
        if ((-0.3 < x && x< 0.3) && (y <= -0.3)) {
            //move backward
            LeftF = -speed;
            LeftB = -speed;
            RightF = -speed;
            RightB = -speed;
        }

        //strafe left
        if ((x <= -0.3) && (-0.3 < y && y< 0.3)) {
            //move left
            LeftF = speed;
            LeftB = -speed;
            RightF = -speed;
            RightB = speed;
        }
        //strafe right
        if ((x >= 0.3) && (-0.3 < y && y < 0.3)) {
            //move right
            LeftF = -speed;
            LeftB = speed;
            RightF = speed;
            RightB = -speed;
        }

        //brakes
        if ((-0.3 < x && x < 0.3) && (-0.3 < y && y < 0.3)) {
            //stop
            LeftF = STOP;
            LeftB = STOP;
            RightF = STOP;
            RightB = STOP;
        }
        //8 directions------------------------------------------------------------------------------
        //</editor-fold>

        //<editor-fold desc="old directional code. May be useful, but is commented out">
        /*
        //forward(top left corner)
        if ((x < 0) && (y < 0)) {
            LeftF = speed;
            RightF = -speed;
            LeftB = speed;
            RightB = -speed;

        }

        //left
<<<<<<< HEAD
        else if (x >= 0 && y>=0) {
=======
        else if (x > 0 && y>0) {
>>>>>>> aa13aa1c7d12be88b24e43721023dba98a2f44b5
            LeftF = -speed;
            RightF = -speed;
            LeftB = speed;
            RightB = speed;
        }

        //right
<<<<<<< HEAD
        else if(x<=0 && y<=0){
=======
        else if(x<0 && y<0){
>>>>>>> aa13aa1c7d12be88b24e43721023dba98a2f44b5
            LeftF = speed;
            RightF = speed;
            LeftB = -speed;
            RightB = -speed;
        }

        //back
<<<<<<< HEAD
        else if ( x>=0 && y<=0){
=======
        else if ( x>0 && y<0){
>>>>>>> aa13aa1c7d12be88b24e43721023dba98a2f44b5
            LeftF=speed;
            RightF=-speed;
            LeftB=speed;
            RightB=-speed;
        }
        else if ( x == 0 &&  y == 0){
            LeftF=STOP;
            RightF=STOP;
            LeftB=STOP;
            RightB=STOP;
        }
        */
        //</editor-fold>

        //<editor-fold desc="bumpers. THESE WORK, DO NOT CHANGE">
        //set bumpers to turn the robot. THESE WORK, DO NOT CHANGE----------------------------------
        if (gamepad1.left_bumper) {//turn left
            LeftF = speed;
            RightF = speed;
            LeftB = speed;
            RightB = speed;

        }

<<<<<<< HEAD
        if (gamepad2.a == true) {//as long as the a button is pressed...
            cold = speed;

            colu = speed;
            //spin the collector motors
=======
        if (gamepad1.right_bumper) {//turn right
            LeftF = -speed;
            RightF = -speed;
            LeftB = -speed;
            RightB = -speed;

>>>>>>> aa13aa1c7d12be88b24e43721023dba98a2f44b5
        }
        //end bumpers-------------------------------------------------------------------------------
        //</editor-fold>

        //<editor-fold desc="collector. Still testing.">
        //collector---------------------------------------------------------------------------------
//code in testing. this area not tested yet. an equal mark was deleted from inside each function
        if (gamepad2.a) {//as long as the a button is pressed...
            colu = collectingspeed;
            //spin the collector motors
        }
        // if (gamepad2.a) {//as long as the a button is pressed...
        //colu = STOP;
        ////spin the collector motors


        if (gamepad2.b) {//if b is pressed...
            shoot1 = speed;
            shoot2 = -speed;
            //spin shooter motors
        }
        if (gamepad2.b) {//if b is pressed...
            shoot1 = STOP;
            shoot2 = STOP;

            //spin shooter motors
        }
        //end collector-----------------------------------------------------------------------------
        //</editor-fold>

        //<editor-fold desc="set the motors to the appropriate and corresponding power">
        LF.setPower(LeftF);
        RF.setPower(RightF);
        LB.setPower(LeftB);
        RB.setPower(RightB);
        collectUp.setPower(colu);
        shooter1.setPower(shoot1);
        shooter2.setPower(shoot2);
        //</editor-fold>

        //<editor-fold desc="debugging using telemetry">
        telemetry.addData("left front", LeftF);
        telemetry.addData("right front", RightF);
        telemetry.addData("left back", LeftB);
        telemetry.addData("right back", RightB);
        telemetry.addData("collect", colu);
        telemetry.addData("x value", x);
        telemetry.addData("y value", y);
        telemetry.addData("collect", colu);
        telemetry.addData("shooter1", shoot1);
        telemetry.addData("shooter2", shoot2);
        //</editor-fold>


    }
}
