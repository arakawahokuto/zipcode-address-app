import org.json.JSONObject;

public class ZipcodeService {
    public static Address fetchAddress(String zipcode) {

        //APIエンドポイントのURLを設定（APIにアクセスするためのURL）
        String endpoint = "https://api.zipaddress.net/?zipcode=" + zipcode;

        //ApiClientを使って通信し、結果を習得
        String result = ApiClient.fetch(endpoint);

        //APIで返ってきたJSONの生データ確認
        // System.out.println("返ってきたJSON文字列" + result);

        try {
            //返ってきたJSON文字列をパース（解析）してJSONObject型のjsonに代入
            JSONObject json = new JSONObject(result);
            //jsonの中から住所の情報が入っている「data」の中身をオブジェクトとして取得
            JSONObject data = json.getJSONObject("data");

            //getString()の戻り値はStringなのでString型の変数に代入できる
            String pref = data.getString("pref");
            String city = data.getString("city");
            String town = data.getString("town");
            return new Address(pref, city, town);

            // return pref + city + town;
        } catch (Exception e) {
            e.printStackTrace();
            return new Address("取得失敗", "", "");
        }
    }
}