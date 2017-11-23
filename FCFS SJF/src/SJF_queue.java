import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class SJF_queue {
	List<Task> list=new ArrayList<Task>();
	List<Task> list1=new ArrayList<Task>();
	List<Task> list2=new ArrayList<Task>();
	public void Sin_queue(){
		//file_oper  fr=new file_oper();
		//fr.writefile();
		Task task =new Task();
		list=task.gettaskArray(); 
		for(int i=0;i<list.size();i++){
			if(i==0) 
				list.get(i).calulate_Time(list.get(i).arrivalTime);      //��һ��Ԫ�صĿ�ʼʱ�����䵽��ʱ��
			else{
				int toindex=list.get(i-1).finishingTime+1;     //����toindex��������ֹ����
				if(toindex>=list.size())
					toindex=list.size(); 
				Collections.sort(list.subList(i, toindex));     //subList������ȡ���б�Collections.sort()�������򣬲��һ��޸�ԭ�б�
				list.get(i).calulate_Time(list.get(i-1).finishingTime);		
			}
			list.set(i, list.get(i));
		} 
	}
	public void Dou_queue(){
		//file_oper  fr=new file_oper();
		//fr.writefile();
		Task task =new Task();
		list=task.gettaskArray(); 
		for(int i=0;i<list.size();i++){
			if(i==0){
				list1.add(list.get(i));
				list1.get(i).calulate_Time(list1.get(i).arrivalTime);
				list1.set(i,list.get(i));
				list.set(i, list1.get(i));
			}
			if(i==1){
				list2.add(list.get(i));
				list2.get(list2.size()-1).calulate_Time(list2.get(list2.size()-1).arrivalTime);
				list2.set(list2.size()-1,list2.get(list2.size()-1));
				list.set(i,list2.get(list2.size()-1));
			}
			else if(i>1){
				if(list1.get(list1.size()-1).finishingTime<list2.get(list2.size()-1).finishingTime){
					int toindex=list1.get(list1.size()-1).finishingTime+1;     //����toindex��������ֹ����
					if(toindex>=list.size())
						toindex=list.size(); 
					Collections.sort(list.subList(i, toindex));     //subList������ȡ���б�Collections.sort()�������򣬲��һ��޸�ԭ�б�
					list1.add(list.get(i));
					list1.get(list1.size()-1).calulate_Time(list1.get(list1.size()-2).finishingTime);
					list1.set(list1.size()-1,list1.get(list1.size()-1));
					list.set(i,list1.get(list1.size()-1));
				}
				else {
					int toindex=list2.get(list2.size()-1).finishingTime+1;     //����toindex��������ֹ����
					if(toindex>=list.size())
						toindex=list.size(); 
					Collections.sort(list.subList(i, toindex));     //subList������ȡ���б�Collections.sort()�������򣬲��һ��޸�ԭ�б�
					list2.add(list.get(i));
					list2.get(list2.size()-1).calulate_Time(list2.get(list2.size()-2).finishingTime);
					list2.set(list2.size()-1,list2.get(list2.size()-1));
					list.set(i,list2.get(list2.size()-1));
				}
			}
		}
	}
	public void sort(){
		Collections.sort(list, new Comparator<Task>(){
			@Override
			public int compare(Task o1, Task o2) {
				if(o1.taskID>o2.taskID)
					return 1;
				else if(o1.taskID<o2.taskID)
					return -1;
					else
						return 0;			
			}
			
		});
	}
	public void showsin_queue(){
		DecimalFormat df = new DecimalFormat("#.0");
		System.out.println("--------SJF������-----");
		System.out.println("taskID	 "+"����ʱ��	"+"��ʼʱ��	"+"����ʱ��	"+"����ʱ��	"+"��תʱ�� 	"+"��Ȩ��תʱ��	"+'\n');
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).taskID+"	"+list.get(i).arrivalTime+"	 "+list.get(i).startingTime+"     "+"    "
		+list.get(i).serviceTime+"      "+list.get(i).finishingTime+"      "+list.get(i).turnAroundTime+"      "+df.format(list.get(i).weightTurnAround));
		}
		File file =new File("SJF������.txt");
		try{
			FileWriter fw=new FileWriter(file);
			BufferedWriter bufw=new BufferedWriter(fw);
			bufw.write("--------------SJF������--------------\n");
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
	public void showdou_queue(){
		DecimalFormat df = new DecimalFormat("#.0");
		System.out.println("--------SJF˫����-----");
		System.out.println("taskID	 "+"����ʱ��	"+"��ʼʱ��	"+"����ʱ��	"+"����ʱ��	"+"��תʱ�� 	"+"��Ȩ��תʱ��	"+'\n');
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).taskID+"	"+list.get(i).arrivalTime+"	 "+list.get(i).startingTime+"     "+"    "
		+list.get(i).serviceTime+"      "+list.get(i).finishingTime+"      "+list.get(i).turnAroundTime+"      "+df.format(list.get(i).weightTurnAround));
		}
		File file =new File("SJF˫����.txt");
		try{
			FileWriter fw=new FileWriter(file);
			BufferedWriter bufw=new BufferedWriter(fw);
			bufw.write("--------------SJF˫����--------------\n");
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
