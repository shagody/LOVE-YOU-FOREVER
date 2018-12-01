package socket.string.demo;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo3 {

	private static ServerSocket ss;

	public static void main(String[] args) throws IOException {
		ss = new ServerSocket(8888);
		System.out.println("������������������8888�˿�");
		
		while(true) {
			Socket s=ss.accept();
			System.out.println("�ͻ���"+s.getRemoteSocketAddress()
			+"�����˷�����");
			InputStream iis=s.getInputStream();
			byte[] bs=new byte[1024];
			int length=-1;
			String str="";
			while((length=iis.read(bs,0,bs.length))!=-1) {
				str+=new String (bs,0,length);
			}
			System.out.println("�ͻ���˵��"+str);
			iis.close();
			s.close();
		}
	}
}
