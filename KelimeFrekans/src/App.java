import java.util.Scanner;
import java.util.zip.DataFormatException;

import Combiner.*;
public class App {   
    public static void main(String[] args) throws Exception {
        Liste = new DataList();
        scanner = new Scanner(System.in, "UTF-8");
        Loop();
    }
    static DataList Liste;
    static Scanner scanner = null;
    static void Loop() {
        System.out.flush();  
        System.out.println("1- Yeni");
        System.out.println("2- Kaydet");
        System.out.println("3- Kapat");
        System.out.print("Seç: ");
        int choice = scanner.nextInt();
        if(choice == 1) {
        	Yeni();
        }
        else if(choice == 2) {
        	Kaydet();
        }
        else if(choice == 3) {
        	System.out.print("Program Sonlandı. ");
        	System.exit(0);
        }
        Loop();
    }

	private static void Yeni() {        
		System.out.print("Kaç tane input vermek istiyorsunuz? ");
		int amount = scanner.nextInt();
		scanner.nextLine();    
		String[] arr = new String[amount];
		for (int i = 0; i < amount; i++) {
			System.out.print("Input #" + (i + 1) + ": ");
			arr[i] = scanner.nextLine();
			System.out.println(arr[i]);
		}     
        
		// String[] ile data oluştur
        var data = new Data(arr);
        System.out.println("Output: " + data.Output);

		// Kaydetme için 
        Liste.Ekle(data);
    }

	private static void Kaydet() {
		if(Liste.Adet() < 1){            
            System.out.println("Lütfen en az 1 cümle tane oluşturun!");
            return;
        }
        Liste.Kaydet();
	}
}
