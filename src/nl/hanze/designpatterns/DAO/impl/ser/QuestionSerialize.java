package nl.hanze.designpatterns.DAO.impl.ser;

import java.io.*;

import nl.hanze.designpatterns.domain.Answer;
import nl.hanze.designpatterns.domain.Question;

/** JDK before version 7. */
public class QuestionSerialize {

  public QuestionSerialize(){
    //create a Serializable List
    Question fiets1 = new Question("Fiets");
    
    Question fiets2 = new Question("Band");
    Question fiets3 = new Question("Leeg");
    Question fiets4 = new Question("Plat");
    
    Question fiets5 = new Question("Ketting");
    Question fiets6 = new Question("Gestolen");
    
    Answer answer1 = new Answer("Band plakken");
    Answer answer2 = new Answer("Politie bellen");
    
    fiets3.add(answer1);
    fiets4.add(answer1);
    fiets6.add(answer2);
    
    fiets2.add(fiets3);
    fiets2.add(fiets4);
    fiets2.add(fiets6);
    fiets5.add(fiets6);
    
    fiets1.add(fiets2);
    fiets1.add(fiets5);
    fiets1.add(fiets6);
    try
    {
       FileOutputStream fileOut =
       new FileOutputStream("question.ser");
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
       out.writeObject(fiets1);
       out.close();
       fileOut.close();
       System.out.println("Serialized data is saved in question.ser");
    }catch(IOException i)
    {
        i.printStackTrace();
    }
  }
} 