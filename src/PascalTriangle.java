import java.util.Scanner;

public class PascalTriangle {

	// Only this function will be visible to the user. Since it is static , the class doesn't have to be initialized
	public static String getValue(int row,int column){
		
		// If the row or column are negative . Basic validation
		if(row<0 || column<0)
			return "Invalid input: Coordinates in this case can't be negative";
		
		// If parameters are within range call the function
		if(row>=column)
		{
				return ""+CalculatePascalsTriangleValue(row,column);
		}
		else
			//Since according to the document, if the coordinates are out of triangle assume value to be zero
			return "0";		
		
		
	}
	
	// This function calculates the value at given coordinates, provided the input is valid
	private static int CalculatePascalsTriangleValue(int row,int column)
	{
		// These two conditions below are the base cases of the recursive function
		if (column == 0 || column == row) {
	        return 1;
	    }

		else{
			// Another base case. When column is 1 , the value is always equal to row
			if(column==1)
				return row;
			else
			// Recursive call
			return CalculatePascalsTriangleValue(row-1,column-1)+CalculatePascalsTriangleValue(row-1,column);
		}
	}
	

	// For testing the function directly above . Prints the Pascal triangle in the familiar format as shown in the document
	public static void printPascalTriangle(int row) {
		
		// Assuming the rows start from 0
		++row;
		
		// In row
		for(int run =0;run<row;run++) {

			int no = 1;
			
			// This makes spacing between the integers in triangle dynamic
			int spacing=3;
			
			// Formats the rows
			System.out.format("%"+(row-run)*spacing+"s","");
			
			// In column
			for(int internalRun=0;internalRun<=run;internalRun++) {
			
				//Formats the columns
				System.out.format("%"+2*spacing+"d",CalculatePascalsTriangleValue(run,internalRun));
			
			    no = no * (run - internalRun) / (internalRun + 1);			                 
			
			 }
			
			  System.out.println();
			
		}

	  }
	
	
	
	public static void main(String[] args){
			
		System.out.println("Hello! With this program, you have two options \n");
		System.out.println("Press '1' to get the value in the triangle at specfic coordinates.");
		System.out.println("Press '2' to print out the Pascal Triangle for testing purposes.");
		System.out.println("\n------------------------------------------------------------------\n");
		
		// All the do while loops are just used to validate the data input from the user
		
		int choice=0;
		
		do
		{
			try{
				Scanner sc = new Scanner(System.in);
				System.out.print("Choice :");
				choice=sc.nextInt();
				
				// This way catch handles both types of invalid data.
				if(choice !=1 && choice!=2)
					throw new java.util.InputMismatchException();
				
			}
			catch(java.util.InputMismatchException e){
			
				System.out.println("Invalid selection.Try again\n");
				choice=0;
				
			}
		}while(choice==0);
		
		System.out.println();
		
		if(choice==2){
			
			int maxRows=-1;
			
			do
			{
				try{
					Scanner sc = new Scanner(System.in);
					System.out.print("Enter max rows to print ( Have to be greater than or equal to 0) :");
					maxRows=sc.nextInt();
					
					//This way catch handles both types of invalid data
					if(maxRows<0)
						throw new java.util.InputMismatchException();
					
				}
				catch(java.util.InputMismatchException e){
				
					System.out.println("Invalid input.Try again\n");
					maxRows=-1;
					
				}
			}while(maxRows==-1);
			
			System.out.println("\nNote: Lines printed will always be rows+1 since it is being assumed that rows start from 0 in this quiz");
			System.out.println("\n\n");
			
			printPascalTriangle(maxRows);
		
		}
		
		else{
			
			boolean check=false;
		
			String result="";
			
			do{
				try
				{
					check=false;
					Scanner sc=new Scanner(System.in);
					System.out.print("Enter the row :");
					int x=sc.nextInt();
					System.out.print("Enter the column :");
					int y=sc.nextInt();
					System.out.println();
					result=getValue(x,y);
				}
				catch(java.util.InputMismatchException e)
				{
					check=true;
					System.out.println("Invalid input. Try again");
				}
				
			}while(check);

			System.out.println("Result: "+result);
		}
		
	}
	

	
	
	
	
}
