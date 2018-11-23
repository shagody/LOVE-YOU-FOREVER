package OS1006;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner scan;
	static int Available[];//可利用资源向量
	static int Max[][];//最大需求矩阵
	static int Allocation[][];//分配矩阵
	static int Need[][];//需求矩阵
	
	static int Request[];//请求向量
	static int Work[];//工作向量
	static Boolean Finish[];//结束向量
	
	static int proNum;
	static int resNum;
	static ArrayList<String> t0=new ArrayList<String>();
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		while (scan.hasNext()) {
			//read resource information
			Init();
			
			//banker algorithm
			BlankAlgorithm();
		}
		scan.close();
	}

	private static void BlankAlgorithm() {
		for(int i=0;i<proNum;i++) {
			Request=Need[i];//make request=need;
			for(int j=0;j<resNum;j++) {
				if(Request[j]>Available[j]){
					break;						
				}
				else if(j==resNum-1) {
					for(int k=0;k<resNum;k++) {
						Available[k]-=Request[k];
						Allocation[i][k]+=Request[k];
						Need[i][k]-=Request[k];
						
						Safety();
						if(IsSafe()) {//if safe
							System.out.println("true");
							
						}
						else {//if unsafe,recover it
							Available[k]+=Request[k];
							Allocation[i][k]-=Request[k];
							Need[i][k]+=Request[k];
						}
					}
				}
			}
		}
	}

	private static void Init() {
		String temp[]=scan.nextLine().split(",");
		resNum=temp.length;
		for(int i=0;i<resNum;i++) {
			String num=temp[i].substring(2);//get resource num
			Available[i]=Integer.parseInt(num);//make Available=full
		}
		
		//read process information
		//ideal condition(p1,p2,p3,input is in order)
		proNum=scan.nextInt();
		for(int i=0;i<proNum;i++) {
			String temp1[]=scan.nextLine().split(",");
			String temp2[]=temp1[1].split(" ");
			String temp3[]=temp1[2].split(" ");
			
			//build Max[][]
			for(int j=0;j<temp2.length;j++) {
				Max[i][j]=Integer.parseInt(temp2[j]);
			}
			
			//build Allocation[][],and update Available[]
			for(int j=0;j<temp3.length;j++) {
				Available[j]=Available[j]-Integer.parseInt(temp3[j]);
				Allocation[i][j]=Integer.parseInt(temp3[j]);
				Need[i][j]=Max[i][j]-Allocation[i][j];
			}
		}
	}

	private static void Safety() {
		SafetyInit();
		for(int i=0;i<proNum;i++) {
			if(Finish[i]==false) {
				for(int j=0;j<resNum;j++) {
					if(Need[i][j]>Work[j])break;
					else if(j==resNum-1) {
						for(int k=0;k<resNum;k++) {
							Work[i] += Allocation[i][k];
							Finish[i]=true;
						}
					}
				}
			}
		}
	}

	private static void SafetyInit() {
		for(int i=0;i<proNum;i++) {
			Finish[i]=false;
		}
		Work=Available;
	}


	static boolean IsSafe() {
		int i = 0;
		for (i = 0; i < proNum; ++i) {
			if (Finish[i] == true)
				continue;
			else
				break;
		}
		if (i == proNum - 1)
			return true; // 安全
		else
			return false; // 不安全
	}
}
