package sudoku2;

import java.util.*;

public class main {
	static int sudoku[][] = { 
			{ 2, 0, 0, 8, 0, 4, 0, 0, 6 }, 
			{ 0, 0, 6, 0, 0, 0, 5, 0, 0 }, 
			{ 0, 7, 4, 0, 0, 0, 9, 2, 0 }, 
			{ 3, 0, 0, 0, 4, 0, 0, 0, 7 }, 
			{ 0, 0, 0, 3, 0, 5, 0, 0, 0 }, 
			{ 4, 0, 0, 0, 6, 0, 0, 0, 9 }, 
			{ 0, 1, 9, 0, 0, 0, 7, 4, 0 }, 
			{ 0, 0, 8, 0, 0, 0, 2, 0, 0 }, 
			{ 5, 0, 0, 6, 0, 8, 0, 0, 1 } };
	
	public node[][] m_nodes;
	
	public List<Integer> initializeValues(node Node){
		List<Integer> values = new ArrayList<Integer>();
		//Check  row
		for (int r = 0; r < 9; r++) {
			if(sudoku[Node.row][r] > 0){
				values.add(sudoku[Node.row][r]);
			}	
		}
		
		//Check column
		for(int c = 0; c < 9; c++){
			if(sudoku[c][Node.col] > 0){
				values.add(sudoku[c][Node.col]);
			}
		}
		
		//Check inner box
		int xi = (Node.row /3)*3;
		int yi = (Node.col /3)*3;
		int xf = xi + 2;
		int yf = yi + 2;
		
		for(int x = xi; x <= xf; x++){
			for(int y = yi; y <= yf; y++){
				if(sudoku[x][y] > 0){
					values.add(sudoku[x][y]);
				}
			}
		}
		
		return values;
	}
	
	public void initializeNodes(){
		for(int i =0; i< sudoku.length; i++){
			for(int j =0; j< sudoku[i].length; j++){
				if(sudoku[i][j] > 0){
					node n_node = new node(i, j);
					List<Integer> possible =this.initializeValues(n_node);
					boolean update = n_node.updateValues(possible);
					this.m_nodes[i][j] = n_node;
				}else{
					m_nodes[i][j] = null;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
