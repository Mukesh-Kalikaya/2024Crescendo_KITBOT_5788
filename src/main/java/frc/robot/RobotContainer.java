// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
// import frc.robot.commands.ExampleCommand;
// import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.PhotonSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Launcher m_launcher = new Launcher();
  private final Drivetrain m_driveTrain = new Drivetrain();
  public static final PhotonSubsystem m_photonSubsystem = new PhotonSubsystem();

  // Commands
  //private final TankDrive m_tankDrive = new TankDrive(m_driveTrain);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private static final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  private static final CommandXboxController m_manipulatorController =
      new CommandXboxController(OperatorConstants.kManipulatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(Launcher::exampleCondition)
    //     .onTrue(new ExampleCommand(m_exampleSubsystem));

    // // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // // cancelling on release.
    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An example command will be run in autonomous
  //   return Autos.exampleAuto(m_exampleSubsystem);
  // }
  /* 
  public Command getTankDriveCommand() {
    return m_tankDrive;
  }
  */

  public static double getDriveLeftAxis() {
    if (Math.abs(m_driverController.getLeftY()) > 0) {
      return m_driverController.getLeftY();
    } else {
      return 0;
    }
  }

  public static double getDriveRightAxis() {
    if (Math.abs(m_driverController.getRightY()) > 0) {
      return m_driverController.getRightY();
    } else {
      return 0;
    }
  }

  public static double getShooterTriggerIntake() {
    if (Math.abs(m_driverController.getLeftTriggerAxis()) > 0) {
      return m_driverController.getLeftTriggerAxis();
    } else {
      return 0;
    }
  }

  public static double getShooterTriggerOuttake() {
    if (Math.abs(m_driverController.getRightTriggerAxis()) > 0) {
      return m_driverController.getRightTriggerAxis();
    } else {
      return 0;
    }
  }
}
