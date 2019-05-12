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
public class Statistic {
    int n=300;
Distribution T=new Distribution();
    int index=0;
List <Integer> F=new ArrayList <>(); // the flow list
List <Integer> AllFlow=new ArrayList <>(); // the flow list with all minutes
Distribution D1[]=new Distribution [n];


/*********************************************************************/
void SpeedFlow(ArrayList<row> I,  position p, int minute, int day, int h1, int h2)
{
    F.clear();
    AllFlow.clear();
row r=new row();
ArrayList <Integer>l = new ArrayList();
int intervall =Math.round(60/minute);

for (int j=1;j <(h2-h1)*intervall; j++)
         {

     int nb=0;
for (int i=0;i<I.size();i++)
{
    r=I.get(i);
    if (r.pos.lattitude==p.lattitude && r.pos.longtitude==p.longtitude)
    {
        if (r.datetime.getDay()==day)
        {
        int h=r.datetime.getHours();
        if (h1<=h && h<=h2 )
        {
          int m=r.datetime.getMinutes();
          m=Math.round(m/minute);
          if (m*h==j)
          {
             l.add(r.speed);
             nb++;
          }
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
/*************************************************************/
void FDPConstructionFile(String s, int h1, int h2, String state, int minute)
    {
      //String   result="Date,Flow,Speed"+"\n";
     //result=result+s.Flow(m.Index, m.PositionList.get(k), 1, i);
     try {
              String filename="FDP-"+h1+"-"+h2+"-"+state;
              String path="C:\\Users\\mobntic\\Desktop\\SDM\\FDP\\"+minute+"minutes\\"+filename+".csv";
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
/************************************************************/
String FlowFrequency(List <Integer> AllFlow, List <Integer> F, int week, int day)
{
    String s="";
    Distribution o=new Distribution();
    o.intialization();
int size=F.size();
for (int i=0;i<size;i++)
{   int value=F.get(i);

    o.O[value]++;
}
for (int i=0;i<o.m;i++)
{
    o.O[i]=o.O[i]/size;
    s=s+" "+o.O[i];
}

s=s+" ";


for (int i=0;i<o.m2-1;i++)
{   int value=AllFlow.get(i);
    s=s+" "+value;
}
return s; 
}
/*********************************************/
void FlowFrequencyLocation(int location, int h1, int h2, String state, int minute) throws ParseException
{
 manipulation m=new manipulation();
     String s="";
 for (int w=9;w<=35;w++)
   { 
         m.lect_fich(w);
         m.ReturningAllPositions();
        for (int day=1;day<6;day++)
       {
       // int day=0;
         //SpeedFlow(m.Index, m.PositionList.get(location), minute, day, h1, h2);
            FlowHour(m.Index, m.PositionList.get(location), day, h1, h2);
            s=s+FlowFrequency(AllFlow, F, w, day)+"\n";
         //day=6;
         //SpeedFlow(m.Index, m.PositionList.get(location), 1, day, h1, h2);
         //s=s+FlowFrequency(F, w, day)+"\n";
       }
   }
     //System.out.println(s);
FDPConstructionFile(s, h1, h2, state, minute);

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
    Distribution o=new Distribution();
    o=D1[j];
    s=s+o.score+" W"+o.week+"D"+o.day+" ";
  for (int i=1;i<o.m;i++)
   {
    //  System.out.print("("+i+ ", "+o.O[i] +")");
    s=s+o.O[i] +" ";
   }

  for (int i=1;i<o.m2;i++)
   {
    //  System.out.print("("+i+ ", "+o.O[i] +")");
    s=s+o.Flow[i] +" ";
   }

  s=s+"\n";
}
return s;
}
/***************************************************************/
void GenerateTest()
{
Random r=new Random();
T.intialization();
 for (int j=0; j<30;j++)
    {
 float x=(float) r.nextGaussian();
   if (x<0)
   {
    T.O[j]=x*(-1);
   }
    else
    {
    T.O[j]=x;
    }
   
    }
}


/*****************************************************************/
void ReadFDP(int h1, int h2, String state, int minute) throws FileNotFoundException
{
int indice=0;
try {
 
              String filename="FDP-"+h1+"-"+h2+"-"+state;
              String path="C:\\Users\\mobntic\\Desktop\\SDM\\FDP\\"+minute+"minutes\\"+filename+".csv";
         File f = new File(path);
                      Scanner scanner = new Scanner(f);
                      String var1;
                      int i=0;
                     int week=9;
                     int day;
                     if (state.compareTo("Both")==0 || state.compareTo("WED")==0)
                     {
                     day=0;
                     }
                    else {
                    day=1;
                         }
                    Distribution o=new Distribution();
                     o.intialization();
			// Lecture d'un fichier clauses par clause et récupérer les variables de chaque clause
			while (true) {
                       
                    try {
                          if (i<(o.m+o.m2-1))
                          {
                              if (i<o.m)
                              {
                              var1 = scanner.next();
                               if (var1.compareTo("NaN")==0)
                               {
                                o.O[i]=0;
                               }
                              else {
                                  o.O[i] = Float.parseFloat(var1);
                                    }
                              }
                              else
                              {
                               var1 = scanner.next();
                               if (var1.compareTo("\n")!=0)
                               {
                                   o.Flow[indice] = Integer.parseInt(var1);
                               indice++;

                               }
                               else i=o.m+o.m2;
                              }
                              i++;
                                   
                          }

                         else
                           {
                          
                              // System.out.println(indice);
                         i=0;
                           indice=0;
                         D1[index]=new Distribution();
                         D1[index]=o;
                         D1[index].week=week;
                         if (state.compareTo("Both")==0)
                         {
                         if (day!=6)
                         {
                         D1[index].day=day;
                         day++;
                         }
                         else
                         {
                         D1[index].day=day;
                         day=0;
                         week++;
                         }
                         }
                          if (state.compareTo("WD")==0)
                         {
                         if (day!=5)
                         {
                         D1[index].day=day;
                         day++;
                         }
                         else
                         {
                         day=1;
                         week++;
                         }
                         }
                         if (state.compareTo("WED")==0)
                         {
                         if (day==0)
                         {
                         D1[index].day=day;
                         day=6;
                         }
                         else
                         {
                         D1[index].day=day;
                         day=0;
                         week++;
                         }
                         }
                         index++;
                         o=new Distribution();
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
/****************************************************************/
void sorting()
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
    
    Distribution tempD=new Distribution();
    tempD=D1[indice];
    D1[indice]=D1[i];
    D1[i]=tempD;

}

}
/*****************************************************************/
void SaveOutputFile(String Output, int h1, int h2, String state, String Algorithm, int minute)
{

  try {
              String filename="Output-"+h1+"-"+h2+"-"+state+"-"+Algorithm;
              String path="C:\\Users\\mobntic\\Desktop\\SDM\\Output\\"+minute+"minutes\\"+filename+".csv";
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
/***************************************************/
void FlowHour(ArrayList<row> I,  position p, int day, int h1, int h2)
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
    if (r.pos.lattitude==p.lattitude && r.pos.longtitude==p.longtitude)
    {
        if (r.datetime.getDay()==day)
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
}

     AllFlow.add(nb);
     if (nb!=0)
     {
     F.add(nb);
     }


         }
}
/******************************/
}
