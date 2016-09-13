package edu.csumb.cst438fa16.hangman;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class QuestionAnswersTest {
    @Test
    public void testWord() {
    QuestionsAnswers hangman = new QuestionsAnswers();
    hangman.start();
	assertThat(hangman.testAnswer("Roses are?", "red"), equalTo("Correct!"));
    }
}
