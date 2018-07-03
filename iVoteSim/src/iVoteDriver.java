import java.util.ArrayList;
import java.util.Random;

public class iVoteDriver{

    public static void main(String[] args){
        ArrayList<String> multipleChoice = new ArrayList<String>(9);
        multipleChoice.add("A");
        multipleChoice.add("B");
        multipleChoice.add("C");
        multipleChoice.add("D");
        multipleChoice.add("E");
        multipleChoice.add("F");
        multipleChoice.add("G");
        multipleChoice.add("H");
        multipleChoice.add("I");
        
        ArrayList<String> tf = new ArrayList<String>(2);
        tf.add("True");
        tf.add("False");

        Question sing = new SingleChoice(tf);
        Question multi = new MultipleChoice(multipleChoice);

        simulation(sing, "Sing");
        
        System.out.println();

        simulation(multi, "Multi");

}

private static void simulation(Question question, String type) {
        Random rand = new Random();
        int numOfQs = 0;

        IVoteService iVote = new IVoteService(question);

        int num_of_students = rand.nextInt(21) + 20;

        for (int i = 0; i < num_of_students; i++) {
                User user = new User();

                numOfQs = rand.nextInt(4) + 1;
                for (int j = 0; j < numOfQs; j++) {
                        simulateResponse(user, question, type);

                        iVote.acceptResponse(user);
                }
      System.out.println("All results: ");
      System.out.println(iVote.getAllResults());
      System.out.println("Number of correct answers: ");
      System.out.println(iVote.getCorrectResults());
      iVote.clear();
      }
}

private static void simulateResponse(User user, Question question, String type) {
        Random rand = new Random();
        ArrayList<String> response = new ArrayList<String>();

        if(type == "1"){
            response.add(question.getChoices().get(rand.nextInt(question.getChoices().size())));

        }
        else{
            int numChoices = rand.nextInt(question.getChoices().size()) + 1;
            int selected = 0;
            int index = 0;

            while(selected < numChoices){
                index = rand.nextInt(question.getChoices().size());

                if (!response.contains(question.getChoices().get(index))) {
                    response.add(question.getChoices().get(index));
                    selected++;
                }
            }
        }
        if(question.checkResponse(response)){
            user.setResponse(response);
        }
        else{
            simulateResponse(user, question, type);
        }
    }
}
