/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.commands.TankDriveWithJoystick;




/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  private WPI_TalonSRX frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor;

	// private CANTalon t1, t2;
//	private Solenoid singleSolenoid;
	

//	boolean winchForward = false;
//	boolean winchReverse = false;

	long startTime = 0;

	private DifferentialDrive drive;
//	private CANTalon winch;
//	private CANTalon pusher;

	public DriveTrain() {
		super();

	
			frontLeftMotor = new WPI_TalonSRX(0);
			frontRightMotor = new WPI_TalonSRX(3);
			

		
		
		drive = new DifferentialDrive(frontRightMotor, frontLeftMotor);

//		winch = new CANTalon(5);
//		pusher = new CANTalon(6);
		// Let's show everything on the LiveWindow

	
	}





	/**
	 * When no other command is running let the operator drive around using the
	 * PS3 joystick.
	 */
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoystick());
//		setDefaultCommand(new WinchForward());
//    	setDefaultCommand(new WinchReverse());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
	}

	public void drive(double left, double right) {
		drive.tankDrive(left, right);
		System.out.println("drive is running");
	}

	public void setSafetyAndExpiration(boolean safety, double expiration) {
		drive.setExpiration(expiration);
		drive.setSafetyEnabled(safety);
	}
}
