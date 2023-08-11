// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  
  private CANSparkMax leftMotorFront; 
  private CANSparkMax leftMotorBack; 

  private CANSparkMax rightMotorFront; 
  private CANSparkMax rightMotorBack; 

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {

    leftMotorFront = new CANSparkMax(1, MotorType.kBrushless); 
    leftMotorBack = new CANSparkMax(2, MotorType.kBrushless); 
    rightMotorFront = new CANSparkMax(3, MotorType.kBrushless); 
    rightMotorBack = new CANSparkMax(4, MotorType.kBrushless); 
    
    leftMotorFront.restoreFactoryDefaults(); 
    leftMotorBack.restoreFactoryDefaults(); 
    rightMotorFront.restoreFactoryDefaults(); 
    rightMotorBack.restoreFactoryDefaults(); 

    rightMotorFront.setInverted(true);
    rightMotorBack.setInverted(true);

    leftMotorBack.follow(leftMotorFront); 
    rightMotorBack.follow(rightMotorFront); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void set(double drive, double turn){
    rightMotorFront.set(drive + turn);    
    leftMotorFront.set(drive - turn);
  }

  public void stop(){ 
    rightMotorFront.set(0);
    rightMotorBack.set(0);
  }
}
