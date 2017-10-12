实验三--工厂模式练习

类PizzaStore披萨商店要接收披萨订单生产披萨，其Public Pizza orderPizza(String type)根据披萨类型type完成披萨制作，并返回一个Pizza实例(实际上要返回一个其子类实例)。制作过程包括（pizza.prepare(); pizza.bake(); pizza.cut(); pizza.box()）Pizza是个抽象类，其有三个子类实现：CheesePizza,PepperoniPizza和ClamPizza。Pizza中的抽象方法有prepare();//准备材料bake();//烘焙披萨cut();//切割披萨box();//披萨装包SimplePizzaFactory是一个披萨对象生成“工厂”，根据不同的type生成不同的Pizza实例（其实是 CheesePizza,PepperoniPizza, ClamPizza 中的一种）。利用public Pizza createPizza(String type)方法生成具体的Pizza实例，如果type是”cheese”生成CheesePizza，是”pepperoni”生成PepperoniPizza，是”clam”生成ClamPizza。PizzaStore的构造函数需要传入SimplePizzaFactory实例，并且在orderPizza方法中利用SimplePizzaFactory实例首先生成一个具体的Pizza子类实例，然后进行披萨生产，包括pizza.prepare; pizza.bake(); pizza.cut(); pizza.box()，最后返回该Pizza子类实例




![](https://github.com/lin460334638/test/raw/master/实验截图/Pizza工厂.png)