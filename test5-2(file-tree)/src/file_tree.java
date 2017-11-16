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

	/*获取某个目录下的目录信息，目录从控制台输入。
	目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
	目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。
	扩展以及自学部分：利用JAVA的GUI（Swing等）创建一个简易的文件浏览器。*/
public class file_tree {
	public String path;
	List<File> list1 = new ArrayList<File>();       //用于存放文件夹信息
	List<File> list2 = new ArrayList<File>();       //用于存放文件信息
	public void getdirectory(){
		try {
		/*	System.out.println("请输入目录：");
			Scanner s = new Scanner(System.in);	  
			String dir=s.nextLine();*/
			String dir="E:\\Java\\CDIO";
			File fr = new File(dir);
			if(!fr.exists()){
				System.out.println("目录不存在");
				System.exit(1);
			}
			else{
				path=dir;
			}
		} catch (Exception e) {
			System.out.println(e.toString()); 
		}
		 
	}
	public void orderfile(){                   //对文件信息进行排序
		try{
			File fr = new File(path);
			File[] files =fr.listFiles();    //返回一个抽象路径名数组，这些路径名表示此抽象路径名所表示目录中的文件
			for(int i=0;i<files.length;i++){
				if(files[i].isDirectory()){
					list1.add(files[i]);
				}
				else{
					list2.add(files[i]);
				}
			}
			Collections.sort(list1, new Comparator<File>(){                        //对list1的文件夹根据名字排序
				   @Override  
				   public int compare(File o1, File o2) {  
					   	Collator instance = Collator.getInstance(Locale.CHINA);     //**collator中文排序
					    return instance.compare(o1.getName(), o2.getName());
				   }  
			});
			Collections.sort(list2, new Comparator<File>(){                       //对list2的文件夹根据名字排序
				   @Override  
				   public int compare(File o1, File o2) {  
					   	Collator instance = Collator.getInstance(Locale.CHINA);     //**普通的String类的compareTo只能比较英文字母，当字符串包含中文时得用collator类比较
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
	
	public void writefile(){                 //将目录信息写入文本文件
		File fr = new File("filesInfo.txt");
		String info="";
		try{
			FileWriter out = new FileWriter(fr);
			for(File f:list1){
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(f.lastModified());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
				info=f.getName()+"    "+formatter.format(cal.getTime())+'\n';    //无法直接+'\n'实现换行，所以用String.format("%s%n",info)
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
