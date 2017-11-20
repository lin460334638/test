//用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。
public class Main {

	public static void main(String[] args) {
		compareTime c = new compareTime(); 
		long startTime=System.currentTimeMillis();   //获取开始时间
		c.nobuffer();
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("不带缓冲运行时间： "+(endTime-startTime)+"ms");
		long startTime2=System.currentTimeMillis();   //获取开始时间
		c.buffer();
		long endTime2=System.currentTimeMillis(); //获取结束时间
		System.out.println("带缓冲运行时间： "+(endTime2-startTime2)+"ms");
		
	}
}
