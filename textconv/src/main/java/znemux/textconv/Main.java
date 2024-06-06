package znemux.textconv;

import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        if (args.length < 2) return;
        
        if (args[0].substring(0, 3).equalsIgnoreCase("bin")) {
            System.out.println(toText(args[1]));
        } else if (args[0].substring(0, 3).equalsIgnoreCase("tex")) {
            System.out.println(toBinaryString(args[1]));
        }
    }
    
    static String toBinaryString(String text) {
        return Arrays.toString(toBinary(text));
    }
    
    static String[] toBinary(String text) {
        var chars = text.toCharArray();
        var binary = new String[chars.length];
        for (int i = 0; i < chars.length; i++)
            binary[i] = Integer.toBinaryString((int)chars[i]);
        return binary;
    }
    
    static String toText(String binary) {
        var array = binary.replaceAll("\\[|\\]", "").split(", ");
        return toText(array);
    }
    
    static String toText(String[] binary) {
        var text = "";
        for (var str : binary)
            text += (char)Integer.parseInt(str, 2);
        return text;
    }
        
}
