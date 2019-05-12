/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdp;
import java.util.Random;
/**
 *
 * @author djenouri
 */
public class DataInstance {
     int n=150;
 int m=5;
 int t=5;
Objects D[]=new Objects [n];
 Distribution D1[]=new Distribution [n];
 Distribution T1[]=new Distribution [t];
 int KNN[]=new int[n];
 float ScoreOutlier[]=new float[n];
 float Tab[]=new float[n];
int kmeans_results[]=new int[n];
int minSize;

void DataInputDownload()
 {
     Random r=new Random();
for (int i =0; i<n;i++)
{
    D[i]=new Objects();
D[i].x=(float)r.nextGaussian();
System.out.println(D[i].x);
}
     System.out.println("************************************");
 }

 /***********************************************/
 void GenerateDistribution()
{
Random r=new Random();

for (int i=0; i<n; i++)
{
   
    D1[i]=new Distribution();
    for (int j=0; j<m;j++)
    {
Observation s=new Observation();
  s.flow=j+1;
  s.prob=(float) r.nextGaussian();
   if (s.prob<0)
   {
   s.prob=s.prob*(-1);
   }
 //   D1[i].O.add(s);
    Observation ss=new Observation();
   // ss=D1[i].O.get(j);
    System.out.print("("+ss.flow+","+ss.prob+")");
    }
System.out.println();
}
     
 }
 /****************************************************/
 void GenerateTest()
{
Random r=new Random();

for (int i=0; i<t; i++)
{

    T1[i]=new Distribution();
    for (int j=0; j<m;j++)
    {
Observation s=new Observation();
  s.flow=j+1;
  s.prob=(float) r.nextGaussian();
   if (s.prob<0)
   {
   s.prob=s.prob*(-1);
   }
    //T1[i].O.add(s);
    Observation ss=new Observation();
   // ss=T1[i].O.get(j);
    System.out.print("("+ss.flow+","+ss.prob+")");
    }
System.out.println();
}

 }
 /*****************************************************/

 void displayDistribution()
 {
 for (int i =0; i<n; i++)
  {
     System.out.println();
   for (int j =0; j<m; j++)
   {
    //System.out.print("("+D1[i].O.get(j).flow+","+D1[i].O.get(j).prob+")");
   }
  }
  }
 /***********************************************/

 void display_Score_Outliers()
 {
 for (int i =0; i<n;i++)
{
System.out.println(ScoreOutlier[i]);
}

 }
}
