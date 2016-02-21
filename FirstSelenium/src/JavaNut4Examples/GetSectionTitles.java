package JavaNut4Examples;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class GetSectionTitles {
    public static void main(String[] args)
	throws IOException, ParserConfigurationException,
	       org.xml.sax.SAXException
    {
	// Create a factory object for creating DOM parsers, and configure it
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	factory.setIgnoringComments(true);  // We want to ignore comments
	factory.setCoalescing(true);        // Convert CDATA to Text nodes
	factory.setNamespaceAware(false);   // No namespaces: this is default
	factory.setValidating(false);       // Don't validate DTD: also default

	// Now use the factory to create a DOM parser a.k.a. DocumentBuilder
	DocumentBuilder parser = factory.newDocumentBuilder();

	// Parse the file and build a Document tree to represent its content
	Document document = parser.parse(new File(args[0]));

	// Ask the document for a list of all <sect1> elements it contains
	NodeList sections = document.getElementsByTagName("sect1");
	// Loop through those <sect1> elements one at a time
	int numSections = sections.getLength();
	for(int i = 0; i < numSections; i++) {
	    Element section = (Element)sections.item(i);  // A <sect1>
	    // The first Element child of each <sect1> should be a <title>
	    // element but there may be some whitespace Text nodes first, so 
	    // loop through the children 'till we find the first element child.
	    Node title = section.getFirstChild();
	    while(title != null && title.getNodeType() != Node.ELEMENT_NODE) 
		title = title.getNextSibling();
	    // Print the text contained in the Text node child of this element
	    if (title != null)
		System.out.println(title.getFirstChild().getNodeValue());
	}
    }
}
