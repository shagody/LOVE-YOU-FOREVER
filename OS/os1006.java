package OS1006;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNext()) {
			String ava[]=scan.next().split(",");
			int resLenth=ava.length;
			int Available[];
			String temp1[];
			int resAvailable[] = null;
			
			for(int i=0;i<resLenth;i++) {
				temp1=ava[i].split(" ");
				resAvailable[i]=Integer.parseInt(temp1[1]);
			}
			String temp2[];
			ArrayList<String> processName = null;
			int Max[][];
			int n=scan.nextInt();
			for(int i=0;i<n;i++) {
				temp2=scan.next().split(",");
				processName.add(temp2[0]);
				temp2[2].split(" ");
			}
			
		}
		scan.close();
	}

}
