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
public class DensityBasedOutliers {
    int k=3;
int KNN[]=new int[20];
/***************************************/
void KNN(Objects o, DataInstance I)
    {
Distance d=new Distance();
 for (int i =0; i<I.n;i++)
 {
  for (int j =0; j<I.n;j++)
  {
   I.Tab[j]=d.euclidian(I.D[i], I.D[j]);
   KNN[j]=j;
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
          KNN[l]=r;
          KNN[r]=l;
      }
     }
  }
}
}

float reach_dist(Objects p, Objects o, DataInstance I)
{
    
KNN(o, I);
Distance d=new Distance();
float dist=d.euclidian(p,o);
int compare=Float.compare(dist,I.Tab[k]);
if (compare < 0 ){
    dist =I.Tab[k];
}
return dist;
}

float lrd(Objects p, DataInstance I)
{
    KNN(p, I);
    float sum=0;
for (int i=0; i<k; i++)
{
int indice=KNN[i];
sum=(float) sum+reach_dist(p, I.D[indice], I);
}
    sum=(float) sum/k;
    sum=(float)1/sum;
    return sum;
}

float lof(Objects p, DataInstance I)
{
    float sum=0;
    float a=lrd(p, I);
    KNN(p, I);
    for (int i=0; i<k; i++)
    {
     int indice=KNN[i];
     float b =lrd(I.D[indice], I);
     float fraction=(float) b/a;
     sum=(float) sum+fraction;
    }
    sum=(float)sum/k;
    sum=(float)1/sum;
return sum;
}

void  LOF(DataInstance I)
{
for (int i=0; i<I.n; i++)
{
I.ScoreOutlier[i]=lof(I.D[i], I);
int compare=Float.compare(I.ScoreOutlier[i], 1);
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
