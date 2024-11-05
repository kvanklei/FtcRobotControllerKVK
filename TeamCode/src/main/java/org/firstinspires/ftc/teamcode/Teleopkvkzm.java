package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Teleopkvkzm extends LinearOpMode {

    @Override
    public void runOpMode() {
        //defining motors
        DcMotor bl = hardwareMap.get(DcMotor.class, "bl");
        DcMotor br = hardwareMap.get(DcMotor.class, "br");
        DcMotor arm = hardwareMap.get(DcMotor.class, "arm");


      //   bl.setDirection(DcMotorSimple.Direction.REVERSE);
     //    br.setDirection(DcMotorSimple.Direction.REVERSE);
        // positions for arm
        int p1 = 0;
        int p2 = -700;
        int p3 = -1400;
        int p4 = -2100;

        //resetting encoder back to 0
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        waitForStart();
        while (opModeIsActive()) {
            // getting values from joysticks
            double y = -gamepad1.left_stick_y;
            double x= gamepad1.right_stick_x;
            // powering motors
            bl.setPower(y + x);
            br.setPower(y - x);

            // putting arm into different positions according to pressed button
            if (gamepad1.a) {
                arm.setTargetPosition(p1);
                arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                arm.setPower(1);
            } else if (gamepad1.b) {
                arm.setTargetPosition(p2);
                arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                arm.setPower(1);
            } else if (gamepad1.x) {
                arm.setTargetPosition(p3);
                arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                arm.setPower(1);
            } else if (gamepad1.y) {
                arm.setTargetPosition(p4);
                arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                arm.setPower(1);
            }else {
                arm.setPower(0);
            }

        }
    }


}