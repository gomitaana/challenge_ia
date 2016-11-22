package digitrecognition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultilayerNeuralNet {

    private double rate;
    private int input;
    private int layer;
    private int output;
    private double[][] weights1layer;
    private double[][] weight2layer;
    
    private double[] inputs;
    private double[] ah;
    private double[] ao;
    private int iters;

    public MultilayerNeuralNet() {
        this.rate = 0.70;
	this.input   = 101;
	this.layer  = 26;
	this.output  = 10;
	this.weights1layer = new double[this.input][this.layer];
	this.weight2layer = new double[this.layer][this.output];
	this.inputs 		 = new double[this.input];
	this.ah 		 = new double[this.layer];
	this.ao 		 = new double[this.output];
	ah[this.layer - 1]   = 1.0;
	inputs[this.input  - 1]   = 1.0;
	getWeights();
        training();
        //train();
    }
    
    public int getResult(int[] intBits) {
        System.out.println("Valor: ");
        forwardPropagation(intBits);
        return getResult();
    }

    private void getWeights() {
        double min = -1.0, max = 1.0;
        for (int i = 0; i < input; i++){
            for (int j = 0; j < layer; j++){
                weights1layer[i][j] = min + (max - min) * Math.random();
            }
        }
            
        for (int j = 0; j < layer; j++){
            for (int k = 0; k < output; k++){
                weight2layer[j][k] = min + (max - min) * Math.random(); 
            }
        }
		 
    }
    
    private void forwardPropagation(int[] inputs) {
        for (int i = 0; i < input - 1; i++){
            this.inputs[i] = inputs[i];
        }
        
        for (int j = 0; j < layer - 1; j++) {
            ah[j] = 0.0;
            for (int i = 0; i < input; i++)
                ah[j] += weights1layer[i][j] * this.inputs[i];
                    ah[j] = activationFunction(ah[j],0);
	}
	for (int k = 0; k < output; k++) {
            ao[k] = 0.0;
            for (int j = 0; j < layer; j++){
                ao[k] += ah[j] * weight2layer[j][k];
            }
            ao[k] = activationFunction(ao[k],0);
	}
}
    
    private void backPropagation(double[] errors) {
	double[] deltak = new double[output];
	for (int k = 0; k < output; k++){
            deltak[k] = activationFunction(ao[k],1) * errors[k];
        } 
	double[] deltaj = new double[layer];
	for (int j = 0; j < layer; j++){
            for (int k = 0; k < output; k++){
                deltaj[j] += activationFunction(ah[j],1) * deltak[k] * weight2layer[j][k];
            }
        }
	for (int i = 0; i < input; i++){
            for (int j = 0; j < layer; j++){
                weights1layer[i][j] += rate * deltaj[j] * inputs[i];
            }
        }
	for (int j = 0; j < layer; j++){
            for (int k = 0; k < output; k++){
                weight2layer[j][k] += rate * deltak[k] * ah[j];
            }
        }            
    }
    
    private double activationFunction(double x,int op) {
        if(op==0){
            return Math.tanh(x);
        }else{
            return 1 - x*x;
        }
            
    }
        
    public void train(int[][] inputs, int[][] outputs, int iterLimit) {
	for (int i = 0; i < iterLimit; i++){
            for (int j = 0; j < inputs.length; j++) {
		forwardPropagation(inputs[j]);
                double[] errors = new double[output];
                for (int k = 0; k < output; k++)
                    errors[k] = outputs[j][k] - ao[k];
                        backPropagation(errors);
            }
        }
    }
    
    private int getResult() {
	if (output == 1) return (ao[0] < 0.5)? 0 : 1;
        int index = 0;
        double max = ao[0];
	for (int k = 1; k < output; k++){
            if (ao[k] > max) {
		max = ao[k]; index = k;
            }
        }
            
	return index;
    }
    
    private void training(){
        int[][] trainPatterns= new int[63][100];
        int[] outcome = new int[63];
        String line;
        char[] inputStr = new char[100];
        int i = 0;
        
        try {
            File here = new File("train_digits.txt");
            System.out.println(here.getAbsolutePath());
            Scanner trainFile = new Scanner(here);
            while (trainFile.hasNextLine()) {
                line = trainFile.nextLine();  
                //System.out.println("len: "+line.length());
                if(line.length()!=0){
                   line.getChars(0, 100, inputStr, 0);
                   for(int j=0;j<100;j++){
                     trainPatterns[i][j]= inputStr[j]; 
                   }
                   outcome[i]=line.charAt(100);
                    System.out.println("outcome " + outcome[i]);
                }
                i++;
            }
            trainFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MultilayerNeuralNet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
