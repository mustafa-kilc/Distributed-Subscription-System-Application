package proje1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MultiStringArrays implements Serializable {
    private static final long serialVersionUID = 1L;

    private long lastUpdatedEpochMiliSeconds;
    private List<Boolean> abonelerListesi;
    private List<Boolean> girisYapanlarListesi;

    public MultiStringArrays() {
        lastUpdatedEpochMiliSeconds = 0;
        abonelerListesi = new ArrayList<>();
        girisYapanlarListesi = new ArrayList<>();
    }

    public long getLastUpdatedEpochMiliSeconds() {
        return lastUpdatedEpochMiliSeconds;
    }

    public void setLastUpdatedEpochMiliSeconds(long lastUpdatedEpochMiliSeconds) {
        this.lastUpdatedEpochMiliSeconds = lastUpdatedEpochMiliSeconds;
    }

    public List<Boolean> getAbonelerListesi() {
        return abonelerListesi;
    }

    public void setAbonelerListesi(List<Boolean> abonelerListesi) {
        this.abonelerListesi = abonelerListesi;
    }

    public List<Boolean> getGirisYapanlarListesi() {
        return girisYapanlarListesi;
    }

    public void setGirisYapanlarListesi(List<Boolean> girisYapanlarListesi) {
        this.girisYapanlarListesi = girisYapanlarListesi;
    }

    // You can add additional methods here for error correction or other functionalities.
}
