package newcryptomarkets.unicorns.com.crypto;

import android.graphics.Bitmap;

/**
 * Created by pabl3 on 30/01/2018.
 */

public class Coins {

    private String id;
    private String title;
    private String title2;
    private String usdPrice;
    private String btcPrice;
    private String change24H;
    private String maxSupply;
    private String change7d;
    private String volumeUsd24H;
    private String change1H;
    private String marketCapUsd;
    private String availableSupply;
    private String totalSupply;
    private String lastUpdated;
    private Bitmap bitmap;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String getTitle2() {
        return title2;
    }

    void setTitle2(String title2) {
        this.title2 = title2;
    }

    String getUsdPrice() {
        return usdPrice;
    }

    void setUsdPrice(String usdPrice) {
        this.usdPrice = usdPrice;
    }

    String getBtcPrice() {
        return btcPrice;
    }

    void setBtcPrice(String btcPrice) {
        this.btcPrice = btcPrice;
    }

    String getChange24H() {
        return change24H;
    }

    void setChange24H(String change24H) {
        this.change24H = change24H;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(String maxSupply) {
        this.maxSupply = maxSupply;
    }

    String getChange7d() {
        return change7d;
    }

    void setChange7d(String change7d) {
        this.change7d = change7d;
    }

    public String getVolumeUsd24H() {
        return volumeUsd24H;
    }

    void setVolumeUsd24H(String volumeUsd24H) {
        this.volumeUsd24H = volumeUsd24H;
    }

    String getChange1H() {
        return change1H;
    }

    void setChange1H(String change1H) {
        this.change1H = change1H;
    }

    String getMarketCapUsd() {
        return marketCapUsd;
    }

    void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    String getAvailableSupply() {
        return availableSupply;
    }

    void setAvailableSupply(String availableSupply) {
        this.availableSupply = availableSupply;
    }

    String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

}
