package nl.hanze.designpatterns.domain;

import nl.hanze.designpatterns.DAO.QuestionDAO;
import nl.hanze.designpatterns.domain.Question;

/**
 * Leaf
 * @author Vincent
 *
 */
public class Answer implements QuestionDAO, java.io.Serializable {

	private String answerString;
	
	public Answer(String answer){
		this.answerString = answer;
	}
	
	@Override
	public Question getRootQuestion() {
		return null;
	}

	@Override
	public void print() {
		System.out.println(getAnswer());
	}
	
	public String getAnswer(){
		return answerString;
	}

}
