package practice.demo.day10;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
	
		//How to declare array list
		
		ArrayList list = new ArrayList(); // we can store any type of element/s
		//ArrayList <Integer> list=new ArrayList <Integer>();
		//ArrayList <String> list=new ArrayList <String>(); //strings
		
		//Adding values to arraylist
		
		list.add("John");  //0
		list.add("David");   //1
		list.add("Scott");  //2
		list.add("Smith"); //3
		list.add(100);
		list.add('A');
		
		//size of array list
		System.out.println(list.size());  //4
		System.out.println("Before removign elements:" +list);
		
		//remove an elemenet
		list.remove(2); // remove scott
		System.out.println(list.size());//3
		System.out.println("After removing elements:" +list);
		
		//inserting a new element into array list
		list.add(1,"Scott2");
		System.out.println(list.size());//4
		System.out.println("After inserting element:" +list);
		
		//read values from array list using for loop
		
		for(Object s:list)   // Object type varaible can hold any type of values
		{
			System.out.println(s);
		}

	}

}
