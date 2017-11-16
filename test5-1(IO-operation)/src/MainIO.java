public class MainIO {

	public static void main(String[] args) {
		IO io=new IO();
		io.read();            //从键盘接收字节流写入到当前目录下的src.txt文件中
		io.copyfile();           //将src.txt文件内容复制到当前目录下dest.txt文件中
		io.printfile();
	}

}
