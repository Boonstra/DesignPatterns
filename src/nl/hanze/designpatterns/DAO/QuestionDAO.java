package nl.hanze.designpatterns.DAO;

import nl.hanze.designpatterns.domain.*;

/**
 * Component interface
 *
 */
public interface QuestionDAO {
	public Question getRootQuestion();

	public void print();
}
