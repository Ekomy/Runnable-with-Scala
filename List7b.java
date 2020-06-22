package Scala;
import java.nio.IntBuffer;
import java.util.Random;



 class threadTry1a implements Runnable {
	
	 IntBuffer buffer;
	  int max,min,range;
	
	threadTry1a(int x,int y,int range){
		min = x;
		max = y;
		buffer = IntBuffer.allocate(range);
	}
	
	
	
	 private static int getRandomX(int min, int max) {
	        Random x = new Random();
	        return x.nextInt((max - min) + 1) + min;
	     }
	 
	 
	@Override
	public void run() {
		 
		 try {	 
			
			 for(int i=0; i<buffer.capacity(); i++) {	
			 int x = getRandomX(min,max);
			 System.out.println("Generated value: < "+ x +" >");
			 buffer.put(x);
			 System.out.println("Value <"+ x +"> has been stored");
			 Thread.sleep(x);
		 }
	   
      } 
		 catch (InterruptedException e) {
        	 System.out.println(e);
         }
	}
	
}
 
 class threadTry2b implements Runnable {
	 
	 int idNumber;
	 int x;
	 
	 threadTry2b(int idNumber, int x){
		 this.idNumber = idNumber;
		 this.x=x;
	 }

	@Override
	public void run() {
		
		 try {	
			 
			 System.out.println("Reader <"+ idNumber +"> waits for < "+ x + ">");
			 Thread.sleep(x);
			 System.out.println("Reader <" + idNumber+  "> waited <" + x + "> ");
		 }
	   
		 catch (InterruptedException e) {
        	 System.out.println(e);
         }
		
		
	}
 }

public class List7b {

	public static void main(String[] args) {
		Thread t1 = new Thread(new threadTry1a(1000,5000,1));
		
		t1.start();
		try {  
			 t1.join(10);  
		 }
		 catch(Exception e) {
			 System.out.println(e);
			 }  
		
	 
		 Thread t2 = new Thread(new threadTry2b(246494,30));
		 t2.start();
		 try {  
			 t2.join(10);  
		 }
		 catch(Exception e) {
			 System.out.println(e);
			 }  
	}

	
	
	
}
