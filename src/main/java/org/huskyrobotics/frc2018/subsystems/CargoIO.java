/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.huskyrobotics.frc2018.subsystems;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;

public class CargoIO {
	private VictorSPX m_motor;
	private DigitalInput m_limitSwitch;
	
	private double maxSpeed = 1.0;

	//private SomeSensor _CheckSensor;
	public CargoIO (int motorDeviceNum, int sensorChannel) {
		m_motor = new VictorSPX(motorDeviceNum);
		m_limitSwitch = new DigitalInput(sensorChannel);
	}
	
	public void toggle () {
		if (hasBall()) {
			output();
		} else {
			intake();
		}
	}
	
	public void intake () {
		m_motor.set(ControlMode.PercentOutput, maxSpeed);
	}
	
	public void output () {
		m_motor.set(ControlMode.PercentOutput, -maxSpeed);
	}

	public void stop () {
		m_motor.set(ControlMode.PercentOutput, 0);
	}
	
	private void init() {
		m_motor.set(ControlMode.PercentOutput, 0);
	}
	private boolean hasBall() {
		return (m_limitSwitch.get());
	}
}
