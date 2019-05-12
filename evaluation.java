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
public class evaluation {
String state="Both";
int h1=0;
int h2=24;
float gamma=0.6f;
int nb=10;
//int minute=60;
String Location="Gronlandsgade-[PR]";
float epsilon=1.0f;
int n=400;
Frequency OT[]=new Frequency [n];
Frequency O[]=new Frequency [n];    
Frequency I[]=new Frequency [n]; 
int indiceO=0, indiceI=0;
int indiceT=0;
float recall=0;
float precision=0;
float Fmeasure=0;
float sum=0;
float AUC=0;

void eval() throws FileNotFoundException, ParseException
    {
AllStatistic s=new AllStatistic();
//s.AllFlowFrequency(h1, h2, state, Location);
for (int i=0; i<nb;i++)
{  
    s.T[i]=new Frequency();
    s.T[i].intialization();
}
s.ReadFDP(h1, h2, state, Location);
s.displayFF();

KNNFDP model1 =new KNNFDP();
LOFFDP model2 =new LOFFDP();


for (gamma=1.0f; Float.compare(gamma, 0)>0; gamma=(float)gamma-0.1f)
{
   s.GenerateTest(gamma, nb);
for(int k=2;k<=10; k++)
{   
/*
  for (int i=0; i<nb; i++)
  {
      
      model1.KNNFlow(s.T[i], s.D1, s.index, 1, k);
  }
        s.sorting(s.T, nb);
      ComputeMeasure(s.T, s.D1, s.index);
      s.clear();
    // System.out.println(k+ "  "+gamma+" "+recall);
   /*     s.clear();
      model1.KNNFlow(s.T[i], s.D1, s.index, 2, k);
      s.sorting(s.T, nb);
      s.clear();
      model1.KNNFlow(s.T[i], s.D1, s.index, 3, k);
      s.sorting(s.T, nb);
      s.clear();
      model1.KNNFlow(s.T[i], s.D1, s.index, 4, k); 
      s.sorting(s.T, nb);
      s.clear();
    */
 
   for (int i=0; i<s.index; i++)
  {
      
      model2.lofFlow(s.D1[i], s.D1, s.index, 1, k);
  }
   
  for (int i=0; i<nb; i++)
  {
      
      model2.lofFlow(s.T[i], s.D1, s.index, 1, k);
  }
     
        s.sorting(s.D1, s.index);
        s.sorting(s.T, nb);
        Construct(s.D1, s.T, s.index, nb);
        System.out.println(k+","+ gamma+ ","+precision);
        indiceO=0;
        indiceI=0;
        indiceT=0;
        
     /*
      model2.lofFlow(s.T[i], s.D1, s.index, 2, k);   
      s.sorting(s.T, nb);
      s.clear();
      model2.lofFlow(s.T[i], s.D1, s.index, 3, k); 
      s.sorting(s.T, nb);
      s.clear();
      model2.lofFlow(s.T[i], s.D1, s.index, 4, k);  
      s.sorting(s.T, nb);
      s.clear();
      */
}
}

}

/*************************************************************/
void  Construct(Frequency DB[], Frequency Test[], int size1, int size2)
{
   indiceI=0;
    indiceO=0;
for (int i=0;i<size1;i++)
{


if (Float.compare(DB[i].score, epsilon) >=0)
{
O[i]=new Frequency();
O[i]=DB[i];
indiceO++;
}
else 
{
I[i]=new Frequency();
I[i]=DB[i];
indiceI++;
}


}

for (int i=0;i<size2;i++)
{
if (Float.compare(Test[i].score, epsilon) >=0)
{
OT[i]=new Frequency();
OT[i]=DB[i];
indiceT++;
}
}

/***********************************************************************/
recall= (float) indiceO/size1;
precision=(float)(indiceT+indiceO)/(size1+nb);
Fmeasure=(float)(2*recall*precision)/(recall+precision);
  
 sum=0;
for (int i=0;i<indiceO;i++)
{
sum=sum+O[i].score;
}
sum=(float)sum/size1;
        
}    

void ComputeMeasure(Frequency O[], Frequency I[], int sizeO, int sizeI)
{
/**************************Recall ***********************/
//int a=ConstructOA(OA, O, sizeO);
int b=nb;
//recall=a;
}
        
}