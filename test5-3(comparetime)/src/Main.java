//�ô�����Ͳ���������ַ���ʵ���ļ����ƣ����ȽϺ�ʱ�����
public class Main {

	public static void main(String[] args) {
		compareTime c = new compareTime(); 
		long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
		c.nobuffer();
		long endTime=System.currentTimeMillis(); //��ȡ����ʱ��
		System.out.println("������������ʱ�䣺 "+(endTime-startTime)+"ms");
		long startTime2=System.currentTimeMillis();   //��ȡ��ʼʱ��
		c.buffer();
		long endTime2=System.currentTimeMillis(); //��ȡ����ʱ��
		System.out.println("����������ʱ�䣺 "+(endTime2-startTime2)+"ms");
		
	}
}
