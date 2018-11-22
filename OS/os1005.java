package OS1005;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static Map<String,Integer> resourceMap=new HashMap<String,Integer>();
	private static Map<String,String> needMap=new HashMap<String,String>();
	private static Map<String,Integer> resourceBusyMap=new HashMap<String,Integer>();
	private static Map<String,String> allocationMap=new HashMap<String,String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		while(scan.hasNext()) {
			
			int n= scan.nextInt();
			for(int i=0;i<n;i++) {
				String temp1=scan.next();
				int temp2=scan.nextInt();
				resourceMap.put(temp1,temp2);
			}
			int m=scan.nextInt();
			for(int i=0;i<m;i++) {
				String temp1=scan.next();
				String temp2=scan.next();
				needMap.put(temp1,temp2);
			}
			int z=scan.nextInt();
			for(int i=0;i<z;i++) {
				String temp1=scan.next();
				String temp2=scan.next();
				if(!resourceBusyMap.containsKey(temp2))
					resourceBusyMap.put(temp2, 1);
				else
					resourceBusyMap.put(temp2, (resourceBusyMap.get(temp2)+1));
				allocationMap.put(temp1,temp2);
			}
			//if all processes in AllocationMap,that is no process in NeedMap
			//as long as iterator AllocationMap again again to make sure all processes can work out
			int FinishedFlag=0;
			for(int i=0;i<z;i++) {
				for(Map.Entry<String, String>entry:allocationMap.entrySet()) {
					String ProcessNow=entry.getKey();
					String ResourceNow=entry.getValue();
					if(needMap.containsKey(ProcessNow)) {//if request
						if(resourceBusyMap.get(ResourceNow)<resourceMap.get(ResourceNow)) {
							//if have free resource,do it
							resourceBusyMap.put(ResourceNow, (resourceBusyMap.get(ResourceNow)-1));
							allocationMap.put(ProcessNow, "Finished");
							FinishedFlag++;
						}
					}
					else {//no request ,just do and release resource
						resourceBusyMap.put(ResourceNow, (resourceBusyMap.get(ResourceNow)-1));
						allocationMap.put(ProcessNow, "Finished");
						FinishedFlag++;
					}
				}
				if(FinishedFlag==z)break;
			}
			if(FinishedFlag==z)System.out.println("false");
			else System.out.println("true");
		}
	}

}
