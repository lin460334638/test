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
		System.out.println("taskID	 "+"����ʱ��	"+"��ʼʱ��	"+"����ʱ��	"+"����ʱ��	"+"��תʱ�� 	"+"��Ȩ��תʱ��	"+'\n');
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).taskID+"	"+list.get(i).arrivalTime+"	 "+list.get(i).startingTime+"     "+"    "
		+list.get(i).serviceTime+"      "+list.get(i).finishingTime+"      "+list.get(i).turnAroundTime+"      "+list.get(i).weightTurnAround);
		}
	}
}
