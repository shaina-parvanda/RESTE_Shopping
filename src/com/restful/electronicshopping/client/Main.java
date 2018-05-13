package com.restful.electronicshopping.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.io.IOException;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class Main {
	
	private static String url = "http://localhost:8080/RESTE_Shopping/sellerapp/getAllProdutDetails";

	  public static void main(String[] args) {
	    // Create an instance of HttpClient.
	    HttpClient client = new HttpClient();

	    // Create a method instance.
	    GetMethod method = new GetMethod(url);
	    
	    // Provide custom retry handler is necessary
	    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
	    		new DefaultHttpMethodRetryHandler(3, false));

	    try {
	      // Execute the method.
	      int statusCode = client.executeMethod(method);

	      if (statusCode != HttpStatus.SC_OK) {
	        System.err.println("Method failed: " + method.getStatusLine());
	      }

	      // Read the response body.
	      byte[] responseBody = method.getResponseBody();

	      // Deal with the response.
	      // Use caution: ensure correct character encoding and is not binary data
	      System.out.println(new String(responseBody));

	    } catch (HttpException e) {
	      System.err.println("Fatal protocol violation: " + e.getMessage());
	      e.printStackTrace();
	    } catch (IOException e) {
	      System.err.println("Fatal transport error: " + e.getMessage());
	      e.printStackTrace();
	    } finally {
	      // Release the connection.
	      method.releaseConnection();
	    }  
	  }

	/*private static final String webServiceURI = "http://localhost:8080/RESTE_Shopping";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);	

		try {

			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/RESTE_Shopping/sellerapp/add");

			ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			 WebResource webResource1 = client.resource("http://localhost:8080/ClientRESTfulExample/rest/json/metallica/post");
				String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
				ClientResponse response1 = webResource1.type("application/json").post(ClientResponse.class, input);

                        if (response1.getStatus() != 201) {

                              throw new RuntimeException("Failed : HTTP error code : "

                                   + response1.getStatus());

                        }

                        String output = response.getEntity(String.class);

                        System.out.println("Output from Server .... \n");

                        System.out.println(output);

                        System.out.println("Output1 from Server .... \n");

                        String output1 = response1.getEntity(String.class);

                        System.out.println(output1);
			 
			String output = response.getEntity(String.class);
			System.out.println("Output from Server .... \n");
			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}