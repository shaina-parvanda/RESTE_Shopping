package com.restful.electronicshopping.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Main {

	private static final String webServiceURI = "http://localhost:8080/RESTFirstExample";

	public static void main(String[] args) {
		/*ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);*/

		try {

			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/RESTE_Shopping/sellerapp/add");

			ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			/* WebResource webResource1 = client.resource("http://localhost:8080/ClientRESTfulExample/rest/json/metallica/post");
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
			 */
			String output = response.getEntity(String.class);
			System.out.println("Output from Server .... \n");
			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}