

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestIterator {

	public static void main(String[] args) 
	{
		
		System.out.println("Hello");
		List<String> linkList=new LinkedList<String>(); 

		linkList.add("Hellol"); 
		linkList.add("Hello2"); 
		linkList.add("Hello3"); 
		linkList.add("Hello4"); 
		linkList.add("Hello5"); 
		linkList.add("Hello6"); 
		//Iterator : dynamic removal of elements from the list. 
		Iterator<String> iterList=linkList.iterator(); 

		while(iterList.hasNext()){

			if(((String)iterList.next()).equals("Hello3"))
			{ 
				iterList.remove(); //Allowed 
			}
		}
		iterList=linkList.iterator();
		while(iterList.hasNext()){

			System.out.println(iterList.next());
		}
		
	}
}
