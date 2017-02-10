package org.firstinspires.ftc.teamcode.Code;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Joanna and Gemma on 1/24/17.
 */
//recent
@TeleOp (name = "Green Shooter and Collector", group ="Green")

public class ShooterAndCollecting extends OpMode {
    DcMotor shooter;

    DcMotor collect;

    private double speedcol = -2.0;
    private double speedshoot = 0.6;
    private double col = 0;
    private double shooting = 0;


    public void init() {

        shooter = hardwareMap.dcMotor.get("sho");

        collect = hardwareMap.dcMotor.get("co up");
        telemetry.addData("Get started!", 6);
    }

    public void loop() {
        telemetry.addData("Start the game", 4);

        //code for collecting (press button x):
        //if(gamepad1.x){
        if (gamepad2.x) {
            col = speedcol;
            telemetry.addData("collecting", col);
            collect.setPower(col);
        } else {
            col = 0;
            collect.setPower(col);
        }


        //code for shooters(press botton y)
        // if(gamepad1.y){
        if (gamepad2.y) {
            shooting = speedshoot;
            telemetry.addData("Shooter", shooting);
            shooter.setPower(shooting);
        } else {
            shooting = 0;
            shooter.setPower(shooting);


        }
    }
}

