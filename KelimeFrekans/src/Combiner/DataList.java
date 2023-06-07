package Combiner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.json.JSONObject;

public class DataList
{
	public DataList() {
		datalar = new ArrayList<Data>();
	}
	private ArrayList<Data> datalar;
	public void Ekle(Data data) {
		datalar.add(data);
	}
	public int Adet(){
		return datalar.size();
	}
	public void Kaydet() {
		 JSONObject json = new JSONObject();
	        json.put("Datalar", datalar);

	        try {
	            FileOutputStream fos = new FileOutputStream("outputListesi.json");
	            OutputStreamWriter osw = new OutputStreamWriter(fos);
	            osw.write(json.toString());
	            osw.flush();
	            osw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
