package socket.string.demo;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo3 {

	private static ServerSocket ss;

	public static void main(String[] args) throws IOException {
		ss = new ServerSocket(8888);
		System.out.println("服务器启动，监听了8888端口");
		
		while(true) {
			Socket s=ss.accept();
			System.out.println("客户端"+s.getRemoteSocketAddress()
			+"连接了服务器");
			InputStream iis=s.getInputStream();
			byte[] bs=new byte[1024];
			int length=-1;
			String str="";
			while((length=iis.read(bs,0,bs.length))!=-1) {
				str+=new String (bs,0,length);
			}
			System.out.println("客户端说："+str);
			iis.close();
			s.close();
		}
	}
}
