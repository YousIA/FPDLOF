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
public class Distribution {
     int m=300;
    int m2=24;
 //Observation O[] = new Observation[m];
   float O[]=new float[m];
   int Flow[]=new int [m2];
    int week;
    int day;
    float score;
    //List <Integer> AllFLow=new ArrayList <Integer>();
void intialization()
{

for (int i=0;i <m; i++)
         {
    O[i]=0;
         }

for (int i=0;i <m2; i++)
         {
    Flow[i]=0;
         }

}
}
