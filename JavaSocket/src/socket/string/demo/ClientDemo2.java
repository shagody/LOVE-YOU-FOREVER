package socket.string.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo2 {
	public static void main(String[] args) {
		 try {
		        Socket socket = new Socket("10.136.0.134", 30004);

		        //��ȡ����̨���������
		        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		        System.out.print("�����뷢�͵��ַ�����");
		        String str = bufferedReader.readLine();

		        //������˷�����Ϣ
		        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
		        printWriter.write(str + "\r\n");
		        printWriter.flush();

		        //�ر���Դ
		        bufferedReader.close();
		        printWriter.close();
		        socket.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		 
	     InetAddress ia = null;
	     try {
	         ia = InetAddress.getLocalHost();
	         String localname = ia.getHostName();
	         String localip = ia.getHostAddress();
	         System.out.println("���������ǣ�" + localname);
	         System.out.println("������ip�� ��" + localip);
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	}
   
}
