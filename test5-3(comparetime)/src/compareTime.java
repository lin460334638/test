import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//�ô�����Ͳ���������ַ���ʵ���ļ����ƣ����ȽϺ�ʱ�����
public class compareTime {
	public void nobuffer(){            //��������ʵ���ļ�����
		File fr1 = new File("test.txt");
		File fr2 = new File("dest.txt");
		try{
			FileReader in = new FileReader(fr1);
			FileWriter out = new FileWriter(fr2);
			int i;
			while((i=in.read())!=-1)
				out.write(i);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void buffer(){          //������ʵ���ļ�����
		File fr1 = new File("test.txt");
		File fr2 = new File("dest2.txt");
		try{
			FileReader in = new FileReader(fr1);
			BufferedReader bufr = new BufferedReader(in);
			FileWriter out = new FileWriter(fr2);
			BufferedWriter bufw = new BufferedWriter(out);
			int i;
			while((i=bufr.read())!=-1)
				bufw.write(i);
			bufw.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
