import com.fazecast.jSerialComm.*;

public class to_hardware {

    public static void send(String data) throws Exception {

        SerialPort sp = SerialPort.getCommPort("/dev/ttyACM0");
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        if (sp.openPort()) {
            sp.getOutputStream().write(data.getBytes());
            sp.getOutputStream().flush();
        } else {
            System.out.println("call failed");
        }

    }
}