import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {

	private static ServerSocket mServerSocket;

	public static void main(String[] args) {

        try {
        	mServerSocket = new java.net.ServerSocket(30004);

            Socket socket = mServerSocket.accept();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String content = null;
            while ((content=bufferedReader.readLine() )!= null) {
                System.out.println("���յ��ͷ��˷�������Ϣ��" +content);
            }

            //�ر�����
            bufferedReader.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
