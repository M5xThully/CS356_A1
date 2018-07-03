import java.util.ArrayList;

public class User{
    private static int numOfUsers = 0;
    private String id;
    private ArrayList<String> response;

    public User(ArrayList<String> response){
        numOfUsers++;
        this.id = "" + numOfUsers;
        this.response = response;
    }

    public User(){
        numOfUsers++;
        this.id = "" + numOfUsers;
    }

    public String getId(){
        return id;
    }

    public void setResponse(ArrayList<String> response){
        this.response = response;
    }

    public ArrayList<String> submitResponse(){
        return response;
    }

    void clearAnswer() {
        this.response = null;
    }

    ArrayList<String> getAnswer() {
        return response;
    }

    void setAnswer(ArrayList<Character> arrayList) {
        ArrayList<String> response = this.response;
    }
}
