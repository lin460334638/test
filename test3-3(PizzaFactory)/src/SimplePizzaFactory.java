
public class SimplePizzaFactory {
	public Pizza createPizza(String type){
		switch(type){
		case "cheese":
			CheesePizza cheeseP=new CheesePizza();
			return cheeseP;
		case "pepperoni":
			PepperoniPizza pepperoniP=new PepperoniPizza();
			return pepperoniP;
		case "clam":
			ClamPizza clamP=new ClamPizza();
			return clamP;
		default:
			System.out.println(" ‰»Î¥ÌŒÛ");
			return null;
		}
	}
}
