package socket.file.demo;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
 
/**
 * �ļ�����Client��<br>
 * ����˵����
 *
 * @author �������޵�С��
 * @Date 2016��09��01��
 * @version 1.0
 */
public class Client2 extends Socket {
 
    private static final String SERVER_IP = "172.20.10.4"; // �����IP
    private static final int SERVER_PORT = 8899; // ����˶˿�
 
    private Socket client;
 
    private FileInputStream fis;
 
    private DataOutputStream dos;
 
    /**
     * ���캯��<br/>
     * ���������������
     * @throws Exception
     */
    public Client2() throws Exception {
        super(SERVER_IP, SERVER_PORT);
        this.client = this;
        System.out.println("Cliect[port:" + client.getLocalPort() + "] �ɹ����ӷ����");
    }
 
    /**
     * �����˴����ļ�
     * @throws Exception
     */
    public void sendFile() throws Exception {
        try {
            File file = new File("D:\\test.jpg");
            if(file.exists()) {
                fis = new FileInputStream(file);
                dos = new DataOutputStream(client.getOutputStream());
 
                // �ļ����ͳ���
                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeLong(file.length());
                dos.flush();
 
                // ��ʼ�����ļ�
                System.out.println("======== ��ʼ�����ļ� ========");
                byte[] bytes = new byte[1024];
                int length = 0;
                long progress = 0;
                while((length = fis.read(bytes, 0, bytes.length)) != -1) {
                    dos.write(bytes, 0, length);
                    dos.flush();
                    progress += length;
                    System.out.print("| " + (100*progress/file.length()) + "% |");
                }
                System.out.println();
                System.out.println("======== �ļ�����ɹ� ========");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null)
                fis.close();
            if(dos != null)
                dos.close();
            client.close();
        }
    }
 
    /**
     * ���
     * @param args
     */
    public static void main(String[] args) {
        try {
        	Client2 client = new Client2(); // �����ͻ�������
            client.sendFile(); // �����ļ�
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}
