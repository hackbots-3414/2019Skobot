/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }
  Joystick left = new Joystick(0);
  Joystick right = new Joystick(1);
  Joystick pad = new Joystick(2);
  TalonSRX l1 = new TalonSRX(3);
  TalonSRX l2 = new TalonSRX(4);
  TalonSRX l3 = new TalonSRX(5);
  TalonSRX r1 = new TalonSRX(0);
  TalonSRX r2 = new TalonSRX(1);
  TalonSRX r3 = new TalonSRX(2);
  TalonSRX agitator = new TalonSRX(9);
  TalonSRX shooter = new TalonSRX(6);
  TalonSRX intake = new TalonSRX(8);
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
    m_autoSelected = m_chooser.getSelected();
    // autoSelected = SmartDashboard.getString("Auto Selector",
    // defaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    l1.set(ControlMode.PercentOutput, left.getY());
    l2.set(ControlMode.PercentOutput, left.getY());
    l3.set(ControlMode.PercentOutput, left.getY());
    r1.set(ControlMode.PercentOutput, right.getY());
    r2.set(ControlMode.PercentOutput, right.getY());
    r3.set(ControlMode.PercentOutput, right.getY());
    
    if (pad.getRawButton(1)) {
      agitator.set(ControlMode.PercentOutput, -0.25);
    } else {
      agitator.set(ControlMode.PercentOutput, 0);
    }
    if (pad.getRawButton(2)) {
      shooter.set(ControlMode.PercentOutput, 1.00);
    } else {
      shooter.set(ControlMode.PercentOutput, 0);
    }
    if (pad.getRawButton(4)) {
      intake.set(ControlMode.PercentOutput, -1.00);
    } else {
      intake.set(ControlMode.PercentOutput, 0);
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
