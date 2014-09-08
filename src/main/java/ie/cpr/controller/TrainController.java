/**
 *
 */
package ie.cpr.controller;

/**
 * @author colm.ryan
 *
 */

import ie.cpr.controller.utils.Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/currentTrains")
public class TrainController {
	private static final Logger LOG = Logger.getLogger(TrainController.class);
	private static final String START = "start ..";
	private static final String END = ".. end";

	private static String currentTrains = "http://api.irishrail.ie/realtime/realtime.asmx/getCurrentTrainsXML";

	public static void main(String[] args){
		

		
		TrainController trainController = new TrainController();
		
		ModelMap model = new ModelMap();
		
		try {
			String res = trainController.getCurrentTrains(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCurrentTrains(ModelMap model) throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug(START);
		}
		
		JSONArray jsonTrains = null;

		try{
			Utils utils = new Utils();
		
			//XmlUtils xmlUtils = new XmlUtils();

			String xml = utils.getXMLFromUrl(currentTrains);
			
			//InitialContext context = new InitialContext();
			//URL url = (URL) context.lookup("java:comp/env/url/TrainService");
			
			//String xml = (String) url.getContent();
			
			//if (LOG.isDebugEnabled()) {
			//	LOG.debug("XML retrieved : " + xml);
			//}
			
			
			//xml = xmlUtils.removeVersionString(xml);
		
			JSONObject json = readXmlWriteJson(xml);
			
			
			 try {
				 jsonTrains = json.getJSONArray("objTrainPositions");
			
			  if (LOG.isDebugEnabled()) {
					LOG.debug(jsonTrains.size()  + " trains");
				}  
			  
			  
			  /*for(int i=0;i<=result.size();i++)
			 {
			    
				if (LOG.isDebugEnabled()) {
					LOG.debug(result.toString());
				}  
			 }*/
			 } catch (JSONException e) {
			     e.printStackTrace();
			}
			
			LOG.debug("[2] :: " + json);

			model.addAttribute("currentTrains", jsonTrains);
			if (LOG.isDebugEnabled()) {
				LOG.debug("... json ... ");
				LOG.debug(jsonTrains);
				LOG.debug("... json ... ");
			}
			
			return "currentTrains";
		
		 } finally { 
			 if (LOG.isDebugEnabled()) { 
				 LOG.debug(END); 
			 }		 
		 }		 
	}

	


	private JSONObject readXmlWriteJson(String xml) throws IOException {
		if (LOG.isDebugEnabled()) {
			LOG.debug(START);
		}
		
		
		
		XMLSerializer xmlSerializer = new XMLSerializer();  
		JSONObject json = (JSONObject) xmlSerializer.read(xml);  
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("JSON : " + json.toString());
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(END);
		}
		
		return json;
		
	}


}