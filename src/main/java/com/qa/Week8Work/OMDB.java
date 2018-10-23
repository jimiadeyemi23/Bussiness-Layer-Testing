package com.qa.Week8Work;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;

public class OMDB 
{
	
	RequestSpecification request = RestAssured.given();
	
	static Response response = null;
	JSONParser parser = new JSONParser();
	
	
	
	@Given("^a film exists with the Title Guardians of the Galaxy Two$")
	public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	    /*RequestSpecification request = RestAssured.given();
	    Response response = request.get(Constants.omdbKey);
	    response.prettyPrint();*/
	}

	@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
	public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy_Two() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		
		//RequestSpecification request = RestAssured.given();
	    Response response = request.get(Constants.apiKey);
	    response.prettyPrint();
	    
	}

	@Then("^the status code reads (\\d+)$")
	public void the_status_code_reads(int arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		//OmdbPage omdb = new OmdbPage();
		RequestSpecification request = RestAssured.given();
		Response response = request.get(Constants.apiKey);		
		assertEquals(arg1, response.getStatusCode());
		//System.out.println(response.getStatusCode());
	    //response.prettyPrint();
	    
	}

	@Given("^a film exists with the Title IT$")
	public void a_film_exists_with_the_Title_IT() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		Response response = request.get(Constants.iTKey);
		//assertEquals(Constants.iTKey, request.get());
	    
	}

	@When("^a user retrieves the film by the title IT$")
	public void a_user_retrieves_the_film_by_the_title_IT() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^the Rated Field is equal to R$")
	public void the_Rated_Field_is_equal_to_R() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		
		RequestSpecification request = RestAssured.given();
		Response response = request.get(Constants.iTKey);
		
		String rating = response.asString();		
		JSONObject json = (JSONObject) parser.parse(rating);
		
//		if(json.get("Rated").equals("R"))
//		{
//			System.out.println("R has been found");
//		}
		
		assertEquals(true, json.get("Rated").equals("R"));

	}

	@Given("^a film exists with the Title \"([^\"]*)\"$")
	public void a_film_exists_with_the_Title(String arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
		//Response response = request.get(arg1);
		
		//System.out.println(arg1);
		
		//String Film = response.asString();		
		//JSONObject json = (JSONObject) parser.parse(Film);
	}

	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
	public void a_user_retrieves_the_film_by_the_title(String arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		//Response response = request.get();
		RequestSpecification request = RestAssured.given();
		response = request.when().get(Constants.pGKey + arg1);

	}

	@Then("^the Rated Field is equal to \"([^\"]*)\"$")
	public void the_Rated_Field_is_equal_to(String arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions

		String rating = response.asString();		
		JSONObject json = (JSONObject) parser.parse(rating);		
		assertEquals(true, json.get("Rated").equals(arg1));
	}

	
}
