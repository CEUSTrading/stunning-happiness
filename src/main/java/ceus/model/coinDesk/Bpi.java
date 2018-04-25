
package ceus.model.coinDesk;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)//Comentar si procede
@JsonPropertyOrder({
    "USD",
    "EUR", 
    "GBP"
})
public class Bpi {

    @JsonProperty("USD")
    private USD uSD;
    @JsonProperty("EUR")
    private EUR eUR;
    @JsonProperty("GBP")
    private GBP gBP;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("USD")
    public USD getUSD() {
        return uSD;
    }

    @JsonProperty("USD")
    public void setUSD(USD uSD) {
        this.uSD = uSD;
    }
    @JsonProperty("GBP")
    public GBP getGBP() {
        return gBP;
    }

    @JsonProperty("GBP")
    public void setUSD(GBP gBP) {
        this.gBP = gBP;
    }
    
    @JsonProperty("EUR")
    public EUR getEUR() {
        return eUR;
    }

    @JsonProperty("EUR")
    public void setEUR(EUR eUR) {
        this.eUR = eUR;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
