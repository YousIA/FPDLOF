/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdp;
import java.io.FileNotFoundException;
import java.text.ParseException;
/**
 *
 * @author djenouri
 */
public class FDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        // TODO code application logic here
//evaluation e=new evaluation();
//e.eval();
//DataInstance I=new DataInstance();
//I.GenerateDistribution();
///I.GenerateTest();
//I.displayDistribution();
//Distance d=new Distance();
//d.EuclidianPDF(I.D1[0], I.D1[1]);
//   I.DataInputDownload();
//ContextReference C=new ContextReference();
   // DistanceBasedOutliers model1=new DistanceBasedOutliers();

//model1.DBO(1, 4, I);
//float threshold=new Float(0.1);
//model1.KNNOutlier(2, I, threshold);
//C.Kmeans_function(I);
//C.Display_Kmeans_results(I);
//model1.RBRP(I, threshold);

 // model1.ROF(I, threshold);
//System.out.println("/*******************Processing*****************************/");

//  LOFFDP model2 =new LOFFDP();
/*for (int i=0;i < I.t; i++)
  {
  model1.KNN(I.T1[i], I);
  }*/
String state="Both";
int h1=0;
int h2=24;
//int minute=60;
String Location="AllokeAlle[PR]";
manipulation m=new manipulation();
m.lect_fich2(Location);
AllStatistic s=new AllStatistic();
s.AllFlowFrequency(h1, h2, state, Location);
s.ReadFDP(h1, h2, state, Location);
s.displayFF();
//KNNFDP model1 =new KNNFDP();
LOFFDP model2 =new LOFFDP();
for (int i=0; i<s.index; i++)
{

      //model1.KNNFlow(s.D1[i], s.D1, s.index, 1, 5);
	model2.lofFlow(s.D1[i], s.D1, s.index, 1, 5);
}
s.sorting(s.D1, s.index);
String Output=s.displayFF();
//s.SaveOutputFile(Output, h1, h2, state, "KNN", Location);
/*******************************/
/*m.AverageWeather();
m.WeatherDay(16, 4);
m.WeatherDay(26, 3);
m.WeatherDay(28, 2);
m.WeatherDay(4, 4);
m.WeatherDay(1, 1);
m.WeatherDay(15, 3);
m.WeatherDay(10, 9);
m.WeatherDay(9, 9);
m.WeatherDay(3, 9);
m.WeatherDay(9, 2);
m.WeatherDay(8, 2);
m.WeatherDay(23, 6);
m.WeatherDay(10, 3);
m.WeatherDay(8, 2);
m.WeatherDay(9, 2);
m.WeatherDay(8, 3);
m.WeatherDay(23, 2);
m.WeatherDay(14, 2);
m.WeatherDay(3, 5);
m.WeatherDay(26, 6);
m.WeatherDay(14, 2);
m.WeatherDay(23, 2);
m.WeatherDay(1, 1);
m.WeatherDay(8, 3);
m.WeatherDay(23, 1);
m.WeatherDay(8, 3);
m.WeatherDay(19, 5);
m.WeatherDay(23, 2);
m.WeatherDay(1, 1);
m.WeatherDay(12, 7);


/*
AllStatistic s=new AllStatistic();
s.AllFlowFrequency(h1, h2, state, Location);
s.ReadFDP(h1, h2, state, Location);
s.displayFF();
KNNFDP model1 =new KNNFDP();
//LOFFDP model2 =new LOFFDP();
for (int i=0; i<s.index; i++)
{

      model1.KNNFlow(s.D1[i], s.D1, s.index, 1, 5);
    
}
s.sorting(s.D1, s.index);
String Output=s.displayFF();
s.SaveOutputFile(Output, h1, h2, state, "KNN", Location);

   System.out.println(Output);
//manipulation m=new manipulation();
//m.lect_fich2();
//AllStatistic ss=new AllStatistic();
//s.FlowFrequencyLocation(0, h1, h2, state, minute);

//s.ReadFDP(h1, h2, state, minute);
//s.displayFF();
/*
KNNFDP model1 =new KNNFDP();
for (int i=0; i<s.index; i++)
{

      model1.KNN(s.D1[i], s.D1, s.index);
      System.out.println(s.D1[i].score);
    
}
//String s1=ss.AllFlowFrequencyLocation(0, h1, h2, state);
//merge 
  s.sorting();
  String Output=s.displayFF();
  s.SaveOutputFile(Output, h1, h2, state, "KNN", minute);
   
   System.out.println(Output);


//s.ReadFDP(h1, h2, state);

//s.displayFF();

  /*KNNFDP model1 =new KNNFDP();
for (int i=0; i<s.index; i++)
{

        model1.KNN(s.D1[i], s.D1, s.index);
      System.out.println(s.D1[i].score);

}

  s.sorting();
  String Output=s.displayFF();
  s.SaveOutputFile(Output, h1, h2, state, "KNN");

   System.out.println(Output);
*/
    }
    
}
