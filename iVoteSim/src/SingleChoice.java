import java.util.ArrayList;

public class SingleChoice extends Question{
    public SingleChoice(ArrayList<String> choices){
        super(choices);
    }

    public boolean checkResponse(ArrayList<String> response){
        if (response.size() > 1){
            return false;
        }

        if (!answers.contains(response.get(0))){
            return false;
        }
        return true;
    }
}
