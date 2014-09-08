package ie.cpr.controller.utils;

import ie.cpr.controller.TrainController;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class Utils {
	private static final Logger LOG = Logger.getLogger(Utils.class);
	private static final String START = "start ..";
	private static final String END = ".. end";
	
	public static void main(String[] args){
		System.getProperties().put("http.proxyHost", "10.0.88.120");
		System.getProperties().put("http.proxyPort", "80");
		System.getProperties().put("http.proxyUser", "colm.ryan");
		System.getProperties().put("http.proxyPassword", "pass.9");
		
		Utils u = new Utils();
		u.getXMLFromUrl("http://api.irishrail.ie/realtime/realtime.asmx/getCurrentTrainsXML");
	}

	public Utils() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public String readXmlWriteJson(String xml) throws IOException {
	 * JsonFactory jsonFactory = new JsonFactory(); XmlFactory xmlFactory = new
	 * XmlFactory(); XmlMapper xmlMapper = new XmlMapper();
	 * 
	 * StringWriter w = new StringWriter();
	 * 
	 * JsonParser jp = xmlFactory.createParser(xml); JsonGenerator jg =
	 * jsonFactory.createGenerator(w); while (jp.nextToken() != null) {
	 * jg.copyCurrentEvent(jp); } jp.close(); jg.close();
	 * 
	 * System.out.println(
	 * "JSON ******************************************************************************************"
	 * ); System.out.println(w.toString()); System.out.println(
	 * "JSON ******************************************************************************************"
	 * ); return w.toString(); }
	 */

	public String getXMLFromUrl(String theUrl) {
		if (LOG.isDebugEnabled()) {
			LOG.debug(START);
		}

		try {
			
			URL url = null;
			URLConnection urlConn = null;
			
			StringBuffer xmlBuffer = new StringBuffer();
			try {
				url = new URL(theUrl);
				urlConn = url.openConnection();
				urlConn.connect();
				
				BufferedInputStream in = new BufferedInputStream(urlConn.getInputStream());
				   int ch;
				   while ((ch = in.read()) != -1) {
					   xmlBuffer.append((char) ch);
				   }
				in.close();
			} catch (MalformedURLException e) {
				System.out.println("url bother");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("io bother");
				e.printStackTrace();
			}

			if (LOG.isDebugEnabled()) {
				LOG.debug("XML : " + xmlBuffer.toString());
			}

			return xmlBuffer.toString();

		} finally {
			if (LOG.isDebugEnabled()) {
				LOG.debug(END);
			}
		}
	}

	/*
	 * public JSONArray getJSONFromXML(String xml){ String json = null;
	 * JSONArray jsonArray = new JSONArray(); try { JSONObject trains =
	 * XML.toJSONObject(xml); Iterator itx = trains.keys();
	 * 
	 * while (itx.hasNext()){ String key = (String) itx.next();
	 * System.out.println("key : " + key);
	 * 
	 * jsonArray.put(trains.get(key)); }
	 * 
	 * 
	 * 
	 * 
	 * } catch (JSONException je) { System.out.println(je.toString()); }
	 * 
	 * return jsonArray;
	 * 
	 * 
	 * 
	 * }
	 */

}
