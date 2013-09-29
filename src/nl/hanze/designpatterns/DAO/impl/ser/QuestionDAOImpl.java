package nl.hanze.designpatterns.DAO.impl.ser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import nl.hanze.designpatterns.DAO.QuestionDAO;
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
	}
	@Override
	public Question getRootQuestion() {
        return q;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	public void answerQuestion(String question){
		String[] parts = question.split(" ");
        for (String part : parts) {
            q.print();
        }
	}
	
}
