package excurioso.ag_al.com.models;

public class Items {
    private String imagemURL;
    private String link;
    private String titulo;

    public Items(){}

    public Items(String imagemURL, String link, String titulo) {
        this.imagemURL = imagemURL;
        this.link = link;
        this.titulo = titulo;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(String imagemURL) {
        this.imagemURL = imagemURL;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
