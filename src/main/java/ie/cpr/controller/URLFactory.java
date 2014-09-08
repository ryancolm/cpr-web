package ie.cpr.controller;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import java.net.URL;
import java.util.Hashtable;
 
public class URLFactory implements ObjectFactory {
 public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable environment) throws Exception {
 Reference ref = (Reference) obj;
 String urlString =  (String) ref.get("url").getContent();
 return new URL(urlString);
 }
}