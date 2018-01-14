import java.io.BufferedReader;
import java.io.FileReader;

public class FileExpression {
    StringBuffer content = new StringBuffer();
    public FileExpression(String filename){
        String line;
        try {
            BufferedReader buff = new BufferedReader(new FileReader(filename));
            while((line = buff.readLine()) != null){
                content.append(line);
            }
            buff.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String getContents(){
        return content.toString();
    }
}
