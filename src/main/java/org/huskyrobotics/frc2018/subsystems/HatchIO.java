package org.huskyrobotics.frc2018.subsystems;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class HatchIO {
	private VictorSPX[] m_linearActuators;
    private double m_outSpeed = 1.0;
    private double m_inSpeed = 1.0;

    public HatchIO(int[] actuatorDeviceNums) {
        m_linearActuators = new VictorSPX[] {new VictorSPX(actuatorDeviceNums[0]), new VictorSPX(actuatorDeviceNums[10]), new VictorSPX(actuatorDeviceNums[2]), new VictorSPX(actuatorDeviceNums[3])};
    }
    
    public void release () {
        SetActuatorsOut();
    }
    public void reset () {
        SetActuatorsIn();
    }
	
    private void init () {
		ResetActuators();
    }
    
    private void SetActuatorsIn() {
        for (VictorSPX actuator : m_linearActuators) { 
            actuator.set(ControlMode.PercentOutput, m_inSpeed);
        } 
    }
    private void SetActuatorsOut() {
        for (VictorSPX actuator : m_linearActuators) { 
            actuator.set(ControlMode.PercentOutput, m_outSpeed);
        } 
    }
    private void ResetActuators() {
        for (VictorSPX actuator : m_linearActuators) { 
            actuator.set(ControlMode.PercentOutput, 0);
        } 
    }
}
