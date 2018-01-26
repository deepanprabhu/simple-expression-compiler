package types;

import lombok.Getter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class Factor {
    static int ordinal = 0;
    StringBuffer dataSection;
    StringBuffer textSection;
    StringBuffer bssSection;

    @Getter
    int ordinalValue;

    public Factor(){
        ordinalValue = ordinal++;
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
