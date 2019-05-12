/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdp;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *
 * @author djenouri
 */
public class AllStatistic {
    int n=400;
    int index=0;
  
List <Integer> F=new ArrayList <Integer>(); // the flow list
List <Integer> AllFlow=new ArrayList <Integer>(); // the flow list with all minutes
Frequency D1[]=new Frequency [n];
Frequency T[]=new Frequency [n];
/******************************/
void AllFlow(ArrayList<row> I, int month, int day, int h1, int h2)
{

F.clear();
AllFlow.clear();
row r=new row();
ArrayList <Integer>l = new ArrayList();

for (int j=0;j <(h2-h1); j++)
         {

     int nb=0;
for (int i=0;i<I.size();i++)
{
    r=I.get(i);
        if (r.datetime.getDate()==day && r.datetime.getMonth()==month)
        {
        int h=r.datetime.getHours();
        if (h1<=h && h<=h2 )
        {
          if (h==j)
          {
             l.add(r.speed);
             nb++;
          }
        }
       
    }
  }

     AllFlow.add(nb);
     if (nb!=0)
     {
     F.add(nb);
     }

         }
 }

/************************************************************************************/

String AllFlowFrequency(int h1, int h2, String state, String Location) throws ParseException, FileNotFoundException
{
 manipulation m=new manipulation();
     String s="";
        m.lect_fich2(Location);
  
  for (int month=0;month<=11;month++)
   {   
        
     for (int day=1;day<=31;day++)
       {
         AllFlow(m.Index, month, day, h1, h2);
         s=s+display(AllFlow)+" "+month+" "+day;
       }
   }
     //System.out.println(s);
     FDPConstructionFile(s, h1, h2, state, Location);
return s;
}
/*************************************************************/
void FDPConstructionFile(String s, int h1, int h2, String state, String Location)
    {
      //String   result="Date,Flow,Speed"+"\n";
     //result=result+s.Flow(m.Index, m.PositionList.get(k), 1, i);
     try {
              String filename="FDP-"+h1+"-"+h2;
              String path="C:\\Users\\djenouri\\Desktop\\Odense\\Frequency\\"+Location+"\\"+filename+".txt";
            File newTextFile = new File(path);
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(s);
            fw.close();

         }
 catch (IOException iox) {
            //do stuff with exception
     System.out.println("error");
                                       }
     }

/*****************************************************************/
void ReadFDP(int h1, int h2, String state, String Location) throws FileNotFoundException
{
try {
 
              String filename="FDP-"+h1+"-"+h2;
              String path="C:\\Users\\djenouri\\Desktop\\Odense\\Frequency\\"+Location+"\\"+filename+".txt";
         File f = new File(path);
                      Scanner scanner = new Scanner(f);
                      String var1;
                      int i=0;
                    Frequency o=new Frequency();
                    o.intialization();
			// Lecture d'un fichier clauses par clause et récupérer les variables de chaque clause
			while (true) {
                       
                    try {
                          if (i<o.m)
                          {
                              var1 = scanner.next();
                              o.Flow[i]=Integer.parseInt(var1);
                              i++;
                          }
                         else
                           {
                         var1 = scanner.next();
                         o.month=Integer.parseInt(var1);
                         var1 = scanner.next();
                         o.day=Integer.parseInt(var1);
                         D1[index]=new Frequency();
                         D1[index]=o;
                         index++;
                         i=0;
                         o=new Frequency();
                         o.intialization();
                       
                         }
                    }
                  
			
                              catch (NoSuchElementException exception) {
					break;
				}
                                     }
                  	scanner.close();
                 
		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}
}
/******************************************************************/
String  display(List <Integer> F)
{
   String s="";
for (int i=0;i<F.size();i++)
{
    s=s+" "+F.get(i);
}
 s=s+"\n";

 return s;
}
/******************************************************************/
String displayFF()
{
String s="";
//System.out.println();
for (int j=0;j<index;j++)
{
    Frequency o=new Frequency();
    o=D1[j];
    if (o.score!=0)
    {    
    s=s+o.score+" M"+o.month+"D"+o.day+" ";
  for (int i=0;i<o.m;i++)
   {
    //  System.out.print("("+i+ ", "+o.O[i] +")");
    s=s+o.Flow[i] +" ";
   }
  s=s+"\n";
    }
}
return s;
}
/****************************************************************/
void sorting(Frequency D1[], int index)
{
for (int i=0; i<index; i++)
{
    float max=D1[i].score;
    int indice=i;
    for (int j=i+1; j<index; j++)
    {
     if (max<D1[j].score)
     {
     max=D1[j].score;
     indice=j;
     }
    }
    
    Frequency tempD=new Frequency();
    tempD=D1[indice];
    D1[indice]=D1[i];
    D1[i]=tempD;

}

}

/*****************************************************************/
void SaveOutputFile(String Output, int h1, int h2, String state, String Algorithm, String Location)
{

  try {
              String filename="Output-"+h1+"-"+h2+"-"+Algorithm;
              String path="C:\\Users\\djenouri\\Desktop\\Odense\\Output\\"+Location+"\\"+filename+".csv";
            File newTextFile = new File(path);
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(Output);
            fw.close();

      }
 catch (IOException iox) {
            //do stuff with exception
     System.out.println("error");
}

}
/***************************************************************/
void clear()
{        
for (int i=0; i<index;i++)
{  
    
    D1[i].intialization();
    T[i].intialization();
}   
}
/***************************************************************/
void GenerateTest(float gamma, int nb)
{
Random r=new Random();

for (int i=0; i<nb;i++)
{  
 for (int j=0; j<T[i].m;j++)
    {
 float x=(float) r.nextGaussian();

   if (x<gamma)
   {
    T[i].Flow[j]=D1[i].Flow[j]+50;
   }
    else
    {
    T[i].Flow[j]=r.nextInt(100);
    }
   
    }
}
}
}
