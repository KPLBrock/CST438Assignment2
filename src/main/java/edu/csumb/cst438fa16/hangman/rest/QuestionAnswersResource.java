package edu.csumb.cst438fa16.hangman.rest;

import edu.csumb.cst438fa16.hangman.QuestionsAnswers;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Hangman REST service.
 *
 * See:
 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
 */
@Path("")
public class QuestionAnswersResource {


    private static QuestionsAnswers getQuestionsAnswers() {
	return new QuestionsAnswers();
    }

    @GET
    @Path("/randomQuestion")
    public String randomQuestion() {
	return getQuestionsAnswers().start();
    }

    @GET
    @Path("/testanswer")
    public Response match(
        @QueryParam("pattern") String oldPattern,
        @QueryParam("newGuesses") String newGuesses
    ) 
    {
    	if (oldPattern == null ||  newGuesses == null) {
            return Response.status(Response.Status.BAD_REQUEST)
	                   .entity("requires query parameters " +
				   "oldPattern, newGuesses")
		           .build();
        }

    	QuestionsAnswers questionBed = getQuestionsAnswers();
		return Response.ok(questionBed.testAnswer(oldPattern, newGuesses)).build();
    }
}
