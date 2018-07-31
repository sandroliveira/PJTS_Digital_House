package ag_al.com.entregvelaula33.model;

import android.widget.TextView;

public class ItemReceita {
    private String nTextMin;
    private String nTextIngred;
    private String nTextMdp;

    public ItemReceita(String nTextMin, String nTextIngred, String nTextMdp) {
        this.nTextMin = nTextMin;
        this.nTextIngred = nTextIngred;
        this.nTextMdp = nTextMdp;
    }

    public String getnTextMin() {
        return nTextMin;
    }

    public String getnTextIngred() {
        return nTextIngred;
    }

    public String getnTextMdp() {
        return nTextMdp;
    }

    @Override
    public String toString() {
        return "Tempo de Preparo='" + nTextMin + '\'' + ", Ingredientes='" + nTextIngred + '\'' + ", Modo de Preparo='" + nTextMdp + '\'';
    }
}
