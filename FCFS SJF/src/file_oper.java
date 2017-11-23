import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class file_oper {
	public int tasknum=100;
	public int service[]={6,2,1,3,9};
/*	public void writefile(){
		File  file = new File("taskwork.txt");
		Random r = new Random();
		try{
			FileWriter out=new FileWriter(file);      //true参数表追加
			String str="";
			for(int i=1;i<=tasknum;i++){
				str+=i+" "+(i-1)+" "+service[r.nextInt(5)]+"\n";
			}
			out.write(str);
			out.close();
		}
		catch (Exception e1){
			e1.printStackTrace();
		}	
	}*/
	public int[][] readfile(){
		File file = new File("input.txt");
		int arr[][]=new int[tasknum][3];
		try {
			FileReader fr = new FileReader(file);
			BufferedReader in = new BufferedReader(fr);
			String s=null;
			int i=0;		
			while((s=in.readLine())!=null){
				String tmp[]=s.split("	");
				int j=0;
				for(String m:tmp){
					arr[i][j]=Integer.parseInt(m);
					j++;
				}
				i++;
			}	
			in.close();
		}
		catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return arr;
	}

}
