import java.sql.*;
import java.util.*;
import oracle.sdoapi.OraSpatialManager; 
import oracle.sdoapi.geom.*;
import oracle.sdoapi.adapter.*;
import oracle.sdoapi.sref.*;
import java.io.*;


public class populate {
    Connection mainConnection = null;
    Statement mainStatement = null;
    ResultSet mainResultSet = null;
    public static void main(String[] args) {
     populate e=new populate(args);
    }
    void update(String s)
   { 
       try
       { 
       File file=new File(s);
       BufferedReader reader; 
       reader=new BufferedReader(new FileReader(file));
       String tempString=""; 
       String result[]=new String[1000]; 
       int i=0; 
       while((tempString=reader.readLine())!=null)
       {
           result[i]=tempString; 
           i++;       
       }
       if(s.equals("building.xy"))
       {
       for(int j=0; j<i; j++)
       {
       Scanner scanner=new Scanner(result[j]);
       scanner.useDelimiter(",");
       String id=scanner.next(); 
       String name=scanner.next(); 
    
       if(name.contains("&"))
       {
           name.replaceAll("&", "'||'&'||'");
       }
       name.replaceAll(" ","");
       String number=scanner.next(); 
       String coordinate="";    
       while(scanner.hasNext())
       {
           coordinate+=scanner.next();
           if(scanner.hasNext()) coordinate+=",";
       }
    
        String query="insert into building values('"+id+"','"+name+"',"+number+", MDSYS.SDO_GEOMETRY(2003, NULL, NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY("+coordinate+") ))"; 
           System.out.println(query);
       mainStatement.executeUpdate(query);
       }
       }
       if(s.equals("people.xy"))
       {
        for(int j=0; j<i; j++)
       {
       Scanner scanner=new Scanner(result[j]);
       scanner.useDelimiter(",");
       String id=scanner.next(); 
       String x=scanner.next(); 
       String y=scanner.next();     
       String query="insert into people values('"+id+"',MDSYS.SDO_GEOMETRY(2001, NULL,MDSYS.SDO_POINT_TYPE("+x+","+y+",NULL),NULL,NULL))"; 
       System.out.println(query);
          mainStatement.executeUpdate(query);
       }
       }
       if(s.equals("ap.xy"))
       {
        for(int j=0; j<i; j++)
       {
       Scanner scanner=new Scanner(result[j]);
       scanner.useDelimiter(",");
       String id=scanner.next(); 
       String x=scanner.next(); 
       String y=scanner.next();     
       String radius=scanner.next();     
       String query="insert into ap values('"+id+"',"+radius+",MDSYS.SDO_GEOMETRY(2001, NULL,MDSYS.SDO_POINT_TYPE("+x+","+y+",NULL),NULL,NULL))"; 
           System.out.println(query);
         mainStatement.executeUpdate(query);
       }
       }
       
       
       reader.close();       
       }
       catch(IOException e)
       {
           e.printStackTrace();
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
     
   }


    
     public populate(String[] args)
	{
	ConnectToDB();
	ClearData();
     int length=args.length;
     for(int i=0; i<length; i++)
     {       
       if(args[i].equals("building.xy")) update("building.xy");
       if(args[i].equals("people.xy")) update("people.xy");
       if(args[i].equals( "ap.xy")) update("ap.xy");
     }
	}

    	public void ConnectToDB()
	{
	try
	{
	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        System.out.print("Connecting to DB...");
	String URL = "jdbc:oracle:thin:@localhost:1521:csci585";
	String userName = "temp585";
	String password = "temp585";

	mainConnection = DriverManager.getConnection(URL, userName, password);
	System.out.println(", Connected!");
	mainStatement = mainConnection.createStatement();
	}
	catch(Exception e)
	{	
          System.out.println( "Error while connecting to DB: "+ e.toString() );
          System.exit(-1);  
	}
	}
	
	public void ClearData()
	{
            try{
	 mainStatement.executeUpdate( "delete from building" );
	 mainStatement.executeUpdate( "delete from people" );
	 mainStatement.executeUpdate( "delete from ap" );
        
                }
            catch(Exception e)
            {
             System.out.println( e.toString() );
            }
        }
    
       
    
}
