package _00_Dynamic_Integer_Array;

public class DynamicIntegerArray {
	//1. Create a private int array. Don't initialize it.
	private int[] arr;
	
	public DynamicIntegerArray() {
		//2. Initialize the int array to have 0 elements. 
		//   This will prevent a null pointer exception
		arr = new int[0];
	}
	
	//3. Complete the steps in the add method
	public void add(int v) {
		//A. create and initialize a new int array to be one 
		//   element longer than the member array
		int[] newIntArr  = new int[arr.length+1];
		
		//B. set the last element of your new array to 
		//   the value passed into the method
		newIntArr[newIntArr.length-1] = v;
		//C. iterate through the member array and 
		//   copy every element from the member array 
		//   to the new array
		for(int j = 0; j < arr.length; j++) {
			newIntArr[j] = arr[j];
		}
		
		//D. set the member array equal to the new array.
		arr = newIntArr;
	}
	
	//4. Complete the steps in the get method
	public int get(int location) {
		//A. Return the value of the memeber array at the location passed in
		return arr[location];
	}
	
	//5. Run the DynamicArrayTest to see if you are correct so far.
	
	
	//6. Complete the steps in the set method
	public void set(int v, int location) {
		//A. set the variable at the location passed in to the method
		//   to the new value v
		arr[location] = v;
	}
	
	//7. Complete the steps in the insert method
	public void insert(int v, int location) {
		//A. create and initialize a new int array to be one 
		int[] newIntArr = new int[arr.length+1];
		//   element longer than the member array
		
		//B. Make a for loop that iterates through the new array
		for(int j = 0; j < newIntArr.length; j++) {
			//C. if i is less than location:
		    //		set the element at i of the new array to the element at i of the member array
			if(j < location) {
				newIntArr[j] = arr[j];
			}
			//D. else if i is greater than location:
		    //		set the element at i of the new array to the i - 1 element of the member array
			else if(j > location) {
				newIntArr[j] = arr[j-1];
			}
			//E. else, set the element at i of the new array to the value v
			else {
				newIntArr[j] = v;
			}
		}
		//F. set the member array equal to the new array
		arr = newIntArr;
	
	}
	
	//8. Run the tests again and check your progress
	
	//9. Complete the steps in the remove method
	public void remove(int location) {
		//A. create a new array that is one element smaller than the member array
			int[] newIntArr = new int[arr.length-1];
		//B. make a for loop to iterate through the member array
		for(int j = 0; j < arr.length; j++) {
			//C. if i  is less than location
			//		set the element at i of the new array to the element at i of the member array
				if(j < location) {
					newIntArr[j] = arr[j];
				}
			//D. else if i  is greater than location
			//		set the element at i - 1 of the new array to the element at i of the member array
				else if(j > location) {
				newIntArr[j-1] = arr[j];
			}
			//E. else, continue;
		}
		//F. set the member array equal to the new array
		arr = newIntArr;
	}
	
	//10. Run the tests again the see if you are correct so far
	
	//11. Complete the size method so that it returns the length of the member array.
	public int size() {
		return arr.length;
	}
	
	//12. Complete the clear array so that it sets the member array 
	//    equal to a new integer array of size 0
	public void clear() {
		arr = new int[0];
	}
	
	//13. Run the test again to see if you are finished.
}
