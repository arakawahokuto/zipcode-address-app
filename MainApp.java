import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainApp {
    public static void main(String[] args) {

        List<Address> history = new ArrayList<Address>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("郵便番号をハイフン無しで7桁で入力してください↓");
            String input = scanner.nextLine();

            if(input.equals("exit")) {
                break;
            } else if(input.equals("履歴")) {
                System.out.println(history);
                continue;
            } else if(input.equals("保存")) {
                try {
                    FileWriter writer = new FileWriter("address.csv");
                    BufferedWriter bw = new BufferedWriter(writer);

                    for (Address a : history) {
                        String line = a.getPref() + "," + a.getCity() + "," + a.getTown();
                        bw.write(line);
                        bw.newLine();
                     }

                    bw.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("保存しました");
                continue;
            }

            if(!isValidZipcode(input)) {
                continue;
            }

            Address address = ZipcodeService.fetchAddress(input);
            System.out.println("都道府県：" + address.getPref());
            System.out.println("市区町村：" + address.getCity());
            System.out.println("町域：" + address.getTown());

            history.add(address);
        }

        scanner.close();
    }

    public static boolean isValidZipcode(String input) {
        if(input.length() != 7) {
            System.out.println("郵便番号を7桁で入力してください");
            return false;
        } 
    
        if(!input.matches("\\d{7}")) {
            System.out.println("数字のみで入力してください");
            return false;
        }
    
        return true;
    }

}



