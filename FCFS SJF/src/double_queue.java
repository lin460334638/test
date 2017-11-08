import java.util.ArrayList;
import java.util.List;


public class double_queue {
	List <Task> list=new ArrayList<>(); 
	List <Task> list1=new ArrayList<>();
	List <Task> list2=new ArrayList<>();
	public void D_queue(){
		file_oper  fr=new file_oper();
		fr.writefile();
		Task task =new Task();
		list=task.gettaskArray();
		for(int i=0;i<list.size();i++){
			if(i==0){
				list1.add(list.get(i));
				list1.get(i).calulate_Time(list1.get(i).arrivalTime);
				list1.set(i,list.get(i));
			}
			if(i==1){
				list2.add(list.get(i));
				list2.get(list2.size()-1).calulate_Time(list2.get(list2.size()-1).arrivalTime);
				list2.set(list2.size()-1,list2.get(list2.size()-1));
			}
			else if (i>1){
				if(list1.get(list1.size()-1).finishingTime<list2.get(list2.size()-1).finishingTime){
					list1.add(list.get(i));
					list1.get(list1.size()-1).calulate_Time(list1.get(list1.size()-2).finishingTime);
					list1.set(list1.size()-1,list1.get(list1.size()-1));
				}
				else {
					list2.add(list.get(i));
					list2.get(list2.size()-1).calulate_Time(list2.get(list2.size()-2).finishingTime);
					list2.set(list2.size()-1,list2.get(list2.size()-1));
				}
			}
		}
	}
	public void showdouble_queue(){
		System.out.println("队列一");
		System.out.println("taskID	 "+"到达时间	"+"开始时间	"+"服务时间	"+"结束时间	"+"周转时间 	"+"带权周转时间	"+'\n');
		for(int i=0;i<list1.size();i++)
		{
			System.out.println(list1.get(i).taskID+"	"+list1.get(i).arrivalTime+"	 "+list1.get(i).startingTime+"     "+"    "
		+list1.get(i).serviceTime+"      "+list1.get(i).finishingTime+"      "+list1.get(i).turnAroundTime+"      "+list1.get(i).weightTurnAround);
		}
		System.out.println("队列二");
		System.out.println("taskID	 "+"到达时间	"+"开始时间	"+"服务时间	"+"结束时间	"+"周转时间 	"+"带权周转时间	"+'\n');
		for(int i=0;i<list2.size();i++)
		{
			System.out.println(list2.get(i).taskID+"	"+list2.get(i).arrivalTime+"	 "+list2.get(i).startingTime+"     "+"    "
		+list2.get(i).serviceTime+"      "+list2.get(i).finishingTime+"      "+list2.get(i).turnAroundTime+"      "+list2.get(i).weightTurnAround);
		}
	}
}
