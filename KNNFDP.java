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
public class KNNFDP {

int n=400;
int score[]=new int[n];
 int KNN[]=new int[n];
 float Tab[]=new float[n];

/***************Distribution Data************************/
void KNNDistribution(Distribution o, Distribution D1[], int index, int k)
    {
Distance d=new Distance();

 //for (int i =0; i<I.n;i++)
 //{
  for (int j =0; j<index;j++)
  {
   Tab[j]=d.EuclidianPDF(o, D1[j]);
   KNN[j]=j;
  }

  for (int l =0; l < index; l++)
  {
    for (int r =l+1; r<index;r++)
     {
      int compare=Float.compare(Tab[r], Tab[l]);
      if (compare< 0)
      {
          float c=Tab[l];
          Tab[l]=Tab[r];
          Tab[r]=c;
          KNN[l]=r;
          KNN[r]=l;
      }
     }
  }

o.score=Tab[k-1];
    }

/***************Flow Data************************/
void KNNFlow(Frequency o, Frequency D1[], int index, int distance, int k)
    {
Distance d=new Distance();

  for (int j =0; j<index;j++)
  {
 if (distance==1)
{
  Tab[j]=d.EuclidianFlow(o, D1[j]);
}

if (distance==2)
{
  Tab[j]=d.JaccardFlow(o, D1[j]);
}

if (distance==3)
{
  Tab[j]=d.BhattacharyyaFlow(o, D1[j]);
}

if (distance==4)
{
 Tab[j]=d.KLDivergenceFlow(o, D1[j]);
}
   KNN[j]=j;
  }

  for (int l =0; l < index; l++)
  {
    for (int r =l+1; r<index;r++)
     {
      int compare=Float.compare(Tab[r], Tab[l]);
      if (compare< 0)
      {
          float c=Tab[l];
          Tab[l]=Tab[r];
          Tab[r]=c;
          KNN[l]=r;
          KNN[r]=l;
      }
     }
  }

o.score=Tab[k-1];
    }
}
