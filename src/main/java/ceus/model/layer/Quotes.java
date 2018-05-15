
package ceus.model.layer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "USDEUR",
    "USDGBP",
    "USDKRW",
    "USDJPY"
})
public class Quotes {

    @JsonProperty("USDEUR")
    private Double uSDEUR;
    @JsonProperty("USDGBP")
    private Double uSDGBP;
    @JsonProperty("USDKRW")
    private Double uSDKRW;
    @JsonProperty("USDJPY")
    private Double uSDJPY;

    @JsonProperty("USDEUR")
    public Double getUSDEUR() {
        return uSDEUR;
    }

    @JsonProperty("USDEUR")
    public void setUSDEUR(Double uSDEUR) {
        this.uSDEUR = uSDEUR;
    }

    @JsonProperty("USDGBP")
    public Double getUSDGBP() {
        return uSDGBP;
    }

    @JsonProperty("USDGBP")
    public void setUSDGBP(Double uSDGBP) {
        this.uSDGBP = uSDGBP;
    }

    @JsonProperty("USDKRW")
    public Double getUSDKRW() {
        return uSDKRW;
    }

    @JsonProperty("USDKRW")
    public void setUSDKRW(Double uSDKRW) {
        this.uSDKRW = uSDKRW;
    }

    @JsonProperty("USDJPY")
    public Double getUSDJPY() {
        return uSDJPY;
    }

    @JsonProperty("USDJPY")
    public void setUSDJPY(Double uSDJPY) {
        this.uSDJPY = uSDJPY;
    }

}
