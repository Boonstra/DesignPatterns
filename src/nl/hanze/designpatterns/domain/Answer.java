package nl.hanze.designpatterns.domain;

import nl.hanze.designpatterns.DAO.QuestionDAO;
import nl.hanze.designpatterns.domain.Question;

/**
 * Leaf
 * @author Vincent
 *
 */
public class Answer implements QuestionDAO {

	private String answerString;
	
	public Answer(String answer){
		this.answerString = answer;
	}
	
	@Override
	public Question getRootQuestion() {
		// TODO Auto-generated method stub
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
