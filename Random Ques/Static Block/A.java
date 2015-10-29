class B {
	static int i;

	static {
		System.out.println("Static B called" + i);
		i++;

	}

	{
		System.out.println("Initializer B called" + i);
		i--;
	}

	public B(){
		System.out.println("Constructor B called" + i);
		i  = 100;
	}
}

class A extends B{
	
	{
		System.out.println("Initializer A called" + i);
		i--;
	}

	static
	{
		System.out.println("Static A called" + i);
		i++;
	}



	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.i);
	}
}