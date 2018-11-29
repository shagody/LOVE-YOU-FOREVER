
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
 
public class ClientDemo1 {
	public static void testClient(){
		System.out.println("������������������ӡ�����");
		Socket socket = null;
		Scanner keybordscanner = null;
		Scanner inScanner = null;
		PrintWriter pwtoserver = null;
		try {
			socket = new Socket("192.168.177.1", 6666);
			inScanner = new Scanner(socket.getInputStream()); 
			System.out.println(inScanner.nextLine());
			pwtoserver = new PrintWriter(socket.getOutputStream());
			System.out.print("��(�ͻ���)��");
			//�ȶ�ȡ����¼�뷽�������˷�����Ϣ
			keybordscanner = new Scanner(System.in);
			while(keybordscanner.hasNextLine()){
				String keyborddata = keybordscanner.nextLine();
				//չʾ�������Ŀ���̨
//				System.out.println("��(�ͻ���)��"+keyborddata);
				//д������˵ĵĿ���̨
				pwtoserver.println(keyborddata);
				pwtoserver.flush();
				//�����ȴ����շ���˵���Ϣ
				String indata = inScanner.nextLine();
				System.out.println("����ˣ�"+indata);
				System.out.print("��(�ͻ���)��");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			keybordscanner.close();
			pwtoserver.close();
			inScanner.close();
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		testClient();
	}
}
