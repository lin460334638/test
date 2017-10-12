
public class maintest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplePizzaFactory spf=new SimplePizzaFactory();
		PizzaStore pizz=new PizzaStore(spf);
		pizz.orderPizza("cheese");
		pizz.orderPizza("clam");
		pizz.orderPizza("pepperoni");
	}

}
