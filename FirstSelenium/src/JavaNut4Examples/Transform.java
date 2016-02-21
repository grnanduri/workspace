import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Transform {
    public static void main(String[] args)
        throws TransformerConfigurationException,
	       TransformerException
    {
	// Get Source and Result objects for input, stylesheet, and output.
	StreamSource input = new StreamSource(new File(args[0]));
	StreamSource stylesheet = new StreamSource(new File(args[1]));
	StreamResult output = new StreamResult(new File(args[2]));

	// Create a transformer and preform the transformation.
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer(stylesheet);
	transformer.transform(input, output);
    }
}
