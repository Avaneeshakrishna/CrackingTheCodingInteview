
/*
 * 
 * PROBLEM: Rotate Matrix
 * 
 * 			"Given a NxN matrix, perform an operation to rotate this matrix by 90 degrees."
 * 
 * 
 * Example:

consider matrix size = 4			Result                   
           
			       1 2 3 4      	4 9 5 1                   
			       5 6 7 8	 --> 	5 1 6 2					  
		               9 1 2 3		6 2 7 3			  
		       	       4 5 6 7		7 3 8 4				 	
           
 Solution:
            * implement by using layers
            * perform circular rotation on each layer, moving 
              
              
              left edge to 	--> 	top edge     OR     top[i] 	 = 	left[i]
              bottom edge to 	--> 	left edge,   OR     left[i] 	 = 	bottom[i]
              right edge to 	--> 	bottom edge, OR     bottom[i]    = 	right[i]
              top edge to 	-->     right edge   OR	    right[i] 	 = 	top[i]
 





*/

import java.util.*;
public class Rotate_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the square matrix");
		int n = sc.nextInt();							     // enter size of the matrix
		int[][] matrix = new int[n][n];
		System.out.println("Enter the values");
		for (int i=0; i<n; i++) {						     // enter values for the matrix
			for (int j=0; j<n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		for (int layer=0; layer<n/2; ++layer) {					     // for every layer perform operation
			int first = layer;
			int last = n - 1 - layer;
			
			for (int i=first; i<last; ++i) {                              	     // updates elements within the layers
				int offset = i - first;                                  
				int top = matrix[first][i];                               
				matrix[first][i] = matrix[last-offset][first];               // updates top edge with left edge    (top[i] =left[i])                 
				matrix[last-offset][first] = matrix[last][last-offset];      // updates left edge with bottom edge (left[i] = bottom[i])
				matrix[last][last-offset] = matrix[i][last];                 // updates bottom edge with right edge (bottom[i] = right[i])
				matrix[i][last] = top;					    // updates right edge with top edge    (right[i] = top[i])
			}
		}
		System.out.println("After rotating matrix by 90 degree");            
		for (int i=0; i<n; i++) {						    // display result
			for (int j=0; j<n; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.print("\n");
		}
		

	}

}
