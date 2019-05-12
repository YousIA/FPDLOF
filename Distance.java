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
public class Distance {
float euclidian(Objects O1, Objects O2)
{
return 0;
}
/********************Between two distributions********************/
float EuclidianPDF(Distribution O1, Distribution O2)
{
    float d=0;
for (int i=0; i < O1.m;i++)
 {
          d=d+(float)Math.pow((O1.O[i]-O2.O[i]), 2);
 }
d=(float)Math.sqrt(d);
return (d);
}

/********************************************************/
float BhattacharyyaPDF(Distribution O1, Distribution O2)
{
      float d=0;
for (int i=0; i < O1.m;i++)
 {
  
          d=d+(float)Math.sqrt((O1.O[i]*O2.O[i]));
 }
d=(float)-Math.log10(d);
return (d);
}
/*********************************************************/
float JaccardPDF(Distribution O1, Distribution O2)
{
      float d=0;
      float sum1=0;
      float sum2=0;
      float sum3=0;
for (int i=0; i < O1.m;i++)
 {
          sum1=sum1+O1.O[i]*O2.O[i];
          sum2=sum2+(float)Math.pow(O1.O[i],2);
          sum3=sum3+(float)Math.pow(O2.O[i],2);
 }
      d=sum1/(sum2+sum3-sum1);
d=(float)-Math.log10(d);
return (d);
}
/**********************************************************/
float KLDivergencePDF(Distribution O1, Distribution O2)
{
      float d=0;
      float a=0;
      float b=0;
      float c=0;
for (int i=0; i < O1.m;i++)
 {
          a=2*O1.O[i];
          b=O1.O[i];
          c=O2.O[i];
          d=d+(b*(float)Math.log10(a/(b+c)));
         
 }
return (d);
}
/****************************distance between two flows**************************/
float EuclidianFlow(Frequency O1, Frequency O2)
{
    float d=0;
for (int i=0; i < O1.m;i++)
 {
          d=d+(float)Math.pow((O1.Flow[i]-O2.Flow[i]), 2);
 }
d=(float)Math.sqrt(d);
return (d);
}
/********************************************************/
float BhattacharyyaFlow(Frequency O1, Frequency O2)
{
      float d=0;
for (int i=0; i < O1.m;i++)
 {
  
          d=d+(float)Math.sqrt((O1.Flow[i]*O2.Flow[i]));
 }
d=(float)-Math.log10(d);
return (d);
}
/*********************************************************/
float JaccardFlow(Frequency O1, Frequency O2)
{
      float d=0;
      float sum1=0;
      float sum2=0;
      float sum3=0;
for (int i=0; i < O1.m;i++)
 {
          sum1=sum1+O1.Flow[i]*O2.Flow[i];
          sum2=sum2+(float)Math.pow(O1.Flow[i],2);
          sum3=sum3+(float)Math.pow(O2.Flow[i],2);
 }
      d=sum1/(sum2+sum3-sum1);
d=(float)-Math.log10(d);
return (d);
}
/**********************************************************/
float KLDivergenceFlow(Frequency O1, Frequency O2)
{
      float d=0;
      float a=0;
      float b=0;
      float c=0;
for (int i=0; i < O1.m;i++)
 {
          a=2*O1.Flow[i];
          b=O1.Flow[i];
          c=O2.Flow[i];
          d=d+(b*(float)Math.log10(a/(b+c)));
         
 }
return (d);
}
}
