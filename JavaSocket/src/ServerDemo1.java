
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
 
public class ServerDemo1 {
	//������
	public static void testServer(){
		//����һ��������
		System.out.println("�ȴ��ͻ������ӡ�����");
		PrintWriter pwtoclien = null;
		Scanner keybordscanner = null;
		Scanner inScanner = null;
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(6666);
			//����һ���������ӿͻ��˵Ķ���
			Socket socket = ss.accept();
			System.out.println(socket.getInetAddress()+"�ѳɹ����ӵ���̨�������ϡ�");
			//�ַ������
			pwtoclien = new PrintWriter(socket.getOutputStream());
			pwtoclien.println("�ѳɹ����ӵ�Զ�̷�������"+"\t"+"�����ȷ��ԡ�");
			pwtoclien.flush();
			keybordscanner = new Scanner(System.in);
			inScanner = new Scanner(socket.getInputStream());
			//�����ȴ��ͻ��˷�����Ϣ����
			while(inScanner.hasNextLine()){
				String indata = inScanner.nextLine();
				System.out.println("�ͻ��ˣ�"+indata);
				System.out.print("��(�����)��");
				String keyborddata = keybordscanner.nextLine();
//				System.out.println("��(�����)��"+keyborddata);
				pwtoclien.println(keyborddata);
				pwtoclien.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pwtoclien.close();
			keybordscanner.close();
			inScanner.close();
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		testServer();
	}
}
