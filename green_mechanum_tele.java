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

    DcMotor shooter;

    DcMotor collect;
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

    private double speedcol = -2.0;
    private double speedshoot = 0.6;
    private double col = 0;
    private double shooting = 0;

    double x = 0;
    double y = 0;
    //</editor-fold>

    public void init() {
        //<editor-fold desc="hardware mapping all motors">

        telemetry.addLine("starting init");
        RF = hardwareMap.dcMotor.get("rf");
        telemetry.addLine("rf done");

        LF = hardwareMap.dcMotor.get("lf");
        telemetry.addLine("lf done");

        LB = hardwareMap.dcMotor.get("lb");
        telemetry.addLine("lb done");

        RB = hardwareMap.dcMotor.get("rb");
        telemetry.addLine("rb done");

        shooter = hardwareMap.dcMotor.get("sho");

        collect = hardwareMap.dcMotor.get("co up");
        telemetry.addData("Get started!", 6);

        telemetry.addLine("motors initialized");

        //</editor-fold>
    }

    public void loop() {
        telemetry.addLine("starting loop");

        //<editor-fold desc="'x' is x axis, 'y' is y axis, both on left joystick of gamepad 1">
        x = gamepad1.left_stick_x;
        y = gamepad1.left_stick_y;
        //</editor-fold>

        //<editor-fold desc="clip joystick range to -1 and 1">
        x = Range.clip(x, -1, 1);
        y = Range.clip(y, -1, 1);
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
        if ((-0.3 < x && x < 0.3) && (y <= -0.3)) {
            //move backward
            LeftF = -speed;
            LeftB = speed;
            RightF = -speed;
            RightB = -speed;
        }

        //strafe left
        if ((x <= -0.3) && (-0.3 < y && y < 0.3)) {
            //move left
            LeftF = -speed;
            LeftB = -speed;
            RightF = speed;
            RightB = -speed;
        }
        //strafe right
        if ((x >= 0.3) && (-0.3 < y && y < 0.3)) {
            //move right
            LeftF = speed;
            LeftB = speed;
            RightF = -speed;
            RightB = speed;
        }
//Joanna and Gemma have fixed the first 4
        //brakes
        if ((-0.3 < x && x < 0.3) && (-0.3 < y && y < 0.3)) {
            //stop
            LeftF = STOP;
            LeftB = STOP;
            RightF = STOP;
            RightB = STOP;
        }

        //NE
        if (x > 0.3 && y > 0) {
            LeftF = -speed;
            LeftB = STOP;
            RightF = STOP;
            RightB = -speed;
        }
        //SE
        if (x > 0.3 && y < 0) {
            LeftF = STOP;
            LeftB = -speed;
            RightF = speed;
            RightB = STOP;
        }
        //SW
        if (x < -0.3 && y < 0) {
            LeftF = speed;
            LeftB = STOP;
            RightF = -STOP; //why is this not at stop...? I added a sign, even though it shouldn't do anything...
            RightB = speed;
        }
        //NW
        if (x < -0.3 && y > 0) {
            LeftF = STOP;
            LeftB = speed;
            RightF = -speed;
            RightB = STOP;
        }
        //8 directions------------------------------------------------------------------------------
        //</editor-fold>

        //<editor-fold desc="bumpers. THESE WORK, DO NOT CHANGE">
        //set bumpers to turn the robot. THESE WORK, DO NOT CHANGE----------------------------------
        if (gamepad1.left_bumper) {//turn left
            LeftF = speed;
            RightF = -speed;
            LeftB = -speed;
            RightB = -speed;

        }

        if (gamepad1.right_bumper) {//turn right
            LeftF = -speed;
            RightF = speed;
            LeftB = speed;
            RightB = speed;

        }
        //end bumpers-------------------------------------------------------------------------------
        //</editor-fold>

        //<editor-fold desc="shooter and collector">
        //code for collecting (press button x):
        if (gamepad2.x) {
            col = speedcol;
            telemetry.addData("collecting", col);
            collect.setPower(col);
        } else {
            col = 0;
            collect.setPower(col);
        }

        //code for shooter(press botton y)
        if (gamepad2.y) {
            shooting = speedshoot;
            telemetry.addData("Shooter", shooting);
            shooter.setPower(shooting);
        } else {
            shooting = 0;
            shooter.setPower(shooting);
        }
        //</editor-fold>

        //<editor-fold desc="set the motors to the appropriate and corresponding power">
        LF.setPower(LeftF);
        RF.setPower(RightF);
        LB.setPower(LeftB);
        RB.setPower(RightB);
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
