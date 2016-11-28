package id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Pakain;

/**
 * Created by intel on 28/11/2016.
 */

import java.io.Serializable;

public class PakaianModel implements Serializable {

    public String judul;
    public String descripsi;
    public String foto;
    public String detail;

    public PakaianModel(String judul, String descripsi, String foto, String detail) {
        this.judul = judul;
        this.descripsi = descripsi;
        this.foto = foto;
        this.detail = detail;
    }
}
