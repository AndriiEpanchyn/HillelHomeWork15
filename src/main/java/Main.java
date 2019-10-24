import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Persons> myList=new ArrayList<Persons>();

        myList.add(new Persons("Dima",10));
        myList.add(new Persons("Roma",10));
        myList.add(new Persons("Mama",34));
        myList.add(new Persons("Papa",39));

// recovering from arraylist
        Gson mygson = new Gson();
        String textJson = mygson.toJson(myList);
        Type type = new TypeToken<ArrayList<Persons>>(){}.getType();
        ArrayList<Persons> myRecoveredJson = mygson.fromJson(textJson,type);
        System.out.println("Printing gson from Arraylist:\n"+myRecoveredJson.toString());


// recovering from txt file
        StringBuilder innerText = new StringBuilder();
        try {
            FileReader newReader = new FileReader("C:\\Users\\Андрей\\IdeaProjects\\20191024HillelHomeWork15\\toMaven.txt");
            Scanner newScan = new Scanner(newReader);
            while (newScan.hasNextLine()) {
                innerText.append(newScan.nextLine());
            }
            newReader.close();
            newScan.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        //System.out.println(innerText.toString());
        ComplexObj obj= new ComplexObj();

        Type type2 = new TypeToken<ComplexObj>(){}.getType();
        obj = mygson.fromJson(innerText.toString(),type2);
        System.out.println("Printing gson from file:\n"+obj.toString());

        for(Persons item: myList){
            obj.put(item);
        };


        System.out.println("Printing consolidated json:\n"+obj.toString());
    }

}
