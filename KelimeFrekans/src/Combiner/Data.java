package Combiner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;
import org.json.JSONPropertyName;

public class Data {
    private static Charset Encoding = StandardCharsets.UTF_8;
    
    public Data(String... values){
        this.values = values;
        Output = Combiner.CumleleriBirlestir(values);
    }
    public void Kaydet(){
        JSONObject json = new JSONObject();
        json.put("inputs", values);
        json.put("output", Output);

        try {
            FileOutputStream fos = new FileOutputStream("output.json");
            OutputStreamWriter osw = new OutputStreamWriter(fos, Encoding);
            osw.write(json.toString());
            osw.flush();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String Output;
    @JSONPropertyName("output")
    public String getOutput() {
        return Output;
    }
    
    private String[] values;    
    @JSONPropertyName("inputs")
    public String[] getInputs() {
        return values;
    }
}

