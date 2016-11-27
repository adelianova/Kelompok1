package id.sch.smktelkom_mlg.project.xirpl601101928.takel1.rumh;

import java.io.Serializable;

/**
 * Created by Mochammad Al_97 on 11/27/2016.
 */
public class RumahModel implements Serializable {

    public String judul;
    public String descripsi;
    public String foto;
    public String detail;

    public RumahModel(String judul, String descripsi, String foto, String detail) {
        this.judul = judul;
        this.descripsi = descripsi;
        this.foto = foto;
        this.detail = detail;
    }
}
