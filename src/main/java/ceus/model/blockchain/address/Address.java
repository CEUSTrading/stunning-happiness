
package ceus.model.blockchain.address;

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
    "hash160",
    "address",
    "n_tx",
    "total_received",
    "total_sent",
    "final_balance",
    "txs"
})
public class Address {

    @JsonProperty("hash160")
    private String hash160;
    @JsonProperty("address")
    private String address;
    @JsonProperty("n_tx")
    private Integer nTx;
    @JsonProperty("total_received")
    private Integer totalReceived;
    @JsonProperty("total_sent")
    private Integer totalSent;
    @JsonProperty("final_balance")
    private Integer finalBalance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hash160")
    public String getHash160() {
        return hash160;
    }

    @JsonProperty("hash160")
    public void setHash160(String hash160) {
        this.hash160 = hash160;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("n_tx")
    public Integer getNTx() {
        return nTx;
    }

    @JsonProperty("n_tx")
    public void setNTx(Integer nTx) {
        this.nTx = nTx;
    }

    @JsonProperty("total_received")
    public Integer getTotalReceived() {
        return totalReceived;
    }

    @JsonProperty("total_received")
    public void setTotalReceived(Integer totalReceived) {
        this.totalReceived = totalReceived;
    }

    @JsonProperty("total_sent")
    public Integer getTotalSent() {
        return totalSent;
    }

    @JsonProperty("total_sent")
    public void setTotalSent(Integer totalSent) {
        this.totalSent = totalSent;
    }

    @JsonProperty("final_balance")
    public Integer getFinalBalance() {
        return finalBalance;
    }

    @JsonProperty("final_balance")
    public void setFinalBalance(Integer finalBalance) {
        this.finalBalance = finalBalance;
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
