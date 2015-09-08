package recursion;

import java.util.Stack;
/*Q:printPath from top left to the bottom left of the given 2d Input metrix
 * Class:pathPrinter
 * 
 * */
public class PathPrinter {

	//pathStack contain the point/index no of 2d matrix
	public Stack pathStack=new Stack();
	
	
	
	public static void main(String args[])
	{
	//input 2d array metrix, contain the sequence of 1 and 0 
		int inputArray[][]={{1,1,1,0,0},{0,1,1,0,0},{0,1,0,1,0},{0,1,1,1,1}};
		
			new PathPrinter().searchPath(inputArray);
			//System.out.println(inputArray.toString());
	}
	
		public int [][] searchPath(int inputArray[][])
	{
		
		System.out.println("TracePath "+TracePath(inputArray,0,0));
	while(pathStack.size()>0)
			{
		int [] pathPoint= (int[]) pathStack.pop();
		System.out.print("{"+pathPoint[0]+","+pathPoint[1]+"}-->");
			}
		return inputArray;
		
		
		
	}
	//trace path will find the path from start point to end point in given 2d array
	public Stack TracePath(int[][] inputArray,int rowPointer,int columnPointer)
	{
		
		if(inputArray.length==rowPointer)
		 {
								return pathStack;
		 }
		else if(inputArray[inputArray.length-1].length==columnPointer)
		 {
						return TracePath(inputArray,rowPointer+1,columnPointer-1); 
		 }
		 else if(checkPathAvailable(inputArray,rowPointer,columnPointer))
		 {
			 int[] pathPoint={rowPointer,columnPointer};
			 pathStack.push(pathPoint);
			 return TracePath(inputArray,rowPointer,columnPointer+1); 			 
		 }else{
			 int[] pathPoint= (int[]) pathStack.peek();
			 if(pathPoint[1]==columnPointer)
			 { 
				 while(rowPointer>0){
					 pathPoint= (int[]) pathStack.pop();
					 inputArray[pathPoint[0]][pathPoint[1]]=0;
					 rowPointer--;
					}
			  	 pathPoint=(int[]) pathStack.peek();
			 }			 
			 return TracePath(inputArray,pathPoint[0]+1,pathPoint[1]); 	
		 }
		 
			
	}
	/*
 * This function will find that next available node
 * return: boolean
 * input: input array,index of 2d array 
 * */
	public boolean checkPathAvailable(int[][] inputArray,int rowNum,int columnNum)
	{
		
		if(inputArray[rowNum][columnNum]==1)
		   return true;
		else
			return false;
		
	}
}
