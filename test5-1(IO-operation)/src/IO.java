import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*�Ӽ��̽����ֽ���
д�뵽��ǰĿ¼�µ�src.txt�ļ���
��src.txt�ļ����ݸ��Ƶ���ǰĿ¼��dest.txt�ļ���
��dest.txt�ļ�������ʾ����Ļ��*/
public class IO {
	public void read(){		    //�Ӽ��̽����ֽ���д�뵽��ǰĿ¼�µ�src.txt�ļ���
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
	public void copyfile(){             //��src.txt�ļ����ݸ��Ƶ���ǰĿ¼��dest.txt�ļ���
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
			System.out.println("����ļ������ݣ�");
            while ((c =in.read()) != -1) {  
                System.out.print((char)(c));  
            }  
            in.close(); 
		}catch (IOException e) {
		     System.err.println("FileStreamsTest: " + e);
		}	
	}
}
