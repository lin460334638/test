
public class Threadmain1 implements Runnable{

	private String name;
	public Threadmain1(String name){
		this.name=name;
	}
	public static void main(String[] args) {
		
		Thread a=new Thread(new Threadmain1("进程a"));
		Thread b=new Thread(new Threadmain1("进程b"));
		a.start();
		b.start();


	}
	@Override
	public void run() {
		chocolateBoiler.getInstance().chocolatename(name);
		
	}

}
