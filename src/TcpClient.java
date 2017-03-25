
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpClient {

    private Socket s;
    private BufferedReader in;  //character
    private PrintWriter out;    //character
    private String msg;

    public TcpClient() {
        try {
            //step 1 connect to server
            //localhost
            s = new Socket("localhost",8888); //จะวิ่งไปที่ step 2 ของ server ที่รออยู่เพื่อทำงานต่อ
            
            //step 2 create input and output
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));  //byte to character to buffered
            out = new PrintWriter(s.getOutputStream()); //byte to character

            //step 3 process
            out.println("Hello");
            out.flush(); //ดันให้หมดท่อ (ไม่มีอะไรค้างในท่อ)
            msg = in.readLine();
            System.out.println("Server echo: "+msg);
            
            //step 4 close
            s.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    public static void main(String[] args) {
        new TcpClient();
    }
}
