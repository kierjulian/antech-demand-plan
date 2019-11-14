package ph.edu.up.antech.util;

import com.opencsv.CSVReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVParserTest {

	@Test
	public void printContentsFromCSVFile_shouldBeSuccessful() {
		try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/SampleCSV.csv"));
			 CSVReader csvReader = new CSVReader(reader)) {
			Object[] record;
			while ((record = csvReader.readNext()) != null) {
				System.out.println((String) record[0]);
				System.out.println(record[1]);
				System.out.println(record[2]);
				System.out.println(record[3]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
