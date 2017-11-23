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
				list.get(i).calulate_Time(list.get(i).arrivalTime);      //��һ��Ԫ�صĿ�ʼʱ�����䵽��ʱ��
			}
			else
				list.get(i).calulate_Time(list.get(i-1).finishingTime);
			list.set(i, list.get(i));          //���޸ĺ�Ķ������·���List��
		}
	}
	public void showsingle_queue(){
		DecimalFormat df = new DecimalFormat("#.0"); 
		System.out.println("--------FCFS������-----");
		System.out.println("taskID	 "+"����ʱ��	"+"��ʼʱ��	"+"����ʱ��	"+"����ʱ��	"+"��תʱ�� 	"+"��Ȩ��תʱ��	"+'\n');
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).taskID+"	"+list.get(i).arrivalTime+"	 "+list.get(i).startingTime+"     "+"    "
		+list.get(i).serviceTime+"      "+list.get(i).finishingTime+"      "+list.get(i).turnAroundTime+"      "+df.format(list.get(i).weightTurnAround));
		}
		File file =new File("FCFS������.txt");
		try{
			FileWriter fw=new FileWriter(file);
			BufferedWriter bufw=new BufferedWriter(fw);
			bufw.write("--------------FCFS������--------------\n");
			bufw.write("taskID	����ʱ��	��ʼʱ��	����ʱ��	����ʱ��	��תʱ��	 ��Ȩ��תʱ��\n");
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
