package nl.hanze.designpatterns.domain;

import nl.hanze.designpatterns.DAO.QuestionDAO;
import nl.hanze.designpatterns.domain.Question;

/**
 * Leaf
 * @author Vincent
 *
 */
public class Answer implements QuestionDAO, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6565298436355936200L;
	private String answerString;
	
	public Answer(String answer){
		this.answerString = answer;
	}
	
	@Override
	public Question getRootQuestion() {
		return null;
	}
	
	public String getAnswer(){
		return answerString;
	}

	@Override
	public Answer answerQuestion(QuestionDAO q, String question) {
		return this;
	}

}
