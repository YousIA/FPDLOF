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
public class LOFFDP {
int n=400;
int score[]=new int[n];
 int KNN[]=new int[n];
 float Tab[]=new float[n];
/***************************************/
void KNN(Distribution o, DataInstance I)
    {
Distance d=new Distance();
 //for (int i =0; i<I.n;i++)
 //{
  for (int j =0; j<I.n;j++)
  {
   I.Tab[j]=d.EuclidianPDF(o, I.D1[j]);
   I.KNN[j]=j;
  }

  for (int l =0; l < I.n; l++)
  {
    for (int r =l+1; r<I.n;r++)
     {
      int compare=Float.compare(I.Tab[r], I.Tab[l]);
      if (compare< 0)
      {
          float c=I.Tab[l];
          I.Tab[l]=I.Tab[r];
          I.Tab[r]=c;
          I.KNN[l]=r;
          I.KNN[r]=l;
      }
     }
  }
    //}
}

/*********************************************/
float reach_dist(Distribution p, Distribution o, DataInstance I, int k)
{

KNN(o, I);
Distance d=new Distance();
float dist=d.EuclidianPDF(p,o);
//System.out.println("distance is "+ dist);
int compare=Float.compare(dist,I.Tab[k-1]);
if (compare < 0 ){
    dist =I.Tab[k-1];
}
return dist;
}

float lrd(Distribution p, DataInstance I, int k)
{
    KNN(p, I);
    float sum=0;
for (int i=0; i<k; i++)
{
int indice=I.KNN[i];
sum=(float) sum+reach_dist(p, I.D1[indice], I, k);
}
    sum=(float) sum/k;
    sum=(float)1/sum;
    return sum;
}
float lof(Distribution p, DataInstance I, int k)
{
    float sum=0;
    float a=lrd(p, I, k);
 //  System.out.println("a is "+a);
    KNN(p, I);
    for (int i=0; i<k; i++)
    {
     int indice=I.KNN[i];
     float b =lrd(I.D1[indice], I, k);
   //  System.out.println("b is "+b);
     float fraction=(float) b/a;
     sum=(float) sum+fraction;
    }
    sum=(float)sum/k;
    sum=(float)1/sum;
return sum;
}

void  LOF(Distribution o, DataInstance I, int k)
{

float score=lof(o, I, k);
int compare=Float.compare(score, 1);
  if (compare<0)
  {
  System.out.print("Intlier"+ "   ");
  }
 else
 {
 System.out.print("Outlier"+ "   ");
 }
  System.out.println(score);
}

/***************Flow Data************************/
void KNNFlow(Frequency o, Frequency D1[], int index, int distance, int k)
    {
Distance d=new Distance();

 //for (int i =0; i<I.n;i++)
 //{
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

/*********************************************/
float reach_distFlow(Frequency p, Frequency o, Frequency D1[], int index, int distance, int k)
{
float dist=0;
KNNFlow(o, D1, index, distance, k);
Distance d=new Distance();
if (distance==1)
{
 dist=d.EuclidianFlow(p,o);
}

if (distance==2)
{
 dist=d.JaccardFlow(p,o);
}

if (distance==3)
{
 dist=d.BhattacharyyaFlow(p,o);
}

if (distance==4)
{
 dist=d.KLDivergenceFlow(p,o);
}

int compare=Float.compare(dist,Tab[k-1]);
if (compare < 0 ){
    dist =Tab[k-1];
}
return dist;
}
float lrdFlow(Frequency p, Frequency D1[], int index, int distance, int k)
{
    KNNFlow(p, D1, index, distance, k);
    float sum=0;
for (int i=0; i<k; i++)
{
int indice=KNN[i];
sum=(float) sum+reach_distFlow(p, D1[indice], D1, index, distance, k);
}
    sum=(float) sum/k;
    if (Float.compare(sum,0)!=0)
    sum=(float)1/sum;
    
 return sum;
}
void lofFlow(Frequency p, Frequency D1[], int index, int distance, int k)
{
    float sum=0;
       float fraction;  
    float a=lrdFlow(p, D1, index, distance, k);
 //  System.out.println("a is "+a);
    KNNFlow(p, D1, index, distance, k);
    for (int i=0; i<k; i++)
    {
     int indice=KNN[i];
     float b =lrdFlow(D1[indice], D1, index, distance, k);
   //  System.out.println("b is "+b);

   if (Float.compare(a,0)==0) {fraction=0;}
   else {
    fraction=(float) b/a;
        }
       sum=(float) sum+fraction;
    }
    sum=(float)sum/k;
    if (Float.compare(sum,0)!=0) sum=(float)1/sum;
   
p.score=sum;
}
}