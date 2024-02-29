// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkLowLevel.MotorType;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix.motorcontrol.GroupMotorControllers;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
// import com.ctre.phoenix6.hardware.DeviceIdentifier;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants.DrivetrainConstants;
import frc.robot.RobotContainer;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {
  // static final CANSparkMax leftMotor1 = new CANSparkMax(DrivetrainConstants.kDriveLeaderLeft, MotorType.kBrushless);
  // static final CANSparkMax leftMotor2 = new CANSparkMax(DrivetrainConstants.kDriveFollowerLeft, MotorType.kBrushless);
  // static final CANSparkMax rightMotor1 = new CANSparkMax(DrivetrainConstants.kDriveLeaderRight, MotorType.kBrushless);
  // static final CANSparkMax rightMotor2 = new CANSparkMax(DrivetrainConstants.kDriveFollowerRight, MotorType.kBrushless);

  TalonSRX rightMotor1;
  TalonSRX leftMotor1;
  TalonSRX rightMotor2;
  TalonSRX leftMotor2;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftMotor1 = new TalonSRX(DrivetrainConstants.kDriveLeaderLeft);
    leftMotor2 = new TalonSRX(DrivetrainConstants.kDriveFollowerLeft);
    rightMotor1 = new TalonSRX(DrivetrainConstants.kDriveLeaderRight);
    rightMotor2 = new TalonSRX(DrivetrainConstants.kDriveFollowerLeft);

    leftMotor2.follow(leftMotor1);
    rightMotor2.follow(rightMotor1);

    rightMotor2.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setPower(double leftPower, double rightPower) {
    leftMotor1.set(TalonSRXControlMode.PercentOutput, -leftPower*0.75);
    rightMotor1.set(TalonSRXControlMode.PercentOutput, rightPower);
  }
}
