import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo3 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s=new Socket("localhost",8888);
		System.out.println("�������������������");
		
		OutputStream oos=s.getOutputStream();
		oos.write("�������ˣ������ȣ�".getBytes());
		oos.flush();
		oos.close();
		s.close();
	}
}
