package edu.csumb.cst438fa16.hangman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class  QuestionsAnswers{
	/***	Maps	question	to	answer.*/
    HashMap<String,String> questionMap = new HashMap<String, String>();
    
    public String start()
    {
    	this.put("Roses are?", "red");
    	this.put("Why?", "Because.");
    	this.put("What is the air speed velocity of an unladen swallow?", "African or European swallow");
    	return this.getRandomQuestion();
    }
    
	void	put(String	question,	String	answer)	
	{
		questionMap.put(question, answer);
	}
	/***	Queries	if	question	maps	to	answer.*/
	public String	testAnswer(String	question,	String	answer)	
	{
		if(answer.equals(questionMap.get(question)))
		{
			return "Correct!";
		}
		else
		{
			return "Incorrect!";
		}
	}
	
	

	/***	Gives	out	a	random	question	from	the	key	set.*/
	String	getRandomQuestion()	
	{
		Random       random    = new Random();
		List<String> keys      = new ArrayList<String>(questionMap.keySet());
		String       randomKey = keys.get( random.nextInt(keys.size()) );
		return randomKey;
	}
}