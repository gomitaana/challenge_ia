package sudoku2;

import java.util.*;
import java.util.stream.*;

public class node {
	//Dimensions of the node
	int row;
	int col;
	int values[]={0,0,0,0,0,0,0,0,0};
	
	public node(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	public void printNode(){
		System.out.println("Position: " + row + ", " + col);
	}
	
	public boolean updateValues(List<Integer> value_asg){
		//First reset all values
		for(int i =0; i<this.values.length; i++){
			this.values[i]=0;
		}
		//Assign 1 to the values the node cannot use
		for(int i =0; i < value_asg.size(); i++ ){
			this.values[value_asg.get(i)-1] = 1;
		}
		
		//check if it has possible values
		boolean contains = IntStream.of(this.values).anyMatch(x -> x == 0);
		
		return contains;
	}
	
	public void resetValues(){
		for(int i =0; i<this.values.length; i++){
			this.values[i]=0;
		}
	}
	
	public int[] getValues(){
		return this.values;
	}
}
