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
    public DcMotor LF;
    public DcMotor RF;
    public DcMotor LB;
    public DcMotor RB;

    DcMotor collectUp;

    DcMotor shooter1;
   // DcMotor shooter2;
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
    //public double shoot2 = 0;
    public double collectingspeed = .5;

    double x = 0;
    double y = 0;
    //</editor-fold>

    public void init() {
        telemetry.addLine("starting init");
        //<editor-fold desc="hardware mapping all motors">
        RF = hardwareMap.dcMotor.get("rf");
        telemetry.addLine("rf done");

        LF = hardwareMap.dcMotor.get("lf");
        telemetry.addLine("lf done");

        LB = hardwareMap.dcMotor.get("lb");
        telemetry.addLine("lb done");

        RB = hardwareMap.dcMotor.get("rb");
        telemetry.addLine("rb done");

        collectUp = hardwareMap.dcMotor.get("co up");
        telemetry.addLine("collector done");

        shooter1 = hardwareMap.dcMotor.get("sho");
        telemetry.addLine("shooter 1 done");

        //shooter2 = hardwareMap.dcMotor.get("shooter2");
        //</editor-fold>
        telemetry.addLine("motors initialized");
    }

    public void loop() {
        telemetry.addLine("starting loop");
        //speed is average of abs. value of x and y values
        //speed = Math.abs(x) + Math.abs(y);

        //<editor-fold desc="'x' is x axis, 'y' is y axis, both on left joystick of gamepad 1">
        x = gamepad1.left_stick_x;
        y = gamepad1.left_stick_y;
        //</editor-fold>

        //<editor-fold desc="clip joystick range to -1 and 1">
        x = Range.clip(x, -1, 1);
        y = Range.clip(y, -1, 1);
        //</editor-fold>

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
            LeftB = -speed;
            RightF = speed;
            RightB = speed;
        }

        //backward
        if ((-0.3 < x && x< 0.3) && (y <= -0.3)) {
            //move backward
            LeftF = -speed;
            LeftB = speed;
            RightF = -speed;
            RightB = -speed;
        }

        //strafe left
        if ((x <= -0.3) && (-0.3 < y && y< 0.3)) {
            //move left
            LeftF = speed;
            LeftB = speed;
            RightF = -speed;
            RightB = speed;
        }
        //strafe right
        if ((x >= 0.3) && (-0.3 < y && y < 0.3)) {
            //move right
            LeftF = -speed;
            LeftB = -speed;
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

        //NE
        if( x> 0.3 && y >0){
            LeftF = speed;
            LeftB = STOP;
            RightF = STOP;
            RightB = speed;
        }
        //SE
        if(x>0.3 && y<0){
            LeftF = STOP;
            LeftB = speed;
            RightF = speed;
            RightB = STOP;
        }
        //SW
        if(x<-0.3 && y <0){
            LeftF = -speed;
            LeftB = STOP;
            RightF = STOP;
            RightB = -speed;
        }
        //NW
        if(x<-0.3 && y>0){
            LeftF = STOP;
            LeftB = -speed;
            RightF = -speed;
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
        else if (x > 0 && y>0) {
            LeftF = -speed;
            RightF = -speed;
            LeftB = speed;
            RightB = speed;
        }

        //right
        else if(x<0 && y<0){
            LeftF = speed;
            RightF = speed;
            LeftB = -speed;
            RightB = -speed;
        }

        //back
        else if ( x>0 && y<0){
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

        if (gamepad1.right_bumper) {//turn right
            LeftF = -speed;
            RightF = -speed;
            LeftB = -speed;
            RightB = -speed;

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
            //shoot2 = -speed;
            //spin shooter motors
        }
        if (gamepad2.b) {//if b is pressed...
            shoot1 = STOP;
            //shoot2 = STOP;

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
        //shooter2.setPower(shoot2);
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
        //telemetry.addData("shooter2", shoot2);
        //</editor-fold>


    }
}
