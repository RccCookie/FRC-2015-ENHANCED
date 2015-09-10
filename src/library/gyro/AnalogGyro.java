package library.gyro;

import edu.wpi.first.wpilibj.Gyro;

public class AnalogGyro extends Gyro {
  
  public AnalogGyro(int port) {
    super(port);
  }
  
    public AnalogGyro(int port, int sensitivty) {
    super(port);
    super.setSensitivity(sensitivity);
  }
  
    public AnalogGyro(int port, int sensitivty, PIDSourceParameter source) {
      super(port);
      super.setSensitivity(sensitivity);
      super.setPIDSourceParameter(source);
  }
  
  public void init() {
    super.gyroInit();
  }
  
  public void reset() {
    super.reset();
  }
  
  public double getAngle() {
    return Math.round(super.getAngle());
  }
  
  public double getRate() {
    return super.getRate();
  }
  
  public double pidGet() {
    return super.pidGet();
  }
}
