
//编写一个具有public、private、protected、default访问权限的数据成员和成员函数的class。为它产生一个对象并进行观察：当你尝试取用所有class成员时、会产生什么类型的编译消息
public class test_class {
	test_class(){
		a=1;
		b=2;
		c=3;
		d=4;
	}
	public int a;
	public void aa(){
		System.out.println("public aa");
	}
	private int b;
	private void bb(){
		System.out.println("private bb");
	}
	protected int c;
	protected void cc(){
		System.out.println("protect cc");
	}
	int d;
	void dd(){
		System.out.println("deflaut dd");
	}

	
}
