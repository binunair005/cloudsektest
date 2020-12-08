import java.util.Scanner;
import java.io.*;
import java.net.*;

class Test {
    public static void main(String[] args) {
        try{
            //read txt file 
            FileInputStream fi = new FileInputStream(args[1]);
            Scanner sc = new Scanner(fi);
            //read line by line
            while(sc.hasNextLine())
            {  
                //build url to check
                String urlToCheck = args[0] + "/" + sc.nextLine();
                //call the url and get http status code
                URL myurl = new URL(urlToCheck); 
                URLConnection connection = myurl.openConnection();
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                String statusCode = Integer.toString(httpConnection.getResponseCode());
                String  statusCodeList = " ";
                
                //default to 200 if status code list is empty
                if(args.length < 3){
                    statusCodeList = "200";  
                }
                else{
                    statusCodeList = args[2];  
                }
                //print url and status code if match found
               if(statusCodeList.contains(statusCode)) {
                    System.out.println(urlToCheck + " " + "[Status code " + statusCode + "]");
               }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }       
    }

}