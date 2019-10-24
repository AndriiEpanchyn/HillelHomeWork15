import java.util.ArrayList;

public class ComplexObj {
    String name;
    ArrayList<Persons> persons=new ArrayList<Persons>();

    void put(Persons newItem){
        persons.add(newItem);
    }
    public String toString(){
        StringBuilder answer = new StringBuilder();
        answer.append("Object name is: "+name+"\n");
        for(Persons item: persons){
            answer.append(item.toString());
        }
        return answer.toString();
    }

}
