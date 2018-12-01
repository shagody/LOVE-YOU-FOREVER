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

		        //获取控制台输入的内容
		        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		        System.out.print("请输入发送的字符串：");
		        String str = bufferedReader.readLine();

		        //给服务端发送消息
		        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
		        printWriter.write(str + "\r\n");
		        printWriter.flush();

		        //关闭资源
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
	         System.out.println("本机名称是：" + localname);
	         System.out.println("本机的ip是 ：" + localip);
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	}
   
}
