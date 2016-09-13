package edu.csumb.cst438fa16.hangman.rest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.*;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * See:
 * https://jersey.java.net/documentation/latest/test-framework.html
 * https://jersey.java.net/apidocs/latest/jersey/index.html
 */
public class QuestionAnswersResourceTest extends JerseyTest {
    static private final String WORD = "cat";  // the word used in this test

    @Override
    protected Application configure() {
        return new ResourceConfig(QuestionAnswersResource.class);
    }

    // setup() and teardown() are copied from
    // http://apmblog.dynatrace.com/2014/02/25/how-stable-are-your-unit-tests-best-practices-to-raise-test-automation-quality/
    // (which also suggests a better solution)
    private String oldWord;


    @Before
    public void setup() {
        // setProperty returns the old value of the property

    }

    @After
    public void teardown() {
    }



    @Test
    public void testMatchWithCorrectOldPatternOldGuesses() {
        WebTarget webTarget = target("testanswer").queryParam("pattern", "Roses are?")
                                             .queryParam("newGuesses", "red");
        String thematch = webTarget.request().get(String.class);
        assertThat(thematch, equalTo("Incorrect!"));
    }
}
