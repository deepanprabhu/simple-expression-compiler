package types;

import lombok.Getter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class Factor {
    static int ordinal = 0;
    public static StringBuffer prologueSection = new StringBuffer();
    public static StringBuffer dataSection = new StringBuffer();
    public static StringBuffer textSection = new StringBuffer();
    public static StringBuffer bssSection = new StringBuffer();
    public static StringBuffer epilogueSection = new StringBuffer();

    @Getter
    int ordinalValue;

    @Getter
    private String representation;

    static {
        prologueSection.append("extern _printf,_exit\nglobal _main\n\n");
        dataSection.append("section .data\nformat: db \'%d\', 10, 0\n");
        bssSection.append("section .bss\n");
        textSection.append("section .text\n_main:\nsub rsp,8\n");
    }

    public Factor(){
        ordinalValue = ordinal++;
        representation = "[rel number" + ordinalValue + "]";
    }

    public void addDS(String val){
        dataSection.append(val);
    }

    public void addTS(String val){
        textSection.append(val);
    }

    public void addBS(String val){
        bssSection.append(val);
    }
}
