/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive mDrive;
  private Joystick mJoystick;
  private SpeedController rightFront;
  private SpeedController leftFront;
  private SpeedController leftRear;
  private SpeedController rightRear;
  private SpeedControllerGroup right;
  private SpeedControllerGroup left;
  public static final int CAN_LEFT_FRONT_MOTOR_CONTROLLER = 1;
  public static final int CAN_RIGHT_FRONT_MOTOR_CONTROLLER = 0;
  public static final int CAN_LEFT_REAR_MOTOR_CONTROLLER = 2;
  public static final int CAN_RIGHT_REAR_MOTOR_CONTROLLER = 3;


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    mJoystick = new Joystick(0);

    leftFront = new WPI_VictorSPX(CAN_LEFT_FRONT_MOTOR_CONTROLLER);
    leftRear = new WPI_VictorSPX(CAN_LEFT_REAR_MOTOR_CONTROLLER);
    left = new SpeedControllerGroup(leftFront, leftRear);

    rightFront = new WPI_VictorSPX(CAN_RIGHT_FRONT_MOTOR_CONTROLLER);
    rightRear = new WPI_VictorSPX(CAN_RIGHT_REAR_MOTOR_CONTROLLER);
    right = new SpeedControllerGroup(rightFront, rightRear);

    mDrive = new DifferentialDrive(left, right);
  }


  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called once when teleop is enabled.
   */
  @Override
  public void teleopInit() {

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    mDrive.arcadeDrive(mJoystick.getY(), mJoystick.getZ());
  }

  /**
   * This function is called once when the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  /**
   * This function is called periodically when disabled.
   */
  @Override
  public void disabledPeriodic() {
  }

  /**
   * This function is called once when test mode is enabled.
   */
  @Override
  public void testInit() {
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
