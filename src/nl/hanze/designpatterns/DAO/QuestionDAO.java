package nl.hanze.designpatterns.DAO;

import nl.hanze.designpatterns.domain.*;

/**
 * Component interface
 *
 */
public interface QuestionDAO {
	public Question getRootQuestion();
	public Answer answerQuestion(QuestionDAO q, String question);
}
