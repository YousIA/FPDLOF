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
public class ContextReference {
     int k=20;
    Centre centers[]=new Centre[k];


/**********************$$$$************/
void initialiser_centers(DataInstance I)
{
for (int i=0;i<k;i++)
  {
      centers[i]=new Centre();
      centers[i].centre=new Objects();
      centers[i].centre.x=I.D[i].x;
    I.kmeans_results[i]=i;
  }
}
/*****************************affectation des clusters************/
void assigned_clusters(DataInstance I)
{

for (int i=0;i<I.n;i++)
{

	float min=euclidian(I.D[i], centers[0].centre);
    int indice=0;
	for (int j=1;j<k;j++)
        {
	float d=euclidian(I.D[i], (Objects)centers[j].centre);
		if (d<min){indice=j;}
         }
I.kmeans_results[i]=indice;
}
}
/*********************************************************/
void FC(int cluster, DataInstance I)
{
	int s=0;
        Objects O=new Objects();
        O.x=0;
	
  for (int i=0;i<I.n; i++)
{
    if (I.kmeans_results[i]==cluster)
    {
          s++;
    	  O.x=O.x+I.D[i].x;
    }
}
        O.x=(float)O.x/s;
        centers[cluster].centre=O;
}
/***************************Kmeans_function*****************************************/
void Kmeans_function(DataInstance I)
{
int iteration=0;
initialiser_centers(I);
assigned_clusters(I);
while (iteration<1)
{
for (int i=0;i<k;i++)
{
FC(i, I);
}
assigned_clusters(I);
iteration++;
}
}

float euclidian(Objects O1, Objects O2)
{
float sum=(float)Math.pow((double)(O1.x-O2.x), 2);
float d=(float)Math.sqrt(sum);
return(d);
}
/********************************************************/
void Display_Kmeans_results(DataInstance I)
{
System.out.println("*************clustering results*************");
I.minSize=I.n;
int nb;
         for (int i = 0; i < k; i++) {
             System.out.println("Cluser "+i);
       nb=0;
                      for (int j = 0; j < I.n; j++) {

                          if (I.kmeans_results[j]==i)
                          {
                        nb++;
			System.out.print(j +"  ");
                          }
                                                   }
       if (nb<I.minSize) {I.minSize=nb;}

                      System.out.println();

	                            }

System.out.println("minimal size is "+ I.minSize);
}
/**************************************************/
int ClusterSize(int cluster, DataInstance I)
{
    int card=0;
  for (int j = 0; j < I.n; j++) {

                          if (I.kmeans_results[j]==cluster)
                          {
                        card++;
                          }
                               }
    return card;
}
}
