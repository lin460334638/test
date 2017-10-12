
public class PizzaStore {
	SimplePizzaFactory factory = new SimplePizzaFactory();
	public PizzaStore(SimplePizzaFactory p){
		this.factory = p;
	}
	public Pizza orderPizza(String type){
		
		Pizza pizza =factory.createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
		
	}
}
