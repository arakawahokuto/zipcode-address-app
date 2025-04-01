import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class ApiClient {

    public static String fetch(String fullUrl) {

        StringBuilder builder = new StringBuilder();

        try {
            //String型のfullUrlをHttpURLConnectionに使うためにURLクラスのインスタンスに変換して接続処理に使えるようにする
            URL url = new URL(fullUrl);
            //HTTPコネクションを開く（urlに対してHTTP接続を開いている）
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //レスポンスの読み取り（Javaではこの三兄弟は頻出なので覚えていると便利）
            //API -(レスポンスのデータ)-> InputStream -> InputStreamReader -> BufferedReader (in)
            //inは文字を1行ずつ読むための「リーダー（読み取り機）」
            BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
            );

            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line);
            }

        } catch (MalformedURLException e) {
            //「開発者のコードミス」 が原因
            System.out.println("URLの形式（構文）がおかしい"); 
        } catch (IOException e) {
            //「ネットワークや環境要因」 が原因
            System.out.println("通信中に起きたエラー"); 
        }

        return builder.toString();

        
    }
}
