import java.util.ArrayList;
import java.util.List;

public abstract class Question {
    protected ArrayList<String> answers;

    public Question(ArrayList<String> choices){
        this.answers = choices;
    }

    public ArrayList<String> getChoices(){
        return answers;
    }

    public abstract boolean checkResponse(ArrayList<String> response); 

    String getPrompt() {
        return "";
    }
}
