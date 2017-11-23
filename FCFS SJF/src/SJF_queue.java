import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SJF_queue {
	List<Task> list=new ArrayList<Task>();
	List<Task> list1=new ArrayList<Task>();
	List<Task> list2=new ArrayList<Task>();
	public void Sin_queue(){
		file_oper  fr=new file_oper();
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
		file_oper  fr=new file_oper();
		//fr.writefile();
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
			else if(i>1){
				if(list1.get(list1.size()-1).finishingTime<list2.get(list2.size()-1).finishingTime){
					int toindex=list1.get(list1.size()-1).finishingTime+1;     //����toindex��������ֹ����
					if(toindex>=list.size())
						toindex=list.size(); 
					Collections.sort(list.subList(i, toindex));     //subList������ȡ���б�Collections.sort()�������򣬲��һ��޸�ԭ�б�
					list1.add(list.get(i));
					list1.get(list1.size()-1).calulate_Time(list1.get(list1.size()-2).finishingTime);
					list1.set(list1.size()-1,list1.get(list1.size()-1));
				}
				else {
					int toindex=list2.get(list2.size()-1).finishingTime+1;     //����toindex��������ֹ����
					if(toindex>=list.size())
						toindex=list.size(); 
					Collections.sort(list.subList(i, toindex));     //subList������ȡ���б�Collections.sort()�������򣬲��һ��޸�ԭ�б�
					list2.add(list.get(i));
					list2.get(list2.size()-1).calulate_Time(list2.get(list2.size()-2).finishingTime);
					list2.set(list2.size()-1,list2.get(list2.size()-1));
				}
			}
		}
	}
	public void showsin_queue(){
		System.out.println("--------SJF������-----");
		System.out.println("taskID	 "+"����ʱ��	"+"��ʼʱ��	"+"����ʱ��	"+"����ʱ��	"+"��תʱ�� 	"+"��Ȩ��תʱ��	"+'\n');
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).taskID+"	"+list.get(i).arrivalTime+"	 "+list.get(i).startingTime+"     "+"    "
		+list.get(i).serviceTime+"      "+list.get(i).finishingTime+"      "+list.get(i).turnAroundTime+"      "+list.get(i).weightTurnAround);
		}
	}
	public void showdou_queue(){
		System.out.println("--------SJF˫����-----");
		System.out.println("--------����һ-----");
		System.out.println("taskID	 "+"����ʱ��	"+"��ʼʱ��	"+"����ʱ��	"+"����ʱ��	"+"��תʱ�� 	"+"��Ȩ��תʱ��	"+'\n');
		for(int i=0;i<list1.size();i++)
		{
			System.out.println(list1.get(i).taskID+"	"+list1.get(i).arrivalTime+"	 "+list1.get(i).startingTime+"     "+"    "
		+list1.get(i).serviceTime+"      "+list1.get(i).finishingTime+"      "+list1.get(i).turnAroundTime+"      "+list1.get(i).weightTurnAround);
		}
		
		System.out.println("--------���ж�-----");
		System.out.println("taskID	 "+"����ʱ��	"+"��ʼʱ��	"+"����ʱ��	"+"����ʱ��	"+"��תʱ�� 	"+"��Ȩ��תʱ��	"+'\n');
		for(int i=0;i<list2.size();i++)
		{
			System.out.println(list2.get(i).taskID+"	"+list2.get(i).arrivalTime+"	 "+list2.get(i).startingTime+"     "+"    "
		+list2.get(i).serviceTime+"      "+list2.get(i).finishingTime+"      "+list2.get(i).turnAroundTime+"      "+list2.get(i).weightTurnAround);
		}
	}
}
