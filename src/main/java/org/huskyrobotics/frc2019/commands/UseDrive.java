/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.huskyrobotics.frc2019.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.huskyrobotics.frc2019.subsystems.drive.*;
import org.huskyrobotics.frc2019.subsystems.drive.Drivetrain;
import org.huskyrobotics.frc2019.subsystems.drive.FalconLibStuff.FalconDrive;
import org.huskyrobotics.frc2019.Robot;
import org.huskyrobotics.frc2019.OI;

public class UseDrive extends Command {
  public UseDrive() {
    requires(m_Falcon);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  FalconDrive m_Falcon;
  OI m_OI = new OI(0,1);

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_Falcon.init();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    m_Falcon.curvatureDrive(m_OI.getRobotForward(), m_OI.getRobotTwist(), true);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    m_Falcon.curvatureDrive(0, 0, true);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
