import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	
	//int pointNum = 32;
	
	//List<DataPoint> full = DataSet.readDataSet(args[0]);
	
	//DataPoint point = full.get(pointNum);
		
	//TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	
	
	//List<DataPoint> full = DataSet.readDataSet(args[0]);
		
	//List<DataPoint> testData = DataSet.getTestSet(full,.2);
		
		
	//List<DataPoint> trainingData = DataSet.getTrainingSet(full,.8);
	
	//initial values 
	
	int k = 3;
	
	int totalIterations = 1000;
	
	double percentDistribution = 0.3;
	


    // TASK 4: write a new method in DataSet.java which takes as arguments two DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
	
	
	//done



    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make and print a predicted target label
	
	
	KNNClassifier objectClassifier = new KNNClassifier(k);
	
	//DataPoint[] closestNeighbours = objectClassifier.getNearestNeighbours(full,point);
	
	


    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
	
	
	
	double[] accuracyPerIteration = new double[totalIterations];
	
	double[] recallAccuracyPerIteration = new double[totalIterations];
		
	double[] precisionPerIteration = new double[totalIterations];
	
	double correctCounter = 0.0;
	
	double correctMalignantCounter = 0.0;
	
	double falseMalignantCounter = 0.0;
	
	double correctBenignCounter = 0.0;
	
	double falseBenignCounter = 0.0;
	
	double accuracy = 0.0;

	double percentTestData = percentDistribution;
	
	double percentTrainingData = 1.0 - percentTestData;
	

	for(int w=0; w<totalIterations; w++)
	{
		
		List<DataPoint> full = DataSet.readDataSet(args[0]);
		
		List<DataPoint> testData = DataSet.getTestSet(full,percentTestData);
		
		
		List<DataPoint> trainingData = DataSet.getTrainingSet(full,percentTrainingData);
			
			
	for(int i=0;i<testData.size();i++)
	{
	
		
		{
			if ((objectClassifier.predict(trainingData, testData.get(i))).equals(testData.get(i).getLabel()))
			{
				correctCounter++;
			}
			
			if ((objectClassifier.predict(trainingData, testData.get(i))).equals(testData.get(i).getLabel())&&(objectClassifier.predict(trainingData, testData.get(i))).equals("malignant"))
			{
				correctMalignantCounter++;
			}
			
			if ((!(objectClassifier.predict(trainingData, testData.get(i))).equals(testData.get(i).getLabel()))&&(objectClassifier.predict(trainingData, testData.get(i))).equals("malignant"))
			{
				falseMalignantCounter++;
			}
			
			if ((objectClassifier.predict(trainingData, testData.get(i))).equals(testData.get(i).getLabel())&&(objectClassifier.predict(trainingData, testData.get(i))).equals("benign"))
			{
				correctBenignCounter++;
			}
			
			if ((!(objectClassifier.predict(trainingData, testData.get(i))).equals(testData.get(i).getLabel()))&&(objectClassifier.predict(trainingData, testData.get(i))).equals("benign"))
			{
				falseBenignCounter++;
			}
			
		}
		
		System.out.println("completed:" + i + " of " + w );
		
	}
	
	accuracy = correctCounter/testData.size()*100.0;
	
	
	accuracyPerIteration[w] = accuracy;
	recallAccuracyPerIteration[w] = correctMalignantCounter/(correctMalignantCounter+falseBenignCounter)*100.0;
	precisionPerIteration[w] = correctMalignantCounter/(correctMalignantCounter+falseMalignantCounter)*100.0;
	
	correctCounter = 0.0;
	correctMalignantCounter = 0.0;
	falseMalignantCounter = 0.0;
	correctBenignCounter = 0.0;
	falseBenignCounter = 0.0;
		
		
   }
	
	
	System.out.println("average accuracy: " + mean(accuracyPerIteration));
	System.out.println("standard deviation: " + standardDeviation(accuracyPerIteration));
	
	System.out.println("average accuracy: " + mean(recallAccuracyPerIteration));
	System.out.println("standard deviation: " + standardDeviation(recallAccuracyPerIteration));
	
	System.out.println("average accuracy: " + mean(precisionPerIteration));
	System.out.println("standard deviation: " + standardDeviation(precisionPerIteration));
	
  }
  
  
  
	public static double mean(double[] arr) {
  /*
  Method that takes as an argument an array of doubles
  Returns: average of the elements of array, as a double
  */
  double sum = 0.0;

  for (double a : arr){
    sum += a;
  }
  return (double)sum/arr.length;
	} // end mean

	public static double standardDeviation(double[] arr) {
  /*
  Method that takes as an argument an array of doubles
  Returns: standard deviation of the elements of array, as a double
  Dependencies: requires the *mean* method written above
  */
  double avg = mean(arr);
  double sum = 0.0;
  for (double a : arr){
    sum += Math.pow(a-avg,2);
  }
  return (double)sum/arr.length;
	}	// end standardDeviation

}
