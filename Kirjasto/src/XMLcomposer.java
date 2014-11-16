
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream.GetField;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class XMLcomposer  {

	//createXmlDocument("C://Customer.xml");

	KirjastoToiminnot kirjasto = new KirjastoToiminnot();
	static public void createXmlDocument() {

		XMLOutputFactory factory = XMLOutputFactory.newFactory();

		String fileInfo = "/Users/mikaeade/kirjasto/kirjasto.xml";
		FileOutputStream fos;
		XMLStreamWriter writer = null;

		try {

			fos = new FileOutputStream(fileInfo);
			writer = factory.createXMLStreamWriter(fos, "UTF-8");
		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
		}  
		catch (XMLStreamException e) {

			e.printStackTrace();
		}

		writeToDocument(writer);

	}

	private static void writeToDocument(XMLStreamWriter writer) {

		try {

			writer.writeStartDocument();
			writer.writeCharacters("\n");
			writer.writeStartElement("teokset");
			writer.writeCharacters("\n");

			for(Teos teos : KirjastoToiminnot.teokset){
				writer.writeCharacters("\t");
				if(teos instanceof Kirja)
				{	
					writer.writeStartElement("Kirja");
					writer.writeAttribute("teoksenNimi", String.valueOf(teos.getTeoksenNimi()));

					writer.writeCharacters("\n\t\t");
					writer.writeStartElement("ISBN");
					writer.writeCharacters(teos.getTeoksenISBN());
					writer.writeEndElement();

					writer.writeCharacters("\n\t\t");
					writer.writeStartElement("Tekija");
					writer.writeCharacters(teos.getTeoksenTekija());
					writer.writeEndElement();
					
					writer.writeCharacters("\n\t\t");
					writer.writeStartElement("SivujenLkm");
					writer.writeCharacters(String.valueOf(((Kirja) teos).getSivujenLkm()));
					writer.writeEndElement();

					writer.writeCharacters("\n\t");
					writer.writeEndElement();
					writer.writeCharacters("\n");
				}
			}

			writer.writeEndElement();
			writer.writeEndDocument();
			writer.close();

		} catch (XMLStreamException e) {

			e.printStackTrace();
		}
	}
}
//- See more at: http://www.hubberspot.com/2013/02/how-to-write-xml-file-through-simple.html#sthash.Z7IpyTc9.dpuf
