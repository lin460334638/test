import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Task implements Comparable<Task>{
	public int taskID;               //任务ID
	public  int arrivalTime;           //到达时间
	public int serviceTime;           //服务时间
 	public int startingTime;         //开始时间
	public int finishingTime;          //完成时间=开始时间+服务时间
	public int turnAroundTime;          //周转时间=完成时间-达到时间
	public double weightTurnAround;          //带权周转时间=周转时间/服务时间
	List<Task> list=new ArrayList<>();
	public Task(int ID,int atime,int stime){
		taskID=ID;
		arrivalTime=atime;
		serviceTime=stime;
	}

	public Task() {
		// TODO 自动生成的构造函数存根
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
