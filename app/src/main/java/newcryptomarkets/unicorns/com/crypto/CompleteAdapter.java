package newcryptomarkets.unicorns.com.crypto;

import android.graphics.Bitmap;

/**
 * Created by pabl3 on 01/02/2018.
 */

class CompleteAdapter {

    int Id;
    String name;
    String usd_price;
    String market_cap_usd;
    String last_hour;
    String last24_hours;
    String last_7_days;
    String symbol;
    String available_supply;
    String volume_24h;
    Bitmap image_coin;


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getId() {

        return Id;
    }

    public void setId(int Id1) {

        this.Id = Id1;
    }

    public String getLast_hour() {
        return last_hour;
    }

    public void setLast_hour(String last_hour) {
        this.last_hour = last_hour;
    }

    public String getLast24_hours() {
        return last24_hours;
    }

    public void setLast24_hours(String last24_hours) {
        this.last24_hours = last24_hours;
    }

    public String getLast_7_days() {
        return last_7_days;
    }

    public void setLast_7_days(String last_7_days) {
        this.last_7_days = last_7_days;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUsd_price() {
        return usd_price;
    }

    public void setUsd_price(String usd_price) {
        this.usd_price = usd_price;
    }

    public String getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(String market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public String getAvailable_supply() {
        return available_supply;
    }

    public void setAvailable_supply(String available_supply) {
        this.available_supply = available_supply;
    }

    public String getVolume_24h() {
        return volume_24h;
    }

    public void setVolume_24h(String volume_24h) {
        this.volume_24h = volume_24h;
    }

    public Bitmap getImage_coin() {
        return image_coin;
    }

    public void setImage_coin(Bitmap image_coin) {
        this.image_coin = image_coin;
    }
}
