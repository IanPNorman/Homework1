package homework1;

import java.util.*;
import java.util.Random;

public class SimulationDriver {
	public static void main(String[] args) {
        // Create a question
		Random random = new Random();
		List<String> qustionType = Arrays.asList("singleAnswer", "multipleAnswer");
        List<String> candidateAnswers = Arrays.asList("A", "B", "C", "D");
        Question question = new Question(qustionType.get(random.nextInt(2)), candidateAnswers, candidateAnswers.get(random.nextInt(5)));

        // Configure the question for the voting service
        VotingService votingService = new VotingService(question);

        // Generate students and their answers
        List<Student> students = generateStudents(random.nextInt(25)+1);
        generateAnswers(students, candidateAnswers);

        // Submit the answers to the voting service
        for (Student student : students) {
            votingService.submitAnswer(student, student.getAnswer());
        }

        // Display the result
        votingService.displayResult();
    }
	// Creates unique ids for a variety of students
    private static List<Student> generateStudents(int count) {
    	Random random = new Random();
    	List<Student> students = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
        	int randomId = random.nextInt(9000) + 1000;
        	String id = "B0" + i + "0" + randomId;
            students.add(new Student(id));
        }
        
        return students;
    }
    // Creates random answers associated with specific students.
    private static void generateAnswers(List<Student> students, List<String> candidateAnswers) {
        Random random = new Random();
        for (Student student : students) {
            int index = random.nextInt(candidateAnswers.size());
            String answer = candidateAnswers.get(index);
            student.submitAnswer(answer);
        }
    }
}
