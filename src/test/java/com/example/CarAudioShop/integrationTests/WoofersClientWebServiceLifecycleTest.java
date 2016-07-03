package com.example.CarAudioShop.integrationTests;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.MediaType;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.CarAudioShop.data.WoofersDAO;
import com.example.CarAudioShop.model.Woofers;
import com.example.CarAudioShop.rest.JaxRsActivator;
import com.example.CarAudioShop.rest.WoofersWS;

@RunWith(Arquillian.class)
@RunAsClient
public class WoofersClientWebServiceLifecycleTest {
	private static final String RESOURCE_PREFIX = JaxRsActivator.class
			.getAnnotation(ApplicationPath.class).value().substring(1);
	private ClientRequest request;
	private ClientResponse<String> responseObj;
	private String jsonData;

	@Deployment(testable = false)
	public static WebArchive createDeployment() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addClasses(WoofersWS.class, JaxRsActivator.class,
						WoofersDAO.class, Woofers.class)
				.addAsResource("test-persistence.xml",
						"META-INF/persistence.xml").addAsResource("import.sql")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@ArquillianResource
	URL deploymentUrl;

	@Test 
	@InSequence(1)
	public void testGetAllWoofersFromDB() throws Exception{
		request = new ClientRequest(deploymentUrl.toString() + RESOURCE_PREFIX + "/woofers");
		request.header("Accept", MediaType.APPLICATION_JSON);
		// we're expecting a String back
        ClientResponse<String> responseObj = request.get(String.class);
        assertEquals(200, responseObj.getStatus());
        String response = responseObj.getEntity().trim();
        Assert.assertTrue(response.contains("\"id\":10"));
        
	}
	
	@Test 
	@InSequence(2)
	public void testGetWooferByIdFromDB() throws Exception{
		request = new ClientRequest(deploymentUrl.toString() + RESOURCE_PREFIX + "/woofers/10");
		request.header("Accept", MediaType.APPLICATION_JSON);
        responseObj = request.get(String.class);
        assertEquals(200, responseObj.getStatus());
        String response = responseObj.getEntity().trim();
        Assert.assertTrue(response.contains("\"id\":10"));
	}
	
	@Test 
	@InSequence(3)
	public void testCreateAndPostWooferToDB() throws Exception{
		jsonData = "{\"model\": \"20WP38/4\",\"term_Desc\": null,\"mag_Desc\": \"Vented magnet system, Weight - 566 g\",\"dualMG\": 0,\"fs\": 30,\"qms\": 3,\"vas\": 0.068,\"cms\": 0,\"mms\": 0.025,\"rms\": 0,\"xlin\": 0.005,\"p_Dia\": \"0\",\"sd\": 0.0212,\"qes\": 0.36,\"re\": 3.3,\"le\": 0.00051,\"z\": 4,\"bl\": 0,\"pe\": 80,\"qts\": 0.32,\"eff\": 0,\"spl1\": 89,\"spl2\": 0,\"company_ID\": 7,\"notes\": null,\"piston_Desc\": \"Polypropylene cone\",\"susp_Desc\": \"Foam surround\",\"dust_Cap_Desc\": \"Poly\",\"frame_Desc\": null,\"vc_Desc\": \"38 mm diameter. Aluminium former\",\"date\": \"1997-07-31\",\"comment\": null}";
		request = new ClientRequest(deploymentUrl.toString() + RESOURCE_PREFIX + "/woofers");
		request.accept("application/json").body(MediaType.APPLICATION_JSON, jsonData);
		responseObj = request.post(String.class);
        assertEquals(201, responseObj.getStatus());
        String response = responseObj.getEntity().trim();
        Assert.assertTrue(response.contains("\"id\":11"));
	}
	
	@Test
	@InSequence(4)
	public void testPutBase_data() throws Exception {
		jsonData = "{\"model\": \"20WP38/4\",\"id\": 12,\"term_Desc\": null,\"mag_Desc\": \"Vented magnet system, Weight - 566 g\",\"dualMG\": 0,\"fs\": 30,\"qms\": 3,\"vas\": 0.068,\"cms\": 0,\"mms\": 0.025,\"rms\": 0,\"xlin\": 0.005,\"p_Dia\": \"0\",\"sd\": 0.0212,\"qes\": 0.36,\"re\": 3.3,\"le\": 0.00051,\"z\": 4,\"bl\": 0,\"pe\": 80,\"qts\": 0.32,\"eff\": 0,\"spl1\": 89,\"spl2\": 0,\"company_ID\": 7,\"notes\": null,\"piston_Desc\": \"Polypropylene cone\",\"susp_Desc\": \"Foam surround\",\"dust_Cap_Desc\": \"Poly\",\"frame_Desc\": null,\"vc_Desc\": \"38 mm diameter. Aluminium former\",\"date\": \"1997-07-31\",\"comment\": null}";
		request = new ClientRequest(deploymentUrl.toString() + RESOURCE_PREFIX + "/woofers/11");
		request.accept("application/json").body(MediaType.APPLICATION_JSON, jsonData);
		responseObj = request.put(String.class);
		assertEquals(200, responseObj.getStatus());
		String response = responseObj.getEntity().trim();
		Assert.assertFalse(response.contains("\"id\":11"));
		Assert.assertTrue(response.contains("\"id\":12"));
	}
	
	@Test
	@InSequence(5)
	public void testFindWooferByModelNameInDB() throws Exception {
		request = new ClientRequest(deploymentUrl.toString() + RESOURCE_PREFIX + "/woofers/search/20WP38");
		request.header("Accept", MediaType.APPLICATION_JSON);
		responseObj = request.get(String.class);
		assertEquals(200, responseObj.getStatus());
		String response = responseObj.getEntity().trim();
		Assert.assertFalse(response.contains("\"ES64\""));
		Assert.assertTrue(response.contains("\"Vented magnet system, Weight - 566 g\""));
	}
	
	@Test
	@InSequence(6)
	public void testFindChangedWooferFoundByIdInDB() throws Exception {
		request = new ClientRequest(deploymentUrl.toString() + RESOURCE_PREFIX + "/woofers/12");
		request.header("Accept", MediaType.APPLICATION_JSON);
        responseObj = request.get(String.class);
        assertEquals(200, responseObj.getStatus());
        String response = responseObj.getEntity().trim();
		Assert.assertFalse(response.contains("\"id\":11"));
		Assert.assertTrue(response.contains("\"id\":12"));
	}
	
	@Test
	@InSequence(7)
	public void testWooferDeleteByIdFromDB() throws Exception {
		request = new ClientRequest(deploymentUrl.toString() + RESOURCE_PREFIX + "/woofers/12");
		request.header("Accept", MediaType.APPLICATION_JSON);
        responseObj = request.delete(String.class);
        assertEquals(204, responseObj.getStatus());
	}
	
	@Test
	@InSequence(8)
	public void testNotFindDeletedWooferByIdFromDB() throws Exception {
		request = new ClientRequest(deploymentUrl.toString() + RESOURCE_PREFIX + "/woofers/12");
		request.header("Accept", MediaType.APPLICATION_JSON);
        responseObj = request.get(String.class);
        assertEquals(404, responseObj.getStatus());
	}
	
}
