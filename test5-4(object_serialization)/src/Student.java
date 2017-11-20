import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/*类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。

*/
public class Student implements Serializable,Comparable<Student>{
	private static final long serialVersionUID=1234L;
	private String num;
	private String name;
	private String sex;
	List <Student> list = new ArrayList<Student>(); 
	public void setnum(String num){
		this.num=num;
	}
	public void setname(String name){
		this.name=name;
	}
	public void setsex(String sex){
		this.sex=sex;
	}
	public String getnum(){
		return this.num;
	}
	public void readfile(){
		File file = new File("list.txt");
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader in = new BufferedReader(fr);
			String m=null;		
			while((m=in.readLine())!=null){
				String tmp[]=m.split(" ");
				Student s=new Student();		
				s.setnum(tmp[0]);
				s.setname(tmp[1]);
				s.setsex(tmp[2]);
				list.add(s);						
			}
	/*		for(Student s:list){
				System.out.println(s.num);
			}*/
			in.close();
			fr.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void sort(){              //给list按学号排序
		Collections.sort(list);
	/*	for(Student s:list){
			System.out.println(s.num);
		}*/
	}
	@Override
	public int compareTo(Student o) {
		int i=this.num.compareTo(o.num);
		return i;
	}
	public void output(){
		String filename="student.bin";
		try{
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream out=new ObjectOutputStream(fos);
			for(Student s:list){
				out.writeObject(s);
			}
			out.writeObject(null);         //在文件结尾加上null用于读取时的判断
			out.close();
			fos.close();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public void input(){
		String filename="student.bin";
		try{
			FileInputStream fin=new FileInputStream(filename);
			ObjectInputStream in=new ObjectInputStream(fin);	
			Student s=new Student();
			while((s=(Student) in.readObject()) != null){
				System.out.println(s.num+" "+s.name+" "+s.sex);
			}
			in.close();
			fin.close();
		}catch (IOException ex) {
			ex.printStackTrace();
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
} 
