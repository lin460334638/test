import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
public class double_queue {
	List <Task> list=new ArrayList<>(); 
	List <Task> list1=new ArrayList<>();
	List <Task> list2=new ArrayList<>();
	public void D_queue(){
		file_oper  fr=new file_oper();
		//5fr.writefile();
		Task task =new Task();
		list=task.gettaskArray();
		for(int i=0;i<list.size();i++){
			if(i==0){
				list1.add(list.get(i));
				list1.get(i).calulate_Time(list1.get(i).arrivalTime);
				list1.set(i,list1.get(i));
				list.set(i, list1.get(i));
				
			}
			if(i==1){
				list2.add(list.get(i));
				list2.get(list2.size()-1).calulate_Time(list2.get(list2.size()-1).arrivalTime);
				list2.set(list2.size()-1,list2.get(list2.size()-1));
				list.set(i,list2.get(list2.size()-1));
			}
			else if (i>1){
				if(list1.get(list1.size()-1).finishingTime<list2.get(list2.size()-1).finishingTime){
					list1.add(list.get(i));
					list1.get(list1.size()-1).calulate_Time(list1.get(list1.size()-2).finishingTime);
					list1.set(list1.size()-1,list1.get(list1.size()-1));
					list.set(i, list1.get(list1.size()-1));
				}
				else {
					list2.add(list.get(i));
					list2.get(list2.size()-1).calulate_Time(list2.get(list2.size()-2).finishingTime);
					list2.set(list2.size()-1,list2.get(list2.size()-1));
					list.set(i, list2.get(list2.size()-1));
				}
			}
		}
	}
	public void showdouble_queue(){
		DecimalFormat df = new DecimalFormat("#.0");
		System.out.println("--------FCFS单队列-----");
		System.out.println("taskID	 "+"到达时间	"+"开始时间	"+"服务时间	"+"结束时间	"+"周转时间 	"+"带权周转时间	"+'\n');
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).taskID+"	"+list.get(i).arrivalTime+"	 "+list.get(i).startingTime+"     "+"    "
		+list.get(i).serviceTime+"      "+list.get(i).finishingTime+"      "+list.get(i).turnAroundTime+"      "+df.format(list.get(i).weightTurnAround));
		}
		File file =new File("FCFS双队列.txt");
		try{
			FileWriter fw=new FileWriter(file);
			BufferedWriter bufw=new BufferedWriter(fw);
			bufw.write("--------------FCFS双队列--------------\n");
			bufw.write("taskID	到达时间	开始时间	服务时间	结束时间	周转时间	 带权周转时间\n");
			for(int i=0;i<list.size();i++){
				bufw.write(list.get(i).taskID+"\t\t\t"+list.get(i).arrivalTime+"\t\t\t"+list.get(i).startingTime+"\t\t\t"
		+list.get(i).serviceTime+"\t\t\t"+list.get(i).finishingTime+"\t\t\t"+list.get(i).turnAroundTime+"\t\t\t"+df.format(list.get(i).weightTurnAround));
				bufw.newLine();
			}
			bufw.close();
			fw.close();			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
