// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {
  static final CANSparkMax leftMotor1 = new CANSparkMax(DrivetrainConstants.kDriveLeaderLeft, MotorType.kBrushless);
  static final CANSparkMax leftMotor2 = new CANSparkMax(DrivetrainConstants.kDriveFollowerLeft, MotorType.kBrushless);
  static final CANSparkMax rightMotor1 = new CANSparkMax(DrivetrainConstants.kDriveLeaderRight, MotorType.kBrushless);
  static final CANSparkMax rightMotor2 = new CANSparkMax(DrivetrainConstants.kDriveFollowerRight, MotorType.kBrushless);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftMotor2.follow(leftMotor1);
    rightMotor2.follow(rightMotor1);

    rightMotor1.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setPower(double leftPower, double rightPower) {
    leftMotor1.set(leftPower);
    rightMotor2.set(rightPower);
  }
}
