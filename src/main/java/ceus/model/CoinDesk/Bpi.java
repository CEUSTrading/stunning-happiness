
package ceus.model.CoinDesk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "USD",
    "EUR"
})
public class Bpi {

    @JsonProperty("USD")
    private USD uSD;
    @JsonProperty("EUR")
    private EUR eUR;

    @JsonProperty("USD")
    public USD getUSD() {
        return uSD;
    }

    @JsonProperty("USD")
    public void setUSD(USD uSD) {
        this.uSD = uSD;
    }

    @JsonProperty("EUR")
    public EUR getEUR() {
        return eUR;
    }

    @JsonProperty("EUR")
    public void setEUR(EUR eUR) {
        this.eUR = eUR;
    }

}
