package nl.hanze.designpatterns.view;
import java.awt.*;
import java.util.Vector;

import javax.swing.*;

import nl.hanze.designpatterns.DAOFactory.DAOFactoryLogin;
import nl.hanze.designpatterns.DAOFactory.impl.DAOFactoryLoginDBImpl;
import nl.hanze.designpatterns.DAOFactory.impl.DAOFactoryLoginFileImpl;

public class QAThesaurusView extends JPanel{
	private JTextField questionField;
	private JLabel answerField;
	private JButton answerQuestionButton;
	
	public QAThesaurusView(){
	      this.questionField = new JTextField(10);
	      this.answerField = new JLabel("Enter your question");
	      this.answerQuestionButton = new JButton("Answer");
	      
	      this.setLayout(new GridLayout(0,2,0,0));
	      this.add(questionField);
	      this.add(answerQuestionButton);
	      this.add(answerField);
   }
	
	/**
	 * Get Answer Question button for ActionListeners
	 * @return
	 */
	public JButton getAnswerQuestionButton(){
		return answerQuestionButton;
	}
	
	/**
	 * Getter questionField
	 * @return
	 */
	public JTextField getQuestion(){
		return questionField;
	}
	
	/**
	 * Getter Answerfield
	 * @return
	 */
	public JLabel getAnswerField(){
		return answerField;
	}
	
	/**
	 * Setter Answerfield
	 * @param s
	 */
	public void setAnswerField(String s){
		this.answerField.setText(s);
	}
	
}