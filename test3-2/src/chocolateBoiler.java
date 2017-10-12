


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
			System.out.println("���¯�����ɿ�����ţ�̵Ļ����");
			empty=false;
		}
	}
	public void boil(){
		if(isEmpty()==false&&isBoiled()==false){
			System.out.println("��¯�����");
			boiled=true;
		}
	}
	public void drain(){
		if(isEmpty()==false&&isBoiled()==true){
			System.out.println("�ų���е��ɿ�����ţ��");
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

