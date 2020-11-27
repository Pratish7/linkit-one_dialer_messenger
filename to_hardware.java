import com.fazecast.jSerialComm.*;

public class to_hardware {
    public static SerialPort sp;

    public static void send(String data) throws Exception {

        //sp = SerialPort.getCommPort("/dev/ttyACM0"); //Linux
        sp = SerialPort.getCommPort("COM3"); //Windows
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        if (sp.openPort()) {
            sp.getOutputStream().write(data.getBytes());
            sp.getOutputStream().flush();
            //sp.closePort();
            return;
        } else{
            return;
        }

    }
}