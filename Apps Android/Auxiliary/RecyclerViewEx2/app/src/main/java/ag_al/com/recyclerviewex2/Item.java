package ag_al.com.recyclerviewex2;

public class Item {
    private int iResource;
    private String textName;
    private String textPrice;

    public Item(int iResource, String textName, String textPrice) {
        this.iResource = iResource;
        this.textName = textName;
        this.textPrice = textPrice;
    }

    public int getiResource() {
        return iResource;
    }

    public String getTextName() {
        return textName;
    }

    public String getTextPrice() {
        return textPrice;
    }
}
