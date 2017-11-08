import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Task implements Comparable<Task>{
	public int taskID;               //����ID
	public  int arrivalTime;           //����ʱ��
	public int serviceTime;           //����ʱ��
 	public int startingTime;         //��ʼʱ��
	public int finishingTime;          //���ʱ��=��ʼʱ��+����ʱ��
	public int turnAroundTime;          //��תʱ��=���ʱ��-�ﵽʱ��
	public double weightTurnAround;          //��Ȩ��תʱ��=��תʱ��/����ʱ��
	List<Task> list=new ArrayList<>();
	public Task(int ID,int atime,int stime){
		taskID=ID;
		arrivalTime=atime;
		serviceTime=stime;
	}

	public Task() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public void calulate_Time(int starttime){
		this.startingTime=starttime;
		this.finishingTime=this.startingTime+this.serviceTime;
		this.turnAroundTime=this.finishingTime-this.arrivalTime;
		this.weightTurnAround = (double)this.turnAroundTime/(double)this.serviceTime;
	}
	public List<Task> gettaskArray(){
		file_oper fr = new file_oper();
		int arr[][]=fr.readfile();
		for(int i=0;i<arr.length;i++){
			Task t = new Task(arr[i][0],arr[i][1],arr[i][2]);
			list.add(t);
		}
		return list;
	}

	@Override
	public int compareTo(Task o) {
		int i=this.serviceTime-o.serviceTime;
		return i;
	}
}
