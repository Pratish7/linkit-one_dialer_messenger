import com.fazecast.jSerialComm.*;

public class to_hardware {
    public static SerialPort sp;
    public static String test;
    public static void send(String data) throws Exception {
        test = "test";
        //sp = SerialPort.getCommPort("/dev/ttyACM0"); //Linux
        sp = SerialPort.getCommPort("COM3"); //Windows
        sp.setComPortParameters(115200, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        if (sp.openPort()) {
            sp.getOutputStream().write(data.getBytes());
            sp.getOutputStream().flush();
            System.out.println("sent to board");
        } else{
            System.out.println("Failed to send");
        }

    }
}