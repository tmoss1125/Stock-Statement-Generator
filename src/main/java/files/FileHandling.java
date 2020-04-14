package files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class FileHandling {

	public static JSONArray getStockHolders() {
		
		JSONParser parser = new JSONParser();
		
		try (FileReader reader = new FileReader("stock_transationsbyaccountholder.json")) {
			
			Object obj = parser.parse(reader);
			
			return (JSONArray) obj;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void createHTMLFile(String fileName, String information) {
		File f = new File("html/" + fileName + ".html");
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			writer.write(information);
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void htmlToPDF(String name) {
		
		try (OutputStream os = new FileOutputStream("pdf/" + name + ".pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withUri("file:///C:/Users/tobyi/Google%20Drive/School/Workspace/StockStatementGenerator/html/" + name + ".html");
            builder.toStream(os);
            builder.run();
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
