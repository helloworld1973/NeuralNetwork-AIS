package bp;

public class Ais
{
  public static double[][][] weights;
  public static double[][] biases;//��һά��layerindex
  
  public Ais(double[][][] weights,double[][] biases)
  {
	  this.biases=biases;
	  this.weights=weights;
  }
  
}
