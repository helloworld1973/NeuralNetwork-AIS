package bp;
import data.Dataset;

public abstract class NeuralNetwork {

	public abstract void trainModel(Dataset trainSet,double threshold);
	public abstract double predict(Dataset testSet,String outName);
	

}
