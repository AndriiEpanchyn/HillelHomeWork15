public class Persons {
    String name;
    int age;
    Persons(String name, int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        StringBuilder answer=new StringBuilder();
        answer.append("(Name="+name+"; age="+age+")\n");
        return answer.toString();

    }
}
