package newcryptomarkets.unicorns.com.crypto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pabl3 on 30/01/2018.
 */

class CoinsJSONParser {

    static List<Coins> parseData(String content) {

        JSONArray games_arry = null;
        Coins games = null;
        try {

            games_arry = new JSONArray(content);
            List<Coins> coinsList = new ArrayList<>();

            for (int i = 0; i < games_arry.length(); i++) {

                JSONObject obj = games_arry.getJSONObject(i);
                games = new Coins();

                games.setId(obj.getString("rank"));
                games.setTitle(obj.getString("name"));
                games.setUsdPrice(obj.getString("price_usd"));
                games.setTitle2(obj.getString("symbol"));
                games.setChange24H(obj.getString("percent_change_24h"));
                games.setBtcPrice(obj.getString("price_btc"));
                games.setChange1H(obj.getString("percent_change_1h"));
                games.setChange7d(obj.getString("percent_change_7d"));
                games.setVolumeUsd24H(obj.getString("24h_volume_usd"));
                games.setMarketCapUsd(obj.getString("market_cap_usd"));
                games.setAvailableSupply(obj.getString("available_supply"));
                games.setTotalSupply(obj.getString("total_supply"));
                games.setLastUpdated(obj.getString("last_updated"));

                coinsList.add(games);
            }
            return coinsList;
        }
        catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
