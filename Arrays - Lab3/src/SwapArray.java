//Lab 3

import java.util.Arrays;

public class SwapArray {
	
	public static void swapAll(int arr1[], int arr2[]){
		
	       for(int i=0; i<arr1.length; i++){
	           int x = arr1[i];
	           arr1[i] = arr2[i];
	           arr2[i] = x;
	       }
	      
	}
	  
	public static void main(String[] args) {
	       int[] a1 = {11, 42, -5, 27, 0, 89};
	       int[] a2 = {10, 20, 30, 40, 50, 60};
	      
	       
	       System.out.println(Arrays.toString(a1));
	       System.out.println(Arrays.toString(a2));
	       
	       swapAll(a1, a2);
	       System.out.println();
	       
	       System.out.println(Arrays.toString(a1));
	       System.out.println(Arrays.toString(a2));
	       
	      
	 }
	   
}
