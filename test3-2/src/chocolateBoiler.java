


public class chocolateBoiler {

	private boolean empty;
	private boolean boiled;	
	private static chocolateBoiler instance;
	private chocolateBoiler(){
		empty=true;
		boiled=false;
	}
	public static chocolateBoiler getInstance(){
		if(instance==null){
			instance=new chocolateBoiler();
		}
		return instance;
	}
	public void fill(){
		if(isEmpty()==true){
			System.out.println("向锅炉填满巧克力和牛奶的混合物");
			empty=false;
		}
	}
	public void boil(){
		if(isEmpty()==false&&isBoiled()==false){
			System.out.println("将炉内煮沸");
			boiled=true;
		}
	}
	public void drain(){
		if(isEmpty()==false&&isBoiled()==true){
			System.out.println("排除煮沸的巧克力和牛奶");
			empty=true;
		}
	}
	public boolean isEmpty(){
		return empty;
	}
	public boolean isBoiled(){
		return boiled;
	}
	

		
}

