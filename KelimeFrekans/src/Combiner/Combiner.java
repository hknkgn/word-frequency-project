package Combiner;

public class Combiner {
    public static String CumleleriBirlestir(String... cumleler) {
        if (cumleler == null || cumleler.length == 0) {
            return "";
        }
        // 1. cümleyi output yap
        String output = cumleler[0];
        // Her cümleyi kendisinden 1 öncekiyle birleştir
        for (int i = 1; i < cumleler.length; i++) {
            // output ile bir sonraki cümleleri birleştir.
            output = _cumleyiBirlestir(output, cumleler[i]);
        }
        return output;
    }

    private static String _cumleyiBirlestir(String text1, String text2) {
        // hangi cümle kısaysa onu alt limit olarak al
        int lowerLimit = Math.min(text1.length(), text2.length());

        // outputu 2. cümlenin ilk karakteri yap
        String output = Character.toString(text2.charAt(0));
        boolean success = false;
        for (int i = 1; i < lowerLimit; i++) {
            // Eğer 1. cümle output ile bitmiyorsa outputa şu anki karakteri ekle
            if (!text1.endsWith(output)) {
                output += text2.charAt(i);
            } else {
                success = true;
            }
        }
        if (success && output.length() > 0) {
            // 1. cümleden aynı yeri silip 2. cümleyle birleştir
            return text1.substring(0, text1.length() - output.length()) + text2;
        }
        // Eğer sonda benzerlik yoksa başlangıcı birleştir
        return _cumleBaslaniciBirlestir(text1, text2);
    }

    private static String _cumleBaslaniciBirlestir(String text1, String text2) {
        // hangi cümle kısaysa onu alt limit olarak al
        int lowerLimit = Math.min(text1.length(), text2.length());

        // outputu 2. cümlenin ilk karakteri yap
        String output = Character.toString(text2.charAt(0));
        boolean success = false;
        for (int i = 1; i < lowerLimit +1; i++) {
        	if(i == lowerLimit)
        	{
        		output = output.substring(0, output.length() - 1);
                success = true;
                break;
        	}
            // Eğer 1. cümle output ile başlamıyorsa outputa şu anki karakteri ekle
            if (text1.startsWith(output)) {
                output += text2.charAt(i);
            } else {
                // Son harf aynı olmadığı için onu sil
                output = output.substring(0, output.length() - 1);
                success = true;
                break;
            }
        }
        // 1. cümleden aynı yeri silip 2. cümleyle birleştir
        if (success && output.length() > 0) {
            return text1.substring(0, output.length()) + text2.substring(output.length());
        }
        // Eğer benzerlik yoksa direkt birleştir
        return text1 + " " + text2;
    }
}
