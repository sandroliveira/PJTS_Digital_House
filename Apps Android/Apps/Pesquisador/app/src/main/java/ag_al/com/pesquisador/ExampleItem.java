package ag_al.com.pesquisador;

public class ExampleItem {
    private String mImageurl;
    private String mCreator;
    private int mLikes;

    public ExampleItem(String mImageurl, String mCreator, int mLikes) {
        this.mImageurl = mImageurl;
        this.mCreator = mCreator;
        this.mLikes = mLikes;
    }

    public String getmImageurl() {
        return mImageurl;
    }

    public String getmCreator() {
        return mCreator;
    }

    public int getmLikes() {
        return mLikes;
    }
}
