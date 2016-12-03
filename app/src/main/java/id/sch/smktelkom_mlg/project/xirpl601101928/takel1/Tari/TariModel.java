package id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Tari;

import java.io.Serializable;

/**
 * Created by Smktelkom on 11/28/2016.
 */
public class TariModel implements Serializable {

    public String judul;
    public String descripsi;
    public String foto;
    public String detail;

    public TariModel(String judul, String descripsi, String foto, String detail) {
        this.judul = judul;
        this.descripsi = descripsi;
        this.foto = foto;
        this.detail = detail;
    }
}