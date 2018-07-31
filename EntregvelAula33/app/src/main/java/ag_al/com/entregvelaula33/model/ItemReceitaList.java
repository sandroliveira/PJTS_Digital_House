package ag_al.com.entregvelaula33.model;

import java.util.ArrayList;

public class ItemReceitaList extends ArrayList<String> {

    private int xImagem;
    private String xTextView;

    public ItemReceitaList(int xImagem, String xTextView) {
        this.xImagem = xImagem;
        this.xTextView = xTextView;
    }

    public int getxImagem() {
        return xImagem;
    }

    public String getxTextView() {
        return xTextView;
    }
}
