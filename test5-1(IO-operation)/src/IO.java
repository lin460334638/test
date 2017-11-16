import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*从键盘接收字节流
写入到当前目录下的src.txt文件中
将src.txt文件内容复制到当前目录下dest.txt文件中
将dest.txt文件内容显示到屏幕上*/
public class IO {
	public void read(){		    //从键盘接收字节流写入到当前目录下的src.txt文件中
		try {
			File fr=new File("src.txt");
			FileOutputStream out=new FileOutputStream(fr);
			System.out.println("Please Enter: ");
            int c;  
            while ((c =System.in.read()) != '\n') {  
                out.write((char)c);  
            }  
            out.close();  
		} catch (Exception e) {
			System.out.println(e.toString()); 
		}
	}
	public void copyfile(){             //将src.txt文件内容复制到当前目录下dest.txt文件中
		try{
			File inFile=new File("src.txt");
			File outFile=new File("dest.txt");
			FileInputStream in=new FileInputStream(inFile);
			FileOutputStream out=new FileOutputStream(outFile);
			int c;
            while ((c =in.read()) != -1) {  
                out.write(c);  
            }  
            out.close(); 
		}catch (IOException e) {
		     System.err.println("FileStreamsTest: " + e);
		}		
	}
	public void printfile(){
		try{
			File fr=new File("dest.txt");
			FileInputStream in=new FileInputStream(fr);
			int c;
			System.out.println("输出文件中内容：");
            while ((c =in.read()) != -1) {  
                System.out.print((char)(c));  
            }  
            in.close(); 
		}catch (IOException e) {
		     System.err.println("FileStreamsTest: " + e);
		}	
	}
}
