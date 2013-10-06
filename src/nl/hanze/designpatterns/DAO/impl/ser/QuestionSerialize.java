package nl.hanze.designpatterns.DAO.impl.ser;

import java.io.*;

import nl.hanze.designpatterns.domain.Answer;
import nl.hanze.designpatterns.domain.Question;

/** JDK before version 7. */
public class QuestionSerialize {

  public QuestionSerialize(){
    //create a Serializable List
    Question fiets1 = new Question("fiets");
    
    Question fiets2 = new Question("band");
    Question fiets3 = new Question("leeg");
    Question fiets4 = new Question("plat");
    
    Question fiets5 = new Question("ketting");
    Question fiets6 = new Question("gestolen");
    Question fiets7 = new Question("af");
    Question fiets8 = new Question("eraf");
    
    Answer answer1 = new Answer("Band plakken");
    Answer answer2 = new Answer("Politie bellen");
    Answer answer3 = new Answer("Ketting terug op de fiets zetten");
    
    fiets3.add(answer1);
    fiets4.add(answer1);
    fiets6.add(answer2);
    fiets7.add(answer3);
    fiets8.add(answer3);
    
    fiets2.add(fiets3);
    fiets2.add(fiets4);
    fiets2.add(fiets6);
    
    fiets5.add(fiets6);
    fiets5.add(fiets7);
    fiets5.add(fiets8);
    
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