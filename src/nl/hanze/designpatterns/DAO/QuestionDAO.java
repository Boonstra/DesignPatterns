package nl.hanze.designpatterns.DAO;

import nl.hanze.designpatterns.domain.*;

/**
 * Component interface
 * @author Vincent
 *
 */
public interface QuestionDAO {
	public Question getRootQuestion();

	public void print();
}
