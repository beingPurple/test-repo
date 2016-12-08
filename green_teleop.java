package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;//this allows you to use motors
import com.qualcomm.robotcore.hardware.Servo;//this allows you to use servos should you need them
import com.qualcomm.robotcore.util.Range;//this allows you to establish a range for the motors(so
import com.qualcomm.robotcore.eventloop.opmode.OpMode;//this allows you to use opmodes



/**
 * Created by Noelle the Amazing on 12/8/2016.
 */

@TeleOp(name="Green TeleOp", group="Green")//register the code so that you can see it in the app

public class green_teleop extends OpMode {
    //make sure that you remember to extend OpMode!

    //here is where you set things like limits. To do so, follow this:
    final static double Lift45 = 1.2;
    final static double lift90 = 160;
    final static double LiftFloor = 43;
    final static double LFOpen = 22;
    final static double RFOpen = 21;
    final static double LFClose = 11;
    final static double RFClose = 3.14;


//here is where you tell the robot what motors it has. to do so, follow this:

    DcMotor RightM;
    DcMotor LeftM;
//this works for things like servos too, just replae DcMotor with whatever device goes by the
// assigned name

    Servo leftFlap;
    Servo rightFlap;
    Servo lift;
    Servo lift2;

    public void init() {//this is the setup period, where the robot prepares itself to start playing

//here is where you will tell the robot which motor is which(they correspond to specific
// ports) Follow this:

        RightM = hardwareMap.dcMotor.get("motor_1");
        LeftM = hardwareMap.dcMotor.get("motor_2"); //don't forget the semicolon(;)!
        leftFlap = hardwareMap.servo.get("left_flap");
        rightFlap = hardwareMap.servo.get("right_flap");
        lift= hardwareMap.servo.get("lift");
        lift2 = hardwareMap.servo.get("lift");

//when establishing motors like wheels, remember to reverse a motor. Follow this:
        LeftM.setDirection(DcMotor.Direction.REVERSE);

        lift.setPosition(lift90);//set any positions you need at the start of the match
    }

    public void loop() {
        lift.setPosition(Lift45);
//________________________USING JOYSTICKS___________________________________________________
//here, you tell the phone what each joystick button means.
//For example, to say that the left joystick controlls a specific motor, follow this:

        float left = gamepad1.left_stick_y;
/*
Wonder why there is a negative sign before gamepad1?
This is beause when you push the joystick all the way forward,
the value that the remote sends is -1.
Weird, right?

The motors will operate from -1 to 1, 1 being forward.(see the range.clip section below)

If you send the joystick data directly to the motors, they'll move backwards
when you press the joystick all the way instead of forward, which is what you would expect.

This way, it avoids all sorts of cunfusion! (*^▽^*)
*/

//to assign, the right joystick, replace left with right, like this:
        float right = gamepad1.right_stick_y;
//just replace "left" with "right"!

//We need to assign a cutoff point so that the motors don't overextend themselves. Like so:
        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);

//You have the option to scale down the joystick value so that, when we use the robot, it
// won't rush in its direction too quickly. To use this, make sure that you have the section
// down at the bottom, uncomment the following lines of code, and edit it to how you need.

//It's not necessary though!

//RightM = (float)scaleInput(right);
//LeftM = (float)scaleInput(left);


//here is where the phone actually tells the motors to move. Follow this:
        RightM.setPower(right);
        LeftM.setPower(left);
//__________________________________________________________________________________________


//______________________________USING BUTTONS_______________________________________________
boolean i = true;//for the sake of organization, it might help to put iny vatrs used in just this
                 //section here.

//Say you want the robot to do something when the a button is pressed. Do this:
        if (gamepad2.dpad_down){
//put whatever you want the robot to do in here. For example, I put one of the motors to
// a neutral position.
            lift.setPosition(LiftFloor);
        }

        if(gamepad2.dpad_up) {
            lift.setPosition(Lift45);
            lift2.setPosition(Lift45);
        }

        if (gamepad2.left_bumper) {
            if ( i == true){
                leftFlap.setPosition(LFOpen);
                rightFlap.setPosition(RFOpen);
                i = false;
            }
        }

        if (gamepad2.right_bumper) {
            if ( i == false){
                leftFlap.setPosition(LFClose);
                rightFlap.setPosition(RFClose);
                i = true;
            }
        }

//If you wanna use other buttons, replace "a" with whatever button you would like to use.

//__________________________________________________________________________________________
    }

/*
* This method scales the joystick input so for low joystick values, the
* scaled value is less than linear.  This is to make it easier to drive
* the robot more precisely at slower speeds.
*/

//Remember the scale input section from before?
// Uncomment the following bit(delete only the /* and */)...

/*double scaleInput(double dVal)  {
double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

// get the corresponding index for the scaleInput array.
int index = (int) (dVal * 16.0);

// index should be positive.
if (index < 0) {
index = -index;
}

// index cannot exceed size of array minus 1.
if (index > 16) {
index = 16;
}

// get value from the array.
double dScale = 0.0;
if (dVal < 0) {
dScale = -scaleArray[index];
} else {
dScale = scaleArray[index];
}

// return scaled value.
return dScale;
}*/
}
