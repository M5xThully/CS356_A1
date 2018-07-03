import java.util.ArrayList;

public class MultipleChoice extends Question {

    public MultipleChoice(ArrayList<String> choices) {
            super(choices);
    }

    public boolean checkResponse(ArrayList<String> response){
        for(int i = 0; i < response.size(); i++){
            if (!answers.contains(response.get(i))){
                return false;
            }
        } 
        return true;
    }
}
