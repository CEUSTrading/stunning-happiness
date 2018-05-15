
package ceus.model.blockchain.price;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "15m",
    "last",
    "buy",
    "sell",
    "symbol"
})
public class USD {

    @JsonProperty("15m")
    private Double _15m;
    @JsonProperty("last")
    private Double last;
    @JsonProperty("buy")
    private Double buy;
    @JsonProperty("sell")
    private Double sell;
    @JsonProperty("symbol")
    private String symbol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("15m")
    public Double get15m() {
        return _15m;
    }

    @JsonProperty("15m")
    public void set15m(Double _15m) {
        this._15m = _15m;
    }

    @JsonProperty("last")
    public Double getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(Double last) {
        this.last = last;
    }

    @JsonProperty("buy")
    public Double getBuy() {
        return buy;
    }

    @JsonProperty("buy")
    public void setBuy(Double buy) {
        this.buy = buy;
    }

    @JsonProperty("sell")
    public Double getSell() {
        return sell;
    }

    @JsonProperty("sell")
    public void setSell(Double sell) {
        this.sell = sell;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
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
