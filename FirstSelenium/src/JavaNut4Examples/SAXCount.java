package JavaNut4Examples;

import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class SAXCount {
    public static void main(String[] args) 
	throws SAXException,IOException, ParserConfigurationException
    {
	// Create a parser factory and use it to create a parser
	SAXParserFactory parserFactory = SAXParserFactory.newInstance();
	SAXParser parser = parserFactory.newSAXParser();
	// This is the name of the file we're parsing
	String filename = args[0];
	// Instantiate a DefaultHandler subclass to do our counting for us
	CountHandler handler = new CountHandler();
	// Start the parser. It reads the file and calls methods of the handler
	parser.parse(new File(filename), handler);
	// When we're done, report the results stored by our handler object
	System.out.println(filename + " contains " + handler.numElements +
			   " elements and " + handler.numChars +
			   " other characters ");
    }

    // This inner class extends DefaultHandler to count elements and text in
    // the XML file and saves the results in public fields. There are lots of
    // other DefaultHandler method we could override, but we only need these.
    public static class CountHandler extends DefaultHandler {
	public int numElements = 0, numChars = 0;  // Save counts here
	// This method is invoked when the parser encounters the opening tag
	// of any XML element.  We ignore the arguments but count the element
	public void startElement(String uri, String localname, String qname,
				 Attributes attributes) {
	    numElements++;
	}

	// This method is called for any plain text within an element.
	// We just count the number of characters in that text.
	public void characters(char[] text, int start, int length) {
	    numChars += length;
	}
    }
}
