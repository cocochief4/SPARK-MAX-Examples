/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  private static final int leftDeviceID = 1; 
  private static final int rightDeviceID = 2;
  private CANSparkMax m_leftMotorGroup;
  private CANSparkMax m_rightMotorGroup;
  private DigitalInput testInput = new DigitalInput(0);

  @Override
  public void robotInit() {
    /**
     * SPARK MAX controllers are intialized over CAN by constructing a CANSparkMax object
     * 
     * The CAN ID, which can be configured using the SPARK MAX Client, is passed as the
     * first parameter
     * 
     * The motor type is passed as the second parameter. Motor type can either be:
     *  com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless
     *  com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushed
     * 
     * The example below initializes four brushless motors with CAN IDs 1 and 2. Change
     * these parameters to match your setup
     */
      m_leftMotorGroup = new CANSparkMax(leftDeviceID, MotorType.kBrushless);
      m_rightMotorGroup = new CANSparkMax(rightDeviceID, MotorType.kBrushless);

      /*
       * The RestoreFactoryDefaults method can be used to reset the configuration parameters
       * in the SPARK MAX to their factory default state. If no argument is passed, these
       * parameters will not persist between power cycles
       */
      m_leftMotorGroup.restoreFactoryDefaults();
      m_rightMotorGroup.restoreFactoryDefaults();

      m_myRobot = new DifferentialDrive(m_leftMotorGroup, m_rightMotorGroup);

      m_leftStick = new Joystick(1);
      m_rightStick = new Joystick(5);
  }
  
  public void teleopInit() {
    System.out.println("hellow world");
  }

  public void teleopPeriodic() {
    m_myRobot.tankDrive(.5, .5);
    // System.out.println(testInput.get());
    System.out.println(m_leftMotorGroup.get());
  }
}