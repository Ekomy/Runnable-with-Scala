package Scala;
import java.nio.IntBuffer;
import java.util.Random;


	
  class threadTry1 implements Runnable {
	
	 IntBuffer buffer;
	  int max,min,range;
	
	threadTry1(int x,int y,int range){
		min = x;
		max = y;
		buffer = IntBuffer.allocate(range);
	}
	

	 
	 
	@Override
	public void run() {
		 
		 try {	 
			
			 for(int i=0; i<buffer.capacity(); i++) {	
			 int random = randomX(min,max);
			 System.out.println("Generated value: < "+ random +" >");
			 buffer.put(random);
			 System.out.println("Value <"+ random +"> has been stored");
			 Thread.sleep(random);
		 }
	   
      } 
		 catch (InterruptedException e) {
        	 System.out.println(e);
         }
	}
	
	public int randomX(int min, int max) {
		Random rand = new Random();
    	return  rand.nextInt((max - min) + 1) + min;
	
	}

 
 }
	
 class threadTry2 implements Runnable {
	 
	 int idNumber;
	 int x;
	 
	 threadTry2(int idNumber, int x){
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

public class List7  {

	public static void main(String[] args) {
		
		threadTry1 t1 = new threadTry1(1000,5000,1);
		
		Thread thread = new Thread(t1);
		
		
		thread.start();
		try {  
			thread.join(10);  
		 }
		 catch(Exception e) {
			 System.out.println(e);
			 }  

		
		 Thread t2 = new Thread(new threadTry2(246494,t1.buffer.get(0)));
		 t2.start();
		 try {  
			 t2.join(10);  
		 }
		 catch(Exception e) {
			 System.out.println(e);
			 }  
	}
		
	}

