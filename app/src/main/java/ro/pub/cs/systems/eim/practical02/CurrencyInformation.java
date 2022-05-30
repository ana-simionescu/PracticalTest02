package ro.pub.cs.systems.eim.practical02;

public class CurrencyInformation {

    private String eur;
    private String usd;

    public CurrencyInformation() {
        this.eur = null;
        this.usd = null;
    }

    public CurrencyInformation(String eur, String usd) {
        this.eur = eur;
        this.usd = usd;
    }

    public String getEur() {
        return eur;
    }

    public void setEur(String eur) {
        this.eur = eur;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

//    @Override
//    public String toString() {
//        return "Currency Information{" +
//                "temperature='" + temperature + '\'' +
//                ", windSpeed='" + windSpeed + '\'' +
//                ", condition='" + condition + '\'' +
//                ", pressure='" + pressure + '\'' +
//                ", humidity='" + humidity + '\'' +
//                '}';
//    }
}
