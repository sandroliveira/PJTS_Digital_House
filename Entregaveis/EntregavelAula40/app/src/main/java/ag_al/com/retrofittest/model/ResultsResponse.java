package ag_al.com.retrofittest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultsResponse {
    @SerializedName("result")
    @Expose
    private List<Results> results = null;

    public ResultsResponse(List<Results> results) {
        this.results = results;
    }

    public List<Results> getResults() {
        return results;
    }
}
