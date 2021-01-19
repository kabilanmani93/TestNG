package APITesting;

import factory.DataProviderFactory;

import java.net.URL;

public class parseURL 
{
 static URL url;
 static String urlString = DataProviderFactory.getConfig().getUMURL();
  
  //get Protocol
  public static String getProtocol() throws Exception
  {	  
	  url = new URL(urlString);
	  String protocol = url.getProtocol();
	  return protocol;
  }

    public static String getProtocol(String link) throws Exception
    {
        url = new URL(link);
        String protocol = url.getProtocol();
        return protocol;
    }
  
  //get HOST
  public static String getHost() throws Exception
  {
	  url = new URL(urlString);
	  String host = url.getHost();
	  return host;
  }
    public static String getHost(String link) throws Exception
    {
        url = new URL(link);
        String host = url.getHost();
        return host;
    }

  
  
  /*public static void main(final String... args) throws Exception 
  {
	  //String urlString = DataProviderFactory.getConfig().getUMURL();
	  url = new URL(urlString);
	  String host = url.getHost();
	  System.out.println(host);
	  
	  
	  
	  /*final String urlString = "http://example.com:80/docs/books/tutorial\"\n" + 
    		"            + \"/index.html?name=networking#DOWNLOADING";
    final URL url = new URL(urlString);
    final String host = url.getHost();
    final String protocol = url.getProtocol();
    final InternetDomainName name = InternetDomainName.from(host).topPrivateDomain();
    System.out.println(urlString);
    System.out.println(protocol + " "+ host);
    System.out.println(name);
    
    
    URL aURL = new URL("http://example.com:80/docs/books/tutorial"
            + "/index.html?name=networking#DOWNLOADING");
    
    System.out.println("protocol = " + aURL.getProtocol()); //http
    System.out.println("authority = " + aURL.getAuthority()); //example.com:80
    System.out.println("host = " + aURL.getHost()); //example.com
    System.out.println("port = " + aURL.getPort()); //80
    System.out.println("path = " + aURL.getPath()); //  /docs/books/tutorial/index.html
    System.out.println("query = " + aURL.getQuery()); //name=networking
    System.out.println("filename = " + aURL.getFile()); ///docs/books/tutorial/index.html?name=networking
    System.out.println("ref = " + aURL.getRef()); //DOWNLOADING    */
  
  
}