package nl.hanze.designpatterns.DAO.impl.ser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import nl.hanze.designpatterns.DAO.QuestionDAO;
import nl.hanze.designpatterns.domain.Answer;
import nl.hanze.designpatterns.domain.Question;

public class QuestionDAOImpl implements QuestionDAO {

	Question q;
	public QuestionDAOImpl(){
        q = null;
        try
        {
           FileInputStream fileIn = new FileInputStream("question.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           q = (Question) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i)
        {
           i.printStackTrace();
           return;
        }catch(ClassNotFoundException c)
        {
           System.out.println("Employee class not found");
           c.printStackTrace();
           return;
        }
        answerQuestion();
	}
	@Override
	public Question getRootQuestion() {
        return q;
	}
	
	public void answerQuestion(){
        Answer a = q.answerQuestion(getRootQuestion(), "Fiets gestolen");
        if(a == null){
        	System.out.println("Geen antwoord gevonden");
        }
        else{
        	System.out.println(a.getAnswer());
        }
	}
	@Override
	public Answer answerQuestion(QuestionDAO q, String question) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
