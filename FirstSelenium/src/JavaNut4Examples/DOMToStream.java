package JavaNut4Examples;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMToStream {
    public static void main(String[] args) 
        throws ParserConfigurationException,
	       TransformerConfigurationException,
	       TransformerException
    {
	// Create a DocumentBuilderFactory and a DocumentBuilder
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db = dbf.newDocumentBuilder();
	// Instead of parsing an XML document, however, just create an empty
	// document that we can  build up ourselves.
	Document document = db.newDocument();

	// Now build a document tree using DOM methods
	Element book = document.createElement("book");  // Create new element
	book.setAttribute("id", "javanut4");            // Give it an attribute
	document.appendChild(book);                     // Add to the document
	for(int i = 1; i <= 3; i++) {                   // Add more elements
	    Element chapter = document.createElement("chapter");
	    Element title = document.createElement("title");
	    title.appendChild(document.createTextNode("Chapter " + i));
	    chapter.appendChild(title);
	    chapter.appendChild(document.createElement("para"));
	    book.appendChild(chapter);
	}

	// Now create a TransformerFactory, and use it it create a Transformer
	// object to transform or DOM document into a stream of XML text.
	// No arguments to newTransformer() means no XSLT stylesheet
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer();

	// Create the Source and Result objects for the transformation
	DOMSource source = new DOMSource(document);          // DOM document
	StreamResult result = new StreamResult(System.out);  // to XML text

	// Finally do the transformation
	transformer.transform(source, result);
    }
}
