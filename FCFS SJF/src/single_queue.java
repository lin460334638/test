import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
public class single_queue {
	List<Task> list=new ArrayList<>();
	public void S_queue(){
		file_oper  fr=new file_oper();
		//fr.writefile();
		Task task =new Task();
		list=task.gettaskArray();
		for(int i=0;i<list.size();i++){
			if(i==0) {
				list.get(i).calulate_Time(list.get(i).arrivalTime);      //第一个元素的开始时间是其到达时间
			}
			else
				list.get(i).calulate_Time(list.get(i-1).finishingTime);
			list.set(i, list.get(i));          //将修改后的对象重新放入List中
		}
	}
	public void showsingle_queue(){
		DecimalFormat df = new DecimalFormat("#.0"); 
		System.out.println("--------FCFS单队列-----");
		System.out.println("taskID	 "+"到达时间	"+"开始时间	"+"服务时间	"+"结束时间	"+"周转时间 	"+"带权周转时间	"+'\n');
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).taskID+"	"+list.get(i).arrivalTime+"	 "+list.get(i).startingTime+"     "+"    "
		+list.get(i).serviceTime+"      "+list.get(i).finishingTime+"      "+list.get(i).turnAroundTime+"      "+df.format(list.get(i).weightTurnAround));
		}
		File file =new File("FCFS单队列.txt");
		try{
			FileWriter fw=new FileWriter(file);
			BufferedWriter bufw=new BufferedWriter(fw);
			bufw.write("--------------FCFS单队列--------------\n");
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
