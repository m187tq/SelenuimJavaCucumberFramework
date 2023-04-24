package practice.demo.day7;

class Bike
{
	void run()  // final method, so we cannot overrid this method in child class
	{
		System.out.println("Running........");
	}
}


class Honda extends Bike
{
	void run()  // compile time error
	{
		System.out.println("Started........");
	}
}




public class FinalMethodDemo {

	public static void main(String[] args) {
	
	}

}
