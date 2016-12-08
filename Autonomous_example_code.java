import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Noelle on 12/9/2015.
 */
public class Autonomous_example_code extends OpMode {

    //here are some pre-designated speeds that will be used in this example.
    //Creep moves slow. run movemoves fast. stop doesn't move. Self explanatory.
    final static double CREEP = .15;
    final static double RUN = .5;
    final static double STOP = 0;

    //setting components like motors and such...
    DcMotor example;



    public void init(){
        //hardware mapping...
        example = hardwareMap.dcMotor.get("motor_1");
    }

    public void loop(){

        //the variables that will set the speed
        double speed = 0;

        //in this example, we're just gonna make the motor move slow, then fast, then slow.
        if (this.time <= 1) { //from start to 1 second...
            speed = CREEP; //creep
        }
        if (this.time > 1 &&  this.time < 4){ //from 1 second to 4 seconds...
            speed = RUN;
        }
        if (this.time >4 && this.time < 10) { //from 4 seconds to 10 seonds...
            speed = CREEP;
        }


        //set the power to whatever speed is.
        example.setPower(speed);


    }
}
/*

Please feel free to take this code and change anything to however you need to!

Another resource would be to look at K9AutoTime. It's not as
spelled out as this program, but it uses the exact same concepts, and what this program is
based off of!

The possibilities are endless! Good luck! (〜￣▽￣)〜

 */