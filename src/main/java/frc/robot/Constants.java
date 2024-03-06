//Copyright (c) FIRST and other WPILib contributors. Open Source Software; you can modify and/or share it under the terms of the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kManipulatorControllerPort = 1;
  }
  public static class DrivetrainConstants {
   //CAN
    public static final int kDriveLeaderLeft = 10;
    public static final int kDriveFollowerLeft = 4;
    public static final int kDriveLeaderRight = 2;
    public static final int kDriveFollowerRight = 5;
  }
  public static class ShooterConstants {
   //CAN
    public static final int kLauncherID = 7;
    public static final int kFeederID = 3;

    public static final double kIntakeFeederSpeed = RobotContainer.getShooterTriggerIntake();
    public static final double kIntakeLauncherSpeed = RobotContainer.getShooterTriggerOuttake();

  }

   public static class VisionConstants {
   public static final Transform3d robotToCam =
           new Transform3d(
                  new Translation3d(0.5, 0.0, 0.5),
                   new Rotation3d(
                           0, 0,
                           0)); 
   

   // Cam mounted facing forward, half a meter forward of center, half a meter up from center.
   public static final String cameraName = "OV5647";
   public static final double maxDistanceAway = 2.0;
   public static final double forwardKP = 0.1;
   public static final double forwardToAngleRatio = 0.5;
    
   public static final double CAMERA_HEIGHT_METERS = 0.72;
   public static final double TARGET_HEIGHT_METERS = 0;
   public static final double CAMERA_PITCH_RADIANS = 0;
   }
  

}
