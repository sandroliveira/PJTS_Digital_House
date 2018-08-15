package ag_al.com.retrofittest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image_url")
    @Expose
    private String imagem;
    @SerializedName("description")
    @Expose
    private String desc;

    public Results(String title, String imagem, String desc) {
        this.title = title;
        this.imagem = imagem;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
