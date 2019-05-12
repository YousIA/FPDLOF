/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdp;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *
 * @author djenouri
 */
public class manipulation {
    ArrayList<row> Index=new ArrayList<row>();
ArrayList<position> PositionList=new ArrayList<position>();
Weather Table []=new Weather[305];

    	public void lect_fich(int week) throws java.text.ParseException {
		row o=new row();
                o.pos=new position();
                Index.clear();
    try {
		
                  // File f = new File("C:\\Users\\mobntic\\Desktop\\danemark\\software\\file"+week+".json");
         File f = new File("C:\\Users\\mobntic\\Desktop\\SDM\\weeks\\week"+week+".json");
                    // File f = new File("C:\\Users\\mobntic\\Desktop\\danemark\\software\\file30.json");
                     //File f = new File(" C:\\Users\\mobntic\\Desktop\\danemark\\software\\synthetic_data\\data\\data.json");
			//File f = new File("K:/with Zineb/DPLL2/instances/uf20-91/uf20-01.cnf");
                      Scanner scanner = new Scanner(f);

			String  var1, var2;// Var4 pour ignoré le zéro à la fin de chaque clause

			// Lecture d'un fichier clauses par clause et récupérer les variables de chaque clause
			while (true) {
				try {

					var1 = scanner.next();
                                        if (2<var1.length())
                                        {
                                        var1=(String)var1.subSequence(1, var1.length()-2);

                                        if (var1.compareTo("class")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.classe=Integer.parseInt(var2);
                                       }
                                        if (var1.compareTo("datetime")==0)
                                        {
                                          var2=scanner.next();
                                          var2=var2+ " "+ scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          Calendar calendar = Calendar.getInstance();
                                          Calendar fromDateTime = calendar;
                                          Calendar toDateTime = fromDateTime;
                                          toDateTime.add(Calendar.MINUTE, 30);
                                          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                          o.datetime = dateFormat.parse(var2);
                                         //o.datetime=var2;
                                       }
                                           if (var1.compareTo("direction")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.direction=var2;
                                       }

                                           if (var1.compareTo("display")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.display=Integer.parseInt(var2);
                                       }
                                        if (var1.compareTo("expectedInterval")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.expectedInterval=Integer.parseInt(var2);
                                       }

                                        if (var1.compareTo("flash")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.flash=Integer.parseInt(var2);
                                       }

                                        if (var1.compareTo("gap")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.gap=Integer.parseInt(var2);
                                       }

                                       if (var1.compareTo("installDate")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.installDate=var2;
                                       }

                                       if (var1.compareTo("lane")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.lane=Integer.parseInt(var2);
                                       }

                                        if (var1.compareTo("lattitude")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(0, var2.length()-1);
                                          o.pos.lattitude=Float.parseFloat(var2);
                                       }

                                        if (var1.compareTo("length")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.lenght=Integer.parseInt(var2);
                                       }


                                        if (var1.compareTo("longtitude")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(0, var2.length()-1);
                                          o.pos.longtitude=Float.parseFloat(var2);
                                        }

                                        if (var1.compareTo("messGroup")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(0, var2.length()-1);
                                          o.messGroup=var2;
                                        }
                                        
                                        if (var1.compareTo("source")==0)
                                        {
                                          var2=scanner.next();
                                          var2=var2+ " "+scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.source=var2;
                                       }
                                        
                                       if (var1.compareTo("speed")==0)
                                       {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.speed=Integer.parseInt(var2);
                                       }
                                     
                                       
                                        if (var1.compareTo("stationID")==0)
                                        {
                                          var2=scanner.next();
                                          var2=(String)var2.subSequence(1, var2.length()-2);
                                          o.StationID=var2;
                                          Index.add(o);
                                          o=new row();
                                          o.pos=new position();
                                       }
                                          
                                        
                                    }
				

				} catch (NoSuchElementException exception) {
					break;
				}
			}

			scanner.close();
                     // System.out.println(i);
		} catch (FileNotFoundException exception) {
			System.out.println("file not found");
		}
	}

/**********************************************************************/
void ReturningAllPositions()
{
        row o=new row();
       for (int i=0;i<Index.size();i++)
       {
        o=Index.get(i);
        int j=0;
        boolean find=false;
        position p=new position();
     
        while(j<PositionList.size() && find==false)
        {
          p=PositionList.get(j);
         if (p.lattitude==o.pos.lattitude && p.longtitude==o.pos.longtitude)
         {
         find=true;
         } 
         else
         {
         j++;
         }
        }
        if(find ==false)
        {
        PositionList.add(o.pos);
        }
       }
  
}
    
  /********************************************************************/
 void display_instance()
 {
  row o=new row();
for (int i=0;i<Index.size();i++)
{
   
o=Index.get(i);
System.out.println(o.StationID+ " "+ o.gap+ " "+ o.source+ " "+ o.lane+ " "+ o.pos.lattitude+ "  "+ o.pos.longtitude+ " "+ o.lenght+ " "+ o.speed);
}
     System.out.println(Index.size());
}
/***************************************************/

 void display_time()
    {
      row o=new row();
for (int i=0;i<Index.size();i++)
{

o=Index.get(i);
//System.out.println(o.datetime.getDate());
System.out.println(o.datetime.getDay());
}
     System.out.println(Index.size());

   }
/*******************************************/
 void display_positions()
 {
  row o=new row();
for (int i=0;i<Index.size();i++)
{

o=Index.get(i);
System.out.println(o.pos.lattitude+ "  "+ o.pos.longtitude);
}
     System.out.println(Index.size());
}

/*******************************************/
 void display_PositionsList()
 {
  position p=new position();
for (int i=0;i<PositionList.size();i++)
{

p=PositionList.get(i);
System.out.println(p.lattitude+ "  "+ p.longtitude);
}
     System.out.println(PositionList.size());
}
 /***************************/
 public void lect_fich2(String Location) throws java.text.ParseException, FileNotFoundException {
        row o=new row();
           //     o.pos=new position();
                Index.clear();

                  // File f = new File("C:\\Users\\mobntic\\Desktop\\danemark\\software\\file"+week+".json");
         File f = new File("C:\\Users\\djenouri\\Desktop\\Odense\\Data\\"+Location+".txt");
                    // File f = new File("C:\\Users\\mobntic\\Desktop\\danemark\\software\\file30.json");
                     //File f = new File(" C:\\Users\\mobntic\\Desktop\\danemark\\software\\synthetic_data\\data\\data.json");
            //File f = new File("K:/with Zineb/DPLL2/instances/uf20-91/uf20-01.cnf");
                      Scanner scanner = new Scanner(f);

            String  var1, var2;// Var4 pour ignoré le zéro à la fin de chaque clause

            // Lecture d'un fichier clauses par clause et récupérer les variables de chaque clause
            while (true) {
                
                                    try {
                      var1=scanner.next();
                                          var2=var1+ " "+ scanner.next();
                                          Calendar calendar = Calendar.getInstance();
                                          Calendar fromDateTime = calendar;
                                          Calendar toDateTime = fromDateTime;
                                          toDateTime.add(Calendar.MINUTE, 30);
                                          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                          o.datetime=dateFormat.parse(var2);
                                          var1=scanner.next();
                                           o.lane=Integer.parseInt(var1);
                                           var1=scanner.next();
                                           o.speed=Integer.parseInt(var1);
                                           var1=scanner.next();
                                           o.lenght=Integer.parseInt(var1);
                                           var1=scanner.next();
                                           o.classe=Integer.parseInt(var1);
                                           var1=scanner.next();
                                           o.gap=Integer.parseInt(var1);
                                           var1=scanner.next();
                                           var1=scanner.next();
                                           o.display=Integer.parseInt(var1);
                                           var1=scanner.next();
                                           o.flash=Integer.parseInt(var1);
                                           Index.add(o);
                                           o=new row();
                                           //o.pos=new position();
                                     } catch (NoSuchElementException exception) {
                    break;
                }

                } 
            }
/************************************************************/
     	public void lect_fich3() throws java.text.ParseException {
		
    try {
		
                  // File f = new File("C:\\Users\\mobntic\\Desktop\\danemark\\software\\file"+week+".json");
         File f = new File("C:\\Users\\djenouri\\Desktop\\Odense\\odense.json");
                    // File f = new File("C:\\Users\\mobntic\\Desktop\\danemark\\software\\file30.json");
                     //File f = new File(" C:\\Users\\mobntic\\Desktop\\danemark\\software\\synthetic_data\\data\\data.json");
			//File f = new File("K:/with Zineb/DPLL2/instances/uf20-91/uf20-01.cnf");
                      Scanner scanner = new Scanner(f);
                      int i=0;
			String  var1;
                          int nb1=0;
                          boolean state=true, state1=true, state2=true, state3=true, state4=true, state5=true;
		         boolean state6=true, state7=true, state8=true, state9=true, state10=true;
			while (true) {
				try {

					var1 = scanner.next();
                                        
                                        if (var1.length()>2)
                                        {
                                        var1=(String)var1.subSequence(1, var1.length()-2);
                                       
                                        if (var1.compareTo("date")==0)
                                        {
                                            
                                            if (state==true)
                                            {     i++;
                                             
                                                Table[i]=new Weather();  
                                                scanner.next();
                                                scanner.next();
                                                var1 = scanner.next();
                                                Table[i].day=Integer.parseInt((String)var1.subSequence(1, var1.length()-2));
                                                scanner.next();
                                                var1 = scanner.next();
                                                Table[i].hour=Integer.parseInt((String)var1.subSequence(1, var1.length()-2));
                                                scanner.next();
                                                var1 = scanner.next();
                                                Table[i].min=Integer.parseInt((String)var1.subSequence(1, var1.length()-2));
                                                scanner.next();
                                                var1 = scanner.next();
                                                Table[i].month=Integer.parseInt((String)var1.subSequence(1, var1.length()-2));
                                                scanner.next();
                                                scanner.next();
                                                scanner.next();
                                                var1 = scanner.next();
                                                Table[i].year=Integer.parseInt((String)var1.subSequence(1, var1.length()-2));
                                               // System.out.println(Table[i].day+"-"+Table[i].month+"-"+Table[i].year+ "  "+ Table[i].hour+ ":"+Table[i].min);
                                              
                                                state=false;
                                            }
                                        }
                                        
                                        if (var1.compareTo("tempm")==0)
                                        { 
                                           var1= scanner.next();
                                            Table[i].tempm=Float.parseFloat((String)var1.subSequence(1, var1.length()-2));
                                            
                                        }
                                        if (var1.compareTo("wspdm")==0)
                                        { 
                                            if (state1==true)
                                            {
                                            var1= scanner.next();
                                            var1=(String)var1.subSequence(1, var1.length()-1);
                                           if (var1.compareTo("")!=0)
                                           {
                                            Table[i].wspdm=Float.parseFloat(var1);
                                           }
                                           state1=false;
                                            }
                                        }
                                        if (var1.compareTo("wgustm")==0)
                                        {
                                            if (state2==true)
                                            {
                                            var1= scanner.next();
                                            var1=(String)var1.subSequence(1, var1.length()-2);
                                           if (var1.compareTo("")!=0)
                                           {
                                            Table[i].wgustm=Float.parseFloat(var1);
                                           }
                                           state2=false;
                                            }
                                        }
                                       if (var1.compareTo("precipm")==0)
                                        {
                                             if (state3==true)
                                            {
                                            var1= scanner.next();
                                            var1=(String)var1.subSequence(1, var1.length()-2);
                                           if (var1.compareTo("")!=0)
                                           {
                                            Table[i].precipmO=Float.parseFloat(var1);
                                           }
                                           state3=false;
                                            }
                                        }
                                       if (var1.compareTo("conds")==0)
                                        {
                                                if (state4==true)
                                            {
                                            var1= scanner.next();
                                            var1=(String)var1.subSequence(1, var1.length()-2);
                                           if (var1.compareTo("")!=0)
                                           {
                                            Table[i].conds=var1;
                                            //System.out.println(Table[i].conds);
                                           }
                                           state4=false;
                                            }
                                        }
                                       if (var1.compareTo("meantempm")==0)
                                        {
                                          
                                                if (state5==true)
                                            {
                                            var1= scanner.next();
                                            var1=(String)var1.subSequence(1, var1.length()-1);
                                           if (var1.compareTo("")!=0)
                                           {
                                            Table[i].meantempm=Float.parseFloat(var1);
                                           }
                                           state5=false;
                                            }
                                        
                                        }
                                       if (var1.compareTo("meanwindspdm")==0)
                                        {
                                             if (state6==true)
                                            {
                                            var1= scanner.next();
                                            var1=(String)var1.subSequence(1, var1.length()-2);
                                           if (var1.compareTo("")!=0)
                                           {
                                            Table[i].meanwindspdm=Float.parseFloat(var1);
                                           }
                                           state6=false;
                                            }
                                        }
                                       if (var1.compareTo("maxtempm")==0)
                                        {
                                                if (state7==true)
                                            {
                                            var1= scanner.next();
                                            var1=(String)var1.subSequence(1, var1.length()-2);
                                           if (var1.compareTo("")!=0)
                                           {
                                            Table[i].maxtempm=Float.parseFloat(var1);
                                           }
                                           state7=false; 
                                      
                                            }
                                        }
                                       if (var1.compareTo("mintempm")==0)
                                        {
                                            if (state8==true)
                                            {
                                            var1= scanner.next();
                                            var1=(String)var1.subSequence(1, var1.length()-2);
                                           if (var1.compareTo("")!=0)
                                           {
                                            Table[i].mintempm=Float.parseFloat(var1);
                                           }
                                           state8=false; 
                                            }
                                        }
                                       
                                       if (var1.compareTo("maxwspdm")==0)
                                        {
                                            if (state9==true)
                                            {
                                            var1= scanner.next();
                                            var1=(String)var1.subSequence(1, var1.length()-2);
                                           if (var1.compareTo("")!=0)
                                           {
                                            Table[i].maxwspdm=Float.parseFloat(var1);
                                           }
                                           state9=false; 
      
                                            }
                                        }
                                       if (var1.compareTo("minwspdm")==0)
                                        {
                                            if (state10==true)
                                            {
                                            var1= scanner.next();
                                            var1=(String)var1.subSequence(1, var1.length()-2);
                                           if (var1.compareTo("")!=0)
                                           {
                                            Table[i].minwspdm=Float.parseFloat(var1);
                                           }
                                           state10=false; 
                                            }
                                        }

                                       if (var1.contains("history"))
                                        {
                                        state=true;
                                        state1=true;
                                        state2=true;
                                        state3=true;
                                        state4=true;
                                        state5=true;
                                        state6=true;
                                        state7=true;
                                        state8=true;
                                        state9=true;
                                        state10=true;
                                        
                                        }
                                    
                                        
                                    }
				

				} catch (NoSuchElementException exception) {
					break;
				}
			}

			scanner.close();
		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}
	}
         float t=0, w=0; 
/******************************************************************************/
void AverageWeather()
{

for (int i=1; i<305;i++)
{
t=t+Table[i].meantempm;
w=w+Table[i].meanwindspdm;
}
t=t/304; 
w=w/304;
}        
        
/******************************************************************************/
void WeatherDay(int day, int month)
{
float d=0;
for (int i=1; i<305;i++)
{
if (Table[i].day==day && Table[i].month==month)
{
//System.out.print(Table[i].conds+ " "+Table[i].meanwindspdm+" "+  Table[i].meantempm+ " "+ "  "+ Table[i].precipmO);
System.out.print(Table[i].precipmDS);
d=(Table[i].meanwindspdm-w)+ (Table[i].meantempm-t);
}

}

//System.out.println(d);
}


}
