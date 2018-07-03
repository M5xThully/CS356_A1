import java.util.ArrayList;

/*
 * 	This class handles student submissions and
 * 	generates the results.
 */
public class IVoteService {
    private ArrayList<User> users;
    private int[] answers;
    private Question question;

    public IVoteService(Question question) {
        users = new ArrayList<User>();
        answers = new int[question.getChoices().size()];
        this.question = question;
    }

    public void acceptResponse(User user){
        if(!users.contains(user)){
            users.add(user);
        }
        else{
            int index = users.indexOf(user);
            users.set(index, user);
        }
    }

    public void computeStatistics() {
        int index = 0;

        for (int i = 0; i < users.size(); i++) {
            for (int x = 0; x < users.get(i).submitResponse().size(); x++) {
                index = question.getChoices().indexOf(users.get(i).submitResponse().get(x));
                answers[index]++;
            }
        }
        printStatistics();
    }

    private void printStatistics() {
        System.out.println("Responses: " + users.size());
        System.out.println("Results:");

        for (int i = 0; i < answers.length; i++) {
            System.out.println(question.getChoices().get(i) + " - " + answers[i]);
        }
    }
}
