package znemux.tempconv;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) showUsage();
        try { converter(args); } catch (NumberFormatException ex) { showUsage(); }
    }
    
    static void converter(String[] args) throws NumberFormatException {
        var tempvalue = Float.parseFloat(args[0]);
        var tempformat = args[1].charAt(0) + "";
        
        if("C".equalsIgnoreCase(tempformat)) {
            System.out.println(CtoF(tempvalue));
        } else if ("F".equalsIgnoreCase(tempformat)) {
            System.out.println(FtoC(tempvalue));
        } else showUsage();
    }
    
    static float CtoF(float tempc) {
        return tempc * 9/5f + 32;
    }
    
    static float FtoC(float tempf) {
        return (tempf - 32) * 5/9f; 
    }
    
    static void showUsage() {
        System.out.println("Usage: tempconv <value> <format>");
        System.exit(1);
    }
}
