package nl.hanze.designpatterns.domain;

import java.util.ArrayList;
import java.util.List;

import nl.hanze.designpatterns.DAO.QuestionDAO;

/**
 * Composite class
 * @author Vincent
 *
 */
public class Question implements QuestionDAO, java.io.Serializable {

	private String questionString;
    //Collection of child questions.
    private List<QuestionDAO> childQuestions = new ArrayList<QuestionDAO>();
	
	/**
	 * Constructor
	 * @param question
	 */
	public Question(String question){
		this.questionString = question;
	}
	
	@Override
	public Question getRootQuestion() {
        return null;
	}
    
    /**
     * Answer question recursively
     * @param question
     * @return
     */
    public Answer answerQuestion(QuestionDAO qImpl, String question){
    	Answer a = null;
		String[] words = question.split("\\s+");
    	for (int i = 0; i < words.length; i++) {
    		if(words[i].toLowerCase().equals(this.questionString)){
    			for (QuestionDAO q : childQuestions){
    				if(a instanceof Answer){
    					return a;
    				}
    				else{
    					a = q.answerQuestion(q, question);
    				}
    			}
    		}
    	}
    	return a;
    }
 
    //Adds the question to the composition.
    public void add(QuestionDAO question) {
        childQuestions.add(question);
    }
 
    //Removes the question from the composition.
    public void remove(QuestionDAO question) {
        childQuestions.remove(question);
    }
    
    public String getQuestion(){
    	return questionString;
    }

}
