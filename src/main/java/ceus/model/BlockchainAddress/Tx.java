
package ceus.model.BlockchainAddress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ver",
    "inputs",
    "weight",
    "block_height",
    "relayed_by",
    "out",
    "lock_time",
    "result",
    "size",
    "time",
    "tx_index",
    "vin_sz",
    "hash",
    "vout_sz"
})
public class Tx {

    @JsonProperty("ver")
    private Integer ver;
    @JsonProperty("inputs")
    private List<Input> inputs = null;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("block_height")
    private Integer blockHeight;
    @JsonProperty("relayed_by")
    private String relayedBy;
    @JsonProperty("out")
    private List<Out> out = null;
    @JsonProperty("lock_time")
    private Integer lockTime;
    @JsonProperty("result")
    private Integer result;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("tx_index")
    private Integer txIndex;
    @JsonProperty("vin_sz")
    private Integer vinSz;
    @JsonProperty("hash")
    private String hash;
    @JsonProperty("vout_sz")
    private Integer voutSz;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ver")
    public Integer getVer() {
        return ver;
    }

    @JsonProperty("ver")
    public void setVer(Integer ver) {
        this.ver = ver;
    }

    @JsonProperty("inputs")
    public List<Input> getInputs() {
        return inputs;
    }

    @JsonProperty("inputs")
    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    }

    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonProperty("block_height")
    public Integer getBlockHeight() {
        return blockHeight;
    }

    @JsonProperty("block_height")
    public void setBlockHeight(Integer blockHeight) {
        this.blockHeight = blockHeight;
    }

    @JsonProperty("relayed_by")
    public String getRelayedBy() {
        return relayedBy;
    }

    @JsonProperty("relayed_by")
    public void setRelayedBy(String relayedBy) {
        this.relayedBy = relayedBy;
    }

    @JsonProperty("out")
    public List<Out> getOut() {
        return out;
    }

    @JsonProperty("out")
    public void setOut(List<Out> out) {
        this.out = out;
    }

    @JsonProperty("lock_time")
    public Integer getLockTime() {
        return lockTime;
    }

    @JsonProperty("lock_time")
    public void setLockTime(Integer lockTime) {
        this.lockTime = lockTime;
    }

    @JsonProperty("result")
    public Integer getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Integer result) {
        this.result = result;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    @JsonProperty("tx_index")
    public Integer getTxIndex() {
        return txIndex;
    }

    @JsonProperty("tx_index")
    public void setTxIndex(Integer txIndex) {
        this.txIndex = txIndex;
    }

    @JsonProperty("vin_sz")
    public Integer getVinSz() {
        return vinSz;
    }

    @JsonProperty("vin_sz")
    public void setVinSz(Integer vinSz) {
        this.vinSz = vinSz;
    }

    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    @JsonProperty("vout_sz")
    public Integer getVoutSz() {
        return voutSz;
    }

    @JsonProperty("vout_sz")
    public void setVoutSz(Integer voutSz) {
        this.voutSz = voutSz;
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
