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

    private double speedcol = -0.8;
    private double speedshoot = 1.0;
    private double col = 0;
    private double sh1 = 0;
    private double sh2 = 0;

    public void init() {

//        shoot1 = hardwareMap.dcMotor.get("sho");
//        shoot2 = hardwareMap.dcMotor.get("shooter2");
        collect = hardwareMap.dcMotor.get("co up");
        telemetry.addData("Get started!", 6);
    }

    public void loop() {
        telemetry.addData("Start the game", 4);

        //code for collecting (press button x):
        if (gamepad1.x) {
            col = speedcol;
            telemetry.addData("collecting", col);
            collect.setPower(col);
        } else {
            col = 0;
            collect.setPower(col);
        }


        //code for shooters(press botton y)
        if (gamepad1.y) {
            sh1 = speedshoot;
            sh2 = -speedshoot;
            shoot1.setPower(sh1);
            shoot2.setPower(sh2);
            telemetry.addData("Shooter1", sh1);
            telemetry.addData("Shooter2", sh2);
        } else {
            sh1 = 0;
            sh2 = 0;
            shoot1.setPower(sh1);
            shoot2.setPower(sh2);

        }
    }
}

