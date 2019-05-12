/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdp;

/**
 *
 * @author djenouri
 */
public class DistanceBasedOutliers {
    void DBO(float radius, int percentage, DataInstance I)
{
   
    Distance d=new Distance();
    System.out.println("Outliers Data");
for (int i =0; i<I.n;i++)
{
  int card=0;
  for (int j =0; j<I.n;j++)
  {
   int compare=Float.compare(d.euclidian(I.D[i], I.D[j]), radius);
   if(compare < 0)
    card++;
  }
 if (card < percentage )
 {
 System.out.println(I.D[i].x);
 }
}

}

/**********************************************/
void KNNOutlier(int k, DataInstance I, float threshold)
{
     Distance d=new Distance();

 for (int i =0; i<I.n;i++)
 {
 
  for (int j =0; j<I.n;j++)
  {
   I.Tab[j]=d.euclidian(I.D[i], I.D[j]);
  }

  for (int l =0; l<I.n;l++)
  {
    for (int r =l+1; r<I.n;r++)
     {
      int compare=Float.compare(I.Tab[r], I.Tab[l]);
      if (compare< 0)
      {
          float c=I.Tab[l];
          I.Tab[l]=I.Tab[r];
          I.Tab[r]=c;
      }
     }
  }
  I.ScoreOutlier[i]=0;
  for (int l =0; l<k;l++)
  {
      I.ScoreOutlier[i] = I.ScoreOutlier[i] + I.Tab[l];
  }
  int compare=Float.compare(I.ScoreOutlier[i], threshold);
  if (compare<0)
  {
  System.out.print("Intlier"+ "   ");
  }
 else
 {
 System.out.print("Outlier"+ "   ");
 }
  System.out.println(I.ScoreOutlier[i]);
  
  
}
}

/*************************************proposed by Ghoting et al 2006****************************************/
void RBRP(DataInstance I, float threshold)
{
    Distance d=new Distance();

    for (int i =0; i<I.n;i++)
 {
        int nb=0;
  for (int j =0; j<I.n;j++)
  {
      if (I.kmeans_results[i]==I.kmeans_results[j])
      {
   I.Tab[nb]=d.euclidian(I.D[i], I.D[j]);
   nb++;
      }
  }

  for (int l =0; l<nb;l++)
  {
    for (int r =l+1; r<nb;r++)
     {
      int compare=Float.compare(I.Tab[r], I.Tab[l]);
      if (compare< 0)
      {
          float c=I.Tab[l];
          I.Tab[l]=I.Tab[r];
          I.Tab[r]=c;
      }
     }
  }

  I.ScoreOutlier[i]=0;
  for (int l =0; l<I.minSize;l++)
  {
      I.ScoreOutlier[i] = I.ScoreOutlier[i] + I.Tab[l];
  }
  int compare=Float.compare(I.ScoreOutlier[i], threshold);
  if (compare<0)
  {
  System.out.print("Intlier"+ "   ");
  }
 else
 {
 System.out.print("Outlier"+ "   ");
 }
  System.out.println(I.ScoreOutlier[i]);


}
}

/*************************************proposed by Fan et al 2006****************************************/
void ROF(DataInstance I, float threshold)
{

ContextReference C1=new ContextReference();


for (int i=0;i< I.n; i++)
{
     I.ScoreOutlier[i]=0;
    for (C1.k=2; C1.k< I.n; C1.k++)
{
C1.Kmeans_function(I);
  int cluster=I.kmeans_results[i];
  int actual=C1.ClusterSize(cluster, I);
  C1.k--;
  C1.Kmeans_function(I);
  int precedent=C1.ClusterSize(cluster, I);
  C1.k++;
  precedent=precedent-1;
  float rate=(float)precedent /actual;
  rate=rate/I.n;
  I.ScoreOutlier[i]=I.ScoreOutlier[i]+rate;
 }

int compare=Float.compare(I.ScoreOutlier[i], threshold);
  if (compare<0)
  {
  System.out.print("Intlier"+ "   ");
  }
 else
 {
 System.out.print("Outlier"+ "   ");
 }
  System.out.println(I.ScoreOutlier[i]);
}
}
}
