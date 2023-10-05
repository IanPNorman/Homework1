package homework1;

import java.util.*;

public class Question {
	private String type;
    private List<String> candidateAnswers;
    private String correctAnswer;

    public Question(String type, List<String> candidateAnswers, String correctAnswer) {
        this.type = type;
        this.candidateAnswers = candidateAnswers;
        this.correctAnswer = correctAnswer;
    }

    public String getType() {
        return type;
    }
    
    public String getCorrectAnswer() {
        return correctAnswer;
    }


    public List<String> getCandidateAnswers() {
        return candidateAnswers;
    }
}
