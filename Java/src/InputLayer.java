import java.io.InputStream;
import java.util.Scanner;

public class InputLayer {
    Scanner scanner;

    InputLayer(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    Tissue DetectInout() {

        int x = 0, y = 0;
        String map = "";
        String input;

        while (scanner.hasNext()) {

            input = scanner.nextLine().replace(" ", "");
            if(input.equals("exit"))
                break;

            map += input + " ";
            if(y==0){
                y=input.length();
            }else if(y != input.length()){
                System.err.println("같은 줄 수가 아닙니다.");
                System.err.println("다시 입력해주세요.");
            }
            x += 1;
        }
        return new Tissue(x,y,map);
    }

}
