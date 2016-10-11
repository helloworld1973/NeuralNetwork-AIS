package bp;

import java.util.ArrayList;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import data.Dataset;

public class BpDemo1 {

	public static int min(ArrayList<Double> a,int size) 
	{
	    double min=a.get(0);
	    int j=0;
	    for(int i=1;i<size;i++)
	    {
			if(a.get(i)<min)
			{
				min=a.get(i);
			     j=i;
			}
	    }
		return j;
	}


	public static void logFunc() {
		 Random re = new Random(10);
		String fileName = "sample-data/002024_chang.txt";
		Dataset dataset = Dataset.load(fileName, "\t", 3, false);
		String testName = "sample-data/002024_change_test.txt";
		Dataset testset = Dataset.load(testName, "\t", 3, false);
		String outName = "sample-data/stock_test.predict";
		// 对函数进行拟合，不用对输出值进行编码
		//初始抗体亲和力大小
		ArrayList<Double> errrate=new ArrayList<Double>();
		//变异抗体亲和力大小
		ArrayList<Double> errrate1=new ArrayList<Double>();
		ArrayList<Double> errrate2=new ArrayList<Double>();
		ArrayList<Double> errrate3=new ArrayList<Double>();
		ArrayList<Double> errrate4=new ArrayList<Double>();
		ArrayList<Double> errrate5=new ArrayList<Double>();
		//变异抗体亲和力大小
		//初始抗体 
		double[][][] tweightsinit1=new double[3][50][50];
		 double[][] tbiasesinit1=new double[3][50];
		 double[][][] tweightsinit2=new double[3][50][50];
		 double[][] tbiasesinit2=new double[3][50];
		 double[][][] tweightsinit3=new double[3][50][50];
		 double[][] tbiasesinit3=new double[3][50];
		 double[][][] tweightsinit4=new double[3][50][50];
		 double[][] tbiasesinit4=new double[3][50];
		 double[][][] tweightsinit5=new double[3][50][50];
		 double[][] tbiasesinit5=new double[3][50];
	//变异抗体 	
		 double[][][] tweights1=new double[3][50][50];
		 double[][] tbiases1=new double[3][50];
		 double[][][] tweights2=new double[3][50][50];
		 double[][] tbiases2=new double[3][50];
		 double[][][] tweights3=new double[3][50][50];
		 double[][] tbiases3=new double[3][50];
		 double[][][] tweights4=new double[3][50][50];
		 double[][] tbiases4=new double[3][50];
		 double[][][] tweights5=new double[3][50][50];
		 double[][] tbiases5=new double[3][50];

		 double[][][] tweights_temp=new double[3][50][50];
		 double[][] tbiases_temp=new double[3][50];

		 //变异抗体 
          ArrayList <double[][][] >  g_tweights1=new ArrayList<double[][][]>();
          ArrayList <double[][][] >  g_tweights2=new ArrayList<double[][][]>();
          ArrayList <double[][][] >  g_tweights3=new ArrayList<double[][][]>();
          ArrayList <double[][][] >  g_tweights4=new ArrayList<double[][][]>();
          ArrayList <double[][][] >  g_tweights5=new ArrayList<double[][][]>();
          
          ArrayList <double[][] >  g_tbiases1=new ArrayList<double[][]>();
          ArrayList <double[][] >  g_tbiases2=new ArrayList<double[][]>();
          ArrayList <double[][] >  g_tbiases3=new ArrayList<double[][]>();
          ArrayList <double[][] >  g_tbiases4=new ArrayList<double[][]>();
          ArrayList <double[][] >  g_tbiases5=new ArrayList<double[][]>();


          int affinitymaxindex1 = 0;
          int affinitymaxindex2 = 0;
          int affinitymaxindex3 = 0;
          int affinitymaxindex4 = 0;
          int affinitymaxindex5 = 0;
          double affinitymax;
          int affinitymaxindex;

		  double tweights1value=-0.5;
          double tweightsinit1value=-0.5;
		  double tbiases1value=0;
		  double tbiasesinit1value=0;
		  
		  double tweights2value=0.1;
          double tweightsinit2value=0.1;
		  double tbiases2value=0;
		  double tbiasesinit2value=0;
		  
	      double tweights3value=-0.5;
          double tweightsinit3value=-0.5;
		  double tbiases3value=0.5;
		  double tbiasesinit3value=0.5;
		  
		  double tweights4value=0.1;
          double tweightsinit4value=-0.1;
		  double tbiases4value=0.5;
		  double tbiasesinit4value=0.5;
		  
		  double[][][] tweights_temp_1=new double[3][50][50];
		  double[][] tbiases_temp_1=new double[3][50];
		  double[][][] tweights_temp_2=new double[3][50][50];
		  double[][] tbiases_temp_2=new double[3][50];
		  double[][][] tweights_temp_3=new double[3][50][50];
		  double[][] tbiases_temp_3=new double[3][50];
		  double[][][] tweights_temp_4=new double[3][50][50];
		  double[][] tbiases_temp_4=new double[3][50];
		  double[][][] tweights_temp_5=new double[3][50][50];
		  double[][] tbiases_temp_5=new double[3][50];
		  
		  BPNetwork bp;
		  double errreturn;
		  double[][][] tweightscompare1=new double[3][50][50];

		  //dataset = Dataset.load(fileName, "\t", 2, false);	
          for(int imsnum=0;imsnum<5;imsnum++)
		  {
		     switch(imsnum)
			 {
			     case 0:
			            for (int i = 0; i < 3; i++) {
            				for (int j = 0; j < 20; j++) {
            					tweights1[1][i][j] = tweights1value;
            					tweightsinit1[1][i][j] = tweightsinit1value;
            				}
            			}
            	    	for (int i = 0; i < 20; i++) {
            				for (int j = 0; j < 1; j++) {
            					tweights1[2][i][j] = tweights1value;
            					tweightsinit1[2][i][j] = tweightsinit1value;
            				}
            			}
            			for (int k = 0; k < 20; k++) {
            				tbiases1[1][k] = tbiases1value;
            				tbiasesinit1[1][k] = tbiasesinit1value;
            			}
            			for (int k = 0; k < 1; k++) {
            				tbiases1[2][k] = tbiases1value;
            				tbiasesinit1[2][k] = tbiasesinit1value;
            			}
            			
						break;
				case 1:
					   for (int i = 0; i < 3; i++) {
	         				for (int j = 0; j < 20; j++) {
	         					tweights2[1][i][j] = tweights2value;
	         					tweightsinit2[1][i][j] = tweightsinit2value;
	         				}
	         			}
	         	    	for (int i = 0; i < 20; i++) {
	         				for (int j = 0; j < 1; j++) {
	         					tweights2[2][i][j] = tweights2value;
	         					tweightsinit2[2][i][j] = tweightsinit2value;
	         				}
	         			}
         				for (int k = 0; k < 20; k++) {
         					tbiases2[1][k] = tbiases2value;
         					tbiasesinit2[1][k] = tbiasesinit2value;
         				}
         				for (int k = 0; k < 1; k++) {
         					tbiases2[2][k] = tbiases2value;
         					tbiasesinit2[2][k] = tbiasesinit2value;
         				}
						break;
				case 2:
					   for (int i = 0; i < 3; i++) {
	         				for (int j = 0; j < 20; j++) {
	         					tweights3[1][i][j] = tweights3value;
	         					tweightsinit3[1][i][j] = tweightsinit3value;
	         				}
	         			}
	         	    	for (int i = 0; i < 20; i++) {
	         				for (int j = 0; j < 1; j++) {
	         					tweights3[2][i][j] = tweights3value;
	         					tweightsinit3[2][i][j] = tweightsinit3value;
	         				}
	         			}
         				for (int k = 0; k < 20; k++) {
         					tbiases3[1][k] = tbiases3value;
         					tbiasesinit3[1][k] = tbiasesinit3value;
         				}
         				for (int k = 0; k < 1; k++) {
         					tbiases3[2][k] = tbiases3value;
         					tbiasesinit3[2][k] = tbiasesinit3value;
         				}
						break;
				case 3:
					    for (int i = 0; i < 3; i++) {
	         				for (int j = 0; j < 20; j++) {
	         					tweights4[1][i][j] = tweights4value;
	         					tweightsinit4[1][i][j] = tweightsinit4value;
	         				}
	         			}
	         	    	for (int i = 0; i < 20; i++) {
	         				for (int j = 0; j < 1; j++) {
	         					tweights4[2][i][j] = tweights4value;
	         					tweightsinit4[2][i][j] = tweightsinit4value;
	         				}
	         			}
         				for (int k = 0; k < 20; k++) {
         					tbiases4[1][k] = tbiases4value;
         					tbiasesinit4[1][k] = tbiasesinit4value;
         				}
         				for (int k = 0; k < 1; k++) {
         					tbiases4[2][k] = tbiases4value;
         					tbiasesinit4[2][k] = tbiasesinit4value;
         				}
						break;
				default:
					    break;
		     }
          }
		  
	  //初始化10个抗体
		//抗体输入
	for(int diedainum=0;diedainum<5;diedainum++)
	{
		dataset = Dataset.load(fileName, "\t", 3, false);	
		 for(int imsnum=0;imsnum<5;imsnum++)
		 {
			 dataset = Dataset.load(fileName, "\t",3, false); 
			 switch(imsnum)
			 {
				 case 0:					 
						//初始化10个复制抗体
						for(int mutationnum=0;mutationnum<11;mutationnum++)
            	        {
            	            g_tweights1.add(tweightsinit1);
							g_tbiases1.add(tbiasesinit1);
						}
            			new Ais(tweightsinit1, tbiasesinit1);
						bp = new BPNetwork(new int[] { 3, 20, 1 }, false);
            		    bp.trainModel(dataset, 0.8);
            		    dataset=null;
            		    errreturn=bp.predict(testset, outName);
            		    errrate1.add(errreturn);
            		    break;
				 case 1:					 
	         	    	
						//初始化10个复制抗体
						for(int mutationnum=0;mutationnum<11;mutationnum++)
            	        {
            	            g_tweights2.add(tweightsinit2);
							g_tbiases2.add(tbiasesinit2);
						}
         				Ais.weights=tweightsinit2;
         				Ais.biases=tbiasesinit2;
						bp = new BPNetwork(new int[] { 3, 20, 1 }, false);
            		    bp.trainModel(dataset, 0.8);
            		    dataset=null;
            		    errreturn=bp.predict(testset, outName);
            		    errrate2.add(errreturn);
         		    break;
				 case 2:					 
	         	    	
						//初始化10个复制抗体
						for(int mutationnum=0;mutationnum<11;mutationnum++)
            	        {
            	            g_tweights3.add(tweightsinit3);
							g_tbiases3.add(tbiasesinit3);
						}
         				Ais.weights=tweightsinit3;
         				Ais.biases=tbiasesinit3;
						bp = new BPNetwork(new int[] { 3, 20, 1 }, false);
            		    bp.trainModel(dataset, 0.8);
            		    dataset=null;
            		    errreturn=bp.predict(testset, outName);
            		    errrate3.add(errreturn);
         		    break;
				 case 3:					 
	         	    	
						//初始化10个复制抗体
						for(int mutationnum=0;mutationnum<11;mutationnum++)
            	        {
            	            g_tweights4.add(tweightsinit4);
							g_tbiases4.add(tbiasesinit4);
						}
         				Ais.weights=tweightsinit4;
         				Ais.biases=tbiasesinit4;
						bp = new BPNetwork(new int[] { 3, 20, 1 }, false);
            		    bp.trainModel(dataset, 0.8);
            		    dataset=null;
            		    errreturn=bp.predict(testset, outName);
            		    errrate4.add(errreturn);
         		    break;
				 case 4:					 
	         	    	
						//初始化10个复制抗体
						for(int mutationnum=0;mutationnum<11;mutationnum++)
            	        {
            	            g_tweights5.add(tweightsinit5);
							g_tbiases5.add(tbiasesinit5);
						}
         				Ais.weights=tweightsinit5;
         				Ais.biases=tbiasesinit5;
						bp = new BPNetwork(new int[] { 3, 20, 1 }, false);
            		    bp.trainModel(dataset, 0.8);
            		    dataset=null;
            		    errreturn=bp.predict(testset, outName);
            		    errrate5.add(errreturn);
         		    break;
					
			     }
            	    
            		//ConcurenceRunner.stop();
            		
            		//抗体亲和度 ，建立 数组存入亲和度大小
	         }
		 //变异
		 for(int imsnum=0;imsnum<5;imsnum++)
		 {
			 dataset = Dataset.load(fileName, "\t", 3, false);	
			 switch(imsnum)
			 {
				 case 0:					 
            	    for(int mutationnum=1;mutationnum<11;mutationnum++)
            	    {
            	    	dataset = Dataset.load(fileName, "\t", 3, false);
            	    	double[][][] tweights_temp_=new double[3][50][50];
            			double[][] tbiases_temp_=new double[3][50];
            			tweights_temp_=g_tweights1.get(mutationnum);
            			tbiases_temp_=g_tbiases1.get(mutationnum);
					    for (int i = 0; i < 3; i++) {
            				for (int j = 0; j < 20; j++) {
            					tweights1[1][i][j] = tweights_temp_[1][i][j]+re.nextDouble();		
            				}
            			}
            	    	for (int i = 0; i < 20; i++) {
            				for (int j = 0; j < 1; j++) {
            					tweights1[2][i][j] = tweights_temp_[2][i][j]+re.nextDouble();
            				}
            			}
            	    	g_tweights1.set(mutationnum,tweights1);
            	    	
						for (int k = 0; k < 20; k++) {
            					tbiases1[1][k] = tbiases_temp_[1][k]+re.nextDouble();
            			}
            			for (int k = 0; k < 1; k++) {
            					tbiases1[2][k] = tbiases_temp_[2][k]+re.nextDouble();
            			}
						g_tbiases1.set(mutationnum,tbiases1);
						
						Ais.weights=g_tweights1.get(mutationnum);
         				Ais.biases=g_tbiases1.get(mutationnum);
						
						bp = new BPNetwork(new int[] { 3, 20, 1 }, false);
	            		bp.trainModel(dataset, 0.8);
	            		dataset=null;
	            		errreturn=bp.predict(testset, outName);
            		    errrate1.add(errreturn);
            	    }
            		//找到每个种群中最大的抗体
            		
            				
            		    break;
				 case 1:
				 	for(int mutationnum=1;mutationnum<11;mutationnum++)
            	    {
				 		dataset = Dataset.load(fileName, "\t", 3, false);
				 		double[][][] tweights_temp_=new double[3][50][50];
            			double[][] tbiases_temp_=new double[3][50];
            	        tweights_temp_=g_tweights2.get(mutationnum);
						tbiases_temp_=g_tbiases2.get(mutationnum);
					    for (int i = 0; i < 3; i++) {
            				for (int j = 0; j < 20; j++) {
            					tweights2[1][i][j] = tweights_temp_[1][i][j]+re.nextDouble();		
            				}
            			}
            	    	for (int i = 0; i < 20; i++) {
            				for (int j = 0; j < 1; j++) {
            					tweights2[2][i][j] = tweights_temp_[2][i][j]+re.nextDouble();
            				}
            			}
            	    	g_tweights2.set(mutationnum,tweights2);
            	    	
						for (int k = 0; k < 20; k++) {
            					tbiases2[1][k] = tbiases_temp_[1][k]+re.nextDouble();
            			}
            			for (int k = 0; k < 1; k++) {
            					tbiases2[2][k] = tbiases_temp_[2][k]+re.nextDouble();
            			}
						g_tbiases2.set(mutationnum,tbiases2);
						
						Ais.weights=g_tweights2.get(mutationnum);
         				Ais.biases=g_tbiases2.get(mutationnum);
						
						bp = new BPNetwork(new int[] { 3, 20, 1 }, false);
	            		bp.trainModel(dataset, 0.8);
	            		dataset=null;
	            		errreturn=bp.predict(testset, outName);
            		    errrate2.add(errreturn);
				 	}
         		    break;
				 case 2:					 
         	    	for(int mutationnum=1;mutationnum<11;mutationnum++)
            	    {
         	    		dataset = Dataset.load(fileName, "\t", 3, false);
         	    		double[][][] tweights_temp_=new double[3][50][50];
            			double[][] tbiases_temp_=new double[3][50];
            	        tweights_temp_=g_tweights3.get(mutationnum);
						tbiases_temp_=g_tbiases3.get(mutationnum);
					    for (int i = 0; i < 3; i++) {
            				for (int j = 0; j < 20; j++) {
            					tweights3[1][i][j] = tweights_temp_[1][i][j]+re.nextDouble();		
            				}
            			}
            	    	for (int i = 0; i < 20; i++) {
            				for (int j = 0; j < 1; j++) {
            					tweights3[2][i][j] = tweights_temp_[2][i][j]+re.nextDouble();
            				}
            			}
            	    	g_tweights3.set(mutationnum,tweights3);
            	    	
						for (int k = 0; k < 20; k++) {
            					tbiases3[1][k] = tbiases_temp_[1][k]+re.nextDouble();
            			}
            			for (int k = 0; k < 1; k++) {
            					tbiases3[2][k] = tbiases_temp_[2][k]+re.nextDouble();
            			}
						g_tbiases3.set(mutationnum,tbiases3);
						
						Ais.weights=g_tweights3.get(mutationnum);
         				Ais.biases=g_tbiases3.get(mutationnum);
						
						bp = new BPNetwork(new int[] { 3, 20, 1 }, false);
	            		bp.trainModel(dataset, 0.8);
	            		dataset=null;
	            		errreturn=bp.predict(testset, outName);
            		    errrate3.add(errreturn);
         	    	}
         		    break;
				 case 3:					 
         	    	for(int mutationnum=1;mutationnum<11;mutationnum++)
            	    {
         	    		dataset = Dataset.load(fileName, "\t", 3, false);
         	    		double[][][] tweights_temp_=new double[3][50][50];
            			double[][] tbiases_temp_=new double[3][50];
            	        tweights_temp_=g_tweights4.get(mutationnum);
						tbiases_temp_=g_tbiases4.get(mutationnum);
					    for (int i = 0; i < 3; i++) {
            				for (int j = 0; j < 20; j++) {
            					tweights4[1][i][j] = tweights_temp_[1][i][j]+re.nextDouble();		
            				}
            			}
            	    	for (int i = 0; i < 20; i++) {
            				for (int j = 0; j < 1; j++) {
            					tweights4[2][i][j] = tweights_temp_[2][i][j]+re.nextDouble();
            				}
            			}
            	    	g_tweights4.set(mutationnum,tweights4);
            	    	
						for (int k = 0; k < 20; k++) {
            					tbiases4[1][k] = tbiases_temp_[1][k]+re.nextDouble();
            			}
            			for (int k = 0; k < 1; k++) {
            					tbiases4[2][k] = tbiases_temp_[2][k]+re.nextDouble();
            			}
						g_tbiases4.set(mutationnum,tbiases4);
						
						Ais.weights=g_tweights4.get(mutationnum);
         				Ais.biases=g_tbiases4.get(mutationnum);
						
						bp = new BPNetwork(new int[] { 3, 20, 1 }, false);
	            		bp.trainModel(dataset, 0.8);
	            		dataset=null;
	            		errreturn=bp.predict(testset, outName);
            		    errrate4.add(errreturn);
         	    	}
         		    break;
				 case 4:					 
         	    	for(int mutationnum=1;mutationnum<11;mutationnum++)
            	    {
         	    		dataset = Dataset.load(fileName, "\t", 3, false);
         	    		double[][][] tweights_temp_=new double[3][50][50];
            			double[][] tbiases_temp_=new double[3][50];
            	        tweights_temp_=g_tweights5.get(mutationnum);
						tbiases_temp_=g_tbiases5.get(mutationnum);
					    for (int i = 0; i < 3; i++) {
            				for (int j = 0; j < 20; j++) {
            					tweights5[1][i][j] = tweights_temp_[1][i][j]+re.nextDouble();		
            				}
            			}
            	    	for (int i = 0; i < 20; i++) {
            				for (int j = 0; j < 1; j++) {
            					tweights5[2][i][j] = tweights_temp_[2][i][j]+re.nextDouble();
            				}
            			}
            	    	g_tweights5.set(mutationnum,tweights5);
            	    	
						for (int k = 0; k < 20; k++) {
            					tbiases5[1][k] = tbiases_temp_[1][k]+re.nextDouble();
            			}
            			for (int k = 0; k < 1; k++) {
            					tbiases5[2][k] = tbiases_temp_[2][k]+re.nextDouble();
            			}
						g_tbiases5.set(mutationnum,tbiases5);
						
						Ais.weights=g_tweights5.get(mutationnum);
         				Ais.biases=g_tbiases5.get(mutationnum);
						
						bp = new BPNetwork(new int[] { 3, 20, 1 }, false);
	            		bp.trainModel(dataset, 0.8);
	            		dataset=null;
	            		errreturn=bp.predict(testset, outName);
            		    errrate5.add(errreturn);
         	    	}
         		    break;
			     }
		 	}
            	  //找到每个种群中最大的抗体
            		//ConcurenceRunner.stop();
//            	for(int affinity=0;affinity<11;affinity++)
//            	{
            	    affinitymaxindex1=min(errrate1,11);
					affinitymaxindex2=min(errrate2,11);
					affinitymaxindex3=min(errrate3,11);
					affinitymaxindex4=min(errrate4,11);
					affinitymaxindex5=min(errrate5,11);
//            	}
				//更新初始抗体，重新进行人工免疫算法
					
                			tweights_temp_1=g_tweights1.get(affinitymaxindex1);
				            tbiases_temp_1=g_tbiases1.get(affinitymaxindex1);
				            for (int i = 0; i < 3; i++) {
	            				for (int j = 0; j < 20; j++) {
	            					tweights1[1][i][j] = tweights_temp_1[1][i][j];
	            					tweightsinit1[1][i][j] = tweights_temp_1[1][i][j];
	            				}
	            			}
	            	    	for (int i = 0; i < 20; i++) {
	            				for (int j = 0; j < 1; j++) {
	            					tweights1[2][i][j] = tweights_temp_1[2][i][j];
	            					tweightsinit1[2][i][j] = tweights_temp_1[2][i][j];
	            				}
	            			}
	            			for (int k = 0; k < 20; k++) {
	            				tbiases1[1][k] = tbiases_temp_1[1][k];
	            				tbiasesinit1[1][k] = tbiases_temp_1[1][k];
	            			}
	            			for (int k = 0; k < 1; k++) {
	            				tbiases1[2][k] = tbiases_temp_1[2][k];
	            				tbiasesinit1[2][k] = tbiases_temp_1[2][k];
	            			}

	            		
	   					    tweights_temp_2=g_tweights2.get(affinitymaxindex2);
	   					    tbiases_temp_2=g_tbiases2.get(affinitymaxindex2);
						   for (int i = 0; i < 3; i++) {
		         				for (int j = 0; j < 20; j++) {
		         					tweights2[1][i][j] = tweights_temp_2[1][i][j];
		         					tweightsinit2[1][i][j] = tweights_temp_2[1][i][j];
		         				}
		         			}
		         	    	for (int i = 0; i < 20; i++) {
		         				for (int j = 0; j < 1; j++) {
		         					tweights2[2][i][j] = tweights_temp_2[2][i][j];
		         					tweightsinit2[2][i][j] = tweights_temp_2[2][i][j];
		         				}
		         			}
	         				for (int k = 0; k < 20; k++) {
	         					tbiases2[1][k] = tbiases_temp_2[1][k];
	         					tbiasesinit2[1][k] = tbiases_temp_2[1][k];
	         				}
	         				for (int k = 0; k < 1; k++) {
	         					tbiases2[2][k] = tbiases_temp_2[2][k];
	         					tbiasesinit2[2][k] = tbiases_temp_2[2][k];
	         				}

	         				
	   					    tweights_temp_3=g_tweights3.get(affinitymaxindex3);
	   					    tbiases_temp_3=g_tbiases3.get(affinitymaxindex3);
						   for (int i = 0; i < 3; i++) {
		         				for (int j = 0; j < 20; j++) {
		         					tweights3[1][i][j] = tweights_temp_3[1][i][j];
		         					tweightsinit3[1][i][j] = tweights_temp_3[1][i][j];
		         				}
		         			}
		         	    	for (int i = 0; i < 20; i++) {
		         				for (int j = 0; j < 1; j++) {
		         					tweights3[2][i][j] = tweights_temp_3[2][i][j];
		         					tweightsinit3[2][i][j] = tweights_temp_3[2][i][j];
		         				}
		         			}
	         				for (int k = 0; k < 20; k++) {
	         					tbiases3[1][k] = tbiases_temp_3[1][k];
	         					tbiasesinit3[1][k] = tbiases_temp_3[1][k];
	         				}
	         				for (int k = 0; k < 1; k++) {
	         					tbiases3[2][k] = tbiases_temp_3[2][k];
	         					tbiasesinit3[2][k] = tbiases_temp_3[2][k];
	         				}

	         				
	   					    tweights_temp_4=g_tweights4.get(affinitymaxindex4);
	   					    tbiases_temp_4=g_tbiases4.get(affinitymaxindex4);
						    for (int i = 0; i < 3; i++) {
		         				for (int j = 0; j < 20; j++) {
		         					tweights4[1][i][j] = tweights_temp_4[1][i][j];
		         					tweightsinit4[1][i][j] = tweights_temp_4[1][i][j];
		         				}
		         			}
		         	    	for (int i = 0; i < 20; i++) {
		         				for (int j = 0; j < 1; j++) {
		         					tweights4[2][i][j] = tweights_temp_4[2][i][j];
		         					tweightsinit4[2][i][j] = tweights_temp_4[2][i][j];
		         				}
		         			}
	         				for (int k = 0; k < 20; k++) {
	         					tbiases4[1][k] = tbiases_temp_4[1][k];
	         					tbiasesinit4[1][k] = tbiases_temp_4[1][k];
	         				}
	         				for (int k = 0; k < 1; k++) {
	         					tbiases4[2][k] = tbiases_temp_4[2][k];
	         					tbiasesinit4[2][k] = tbiases_temp_4[2][k];
	         				}
	         				
	         				tweights_temp_5=g_tweights5.get(affinitymaxindex5);
	   					    tbiases_temp_5=g_tbiases5.get(affinitymaxindex5);
						    for (int i = 0; i < 3; i++) {
		         				for (int j = 0; j < 20; j++) {
		         					tweights5[1][i][j] = tweights_temp_5[1][i][j];
		         					tweightsinit5[1][i][j] = tweights_temp_5[1][i][j];
		         				}
		         			}
		         	    	for (int i = 0; i < 20; i++) {
		         				for (int j = 0; j < 1; j++) {
		         					tweights5[2][i][j] = tweights_temp_5[2][i][j];
		         					tweightsinit5[2][i][j] = tweights_temp_5[2][i][j];
		         				}
		         			}
	         				for (int k = 0; k < 20; k++) {
	         					tbiases5[1][k] = tbiases_temp_5[1][k];
	         					tbiasesinit5[1][k] = tbiases_temp_5[1][k];
	         				}
	         				for (int k = 0; k < 1; k++) {
	         					tbiases5[2][k] = tbiases_temp_5[2][k];
	         					tbiasesinit5[2][k] = tbiases_temp_5[2][k];
	         				}
	         				
	         				
			
          	}	
				//相似度过滤
				affinitymax=errrate1.get(affinitymaxindex1);
				affinitymaxindex=affinitymaxindex1;
				if(affinitymax<errrate2.get(affinitymaxindex2))
				{
				    affinitymax=errrate2.get(affinitymaxindex2);
					affinitymaxindex=affinitymaxindex2;
				}
				if(affinitymax<errrate3.get(affinitymaxindex3))
				{
				    affinitymax=errrate3.get(affinitymaxindex3);
					affinitymaxindex=affinitymaxindex3;
				}
				if(affinitymax<errrate4.get(affinitymaxindex4))
				{
				    affinitymax=errrate4.get(affinitymaxindex4);
					affinitymaxindex=affinitymaxindex4;
				}
				if(affinitymax<errrate5.get(affinitymaxindex5))
				{
				    affinitymax=errrate5.get(affinitymaxindex5);
					affinitymaxindex=affinitymaxindex5;
				}
				//找到亲和度最大的
				System.out.println("affinitymax:"+affinitymax);
                //tweights_temp[][][]=g_tweights3.get(affinitymaxindex);
				//tbiases_temp[][][]=g_tbiases3.get(affinitymaxindex);			
        //System.out.println(errrate);
	    }

	
	public static void main(String[] args) {
		logFunc();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//trainDitalClassifier();
	}
	
//	public static void logFunc() {
//		String fileName = "sample-data/func_train.txt";
//		Dataset dataset = Dataset.load(fileName, "\t", 2, false);
//		// 对函数进行拟合，不用对输出值进行编码
//		BPNetwork bp = new BPNetwork(new int[] { 2, 20, 1 }, false);
//		for(int i=0;i<10;i++)
//			
//		bp.trainModel(dataset, 0.97);
//		dataset = null;
//		String testName = "sample-data/func_test.txt";
//		Dataset testset = Dataset.load(testName, "\t", 2, false);
//		String outName = "sample-data/func_test.predict";
//		bp.predict(testset, outName);
//		ConcurenceRunner.stop();
//	}
}
