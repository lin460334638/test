import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

	/*��ȡĳ��Ŀ¼�µ�Ŀ¼��Ϣ��Ŀ¼�ӿ���̨���롣
	Ŀ¼��Ϣ������Ŀ¼�µ������ļ����ļ��е��б�����ÿ���ļ�����ʾ�����ƣ��޸����ڡ�����ÿ���ļ���ʾ�����ƣ��޸����ںʹ�С��
	Ŀ¼����Ϣд�����ļ��С�ע�⣬�ļ���Ϣ���Ȱ����ͷ��࣬�ļ�����ǰ���ļ��ں󣬲������Ǹ��԰����ļ����ַ�����˳������
	��չ�Լ���ѧ���֣�����JAVA��GUI��Swing�ȣ�����һ�����׵��ļ��������*/
public class file_tree {
	public String path;
	List<File> list1 = new ArrayList<File>();       //���ڴ���ļ�����Ϣ
	List<File> list2 = new ArrayList<File>();       //���ڴ���ļ���Ϣ
	public void getdirectory(){
		try {
		/*	System.out.println("������Ŀ¼��");
			Scanner s = new Scanner(System.in);	  
			String dir=s.nextLine();*/
			String dir="E:\\Java\\CDIO";
			File fr = new File(dir);
			if(!fr.exists()){
				System.out.println("Ŀ¼������");
				System.exit(1);
			}
			else{
				path=dir;
			}
		} catch (Exception e) {
			System.out.println(e.toString()); 
		}
		 
	}
	public void orderfile(){                   //���ļ���Ϣ��������
		try{
			File fr = new File(path);
			File[] files =fr.listFiles();    //����һ������·�������飬��Щ·������ʾ�˳���·��������ʾĿ¼�е��ļ�
			for(int i=0;i<files.length;i++){
				if(files[i].isDirectory()){
					list1.add(files[i]);
				}
				else{
					list2.add(files[i]);
				}
			}
			Collections.sort(list1, new Comparator<File>(){                        //��list1���ļ��и�����������
				   @Override  
				   public int compare(File o1, File o2) {  
					   	Collator instance = Collator.getInstance(Locale.CHINA);     //**collator��������
					    return instance.compare(o1.getName(), o2.getName());
				   }  
			});
			Collections.sort(list2, new Comparator<File>(){                       //��list2���ļ��и�����������
				   @Override  
				   public int compare(File o1, File o2) {  
					   	Collator instance = Collator.getInstance(Locale.CHINA);     //**��ͨ��String���compareToֻ�ܱȽ�Ӣ����ĸ�����ַ�����������ʱ����collator��Ƚ�
					    return instance.compare(o1.getName(), o2.getName());
				   }  
			});
			for(File f:list2){
				System.out.println(f.getName());
			}
		}catch (Exception e) {
			System.out.println(e.toString()); 
		}
	}
	
	public void writefile(){                 //��Ŀ¼��Ϣд���ı��ļ�
		File fr = new File("filesInfo.txt");
		String info="";
		try{
			FileWriter out = new FileWriter(fr);
			for(File f:list1){
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(f.lastModified());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
				info=f.getName()+"    "+formatter.format(cal.getTime())+'\n';    //�޷�ֱ��+'\n'ʵ�ֻ��У�������String.format("%s%n",info)
				out.write(String.format("%s%n",info));     
			}
			for(File f:list2){
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(f.lastModified());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
				info=f.getName()+"    "+formatter.format(cal.getTime())+"    "+f.length()/1024f+"KB";
				out.write(String.format("%s%n",info));
			}
			out.close();
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
