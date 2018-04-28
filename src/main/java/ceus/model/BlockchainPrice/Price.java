
package ceus.model.BlockchainPrice;

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
    "USD",
    "AUD",
    "BRL",
    "CAD",
    "CHF",
    "CLP",
    "CNY",
    "DKK",
    "EUR",
    "GBP",
    "HKD",
    "INR",
    "ISK",
    "JPY",
    "KRW",
    "NZD",
    "PLN",
    "RUB",
    "SEK",
    "SGD",
    "THB",
    "TWD"
})
public class Price {

    @JsonProperty("USD")
    private USD uSD;
    @JsonProperty("AUD")
    private AUD aUD;
    @JsonProperty("BRL")
    private BRL bRL;
    @JsonProperty("CAD")
    private CAD cAD;
    @JsonProperty("CHF")
    private CHF cHF;
    @JsonProperty("CLP")
    private CLP cLP;
    @JsonProperty("CNY")
    private CNY cNY;
    @JsonProperty("DKK")
    private DKK dKK;
    @JsonProperty("EUR")
    private EUR eUR;
    @JsonProperty("GBP")
    private GBP gBP;
    @JsonProperty("HKD")
    private HKD hKD;
    @JsonProperty("INR")
    private INR iNR;
    @JsonProperty("ISK")
    private ISK iSK;
    @JsonProperty("JPY")
    private JPY jPY;
    @JsonProperty("KRW")
    private KRW kRW;
    @JsonProperty("NZD")
    private NZD nZD;
    @JsonProperty("PLN")
    private PLN pLN;
    @JsonProperty("RUB")
    private RUB rUB;
    @JsonProperty("SEK")
    private SEK sEK;
    @JsonProperty("SGD")
    private SGD sGD;
    @JsonProperty("THB")
    private THB tHB;
    @JsonProperty("TWD")
    private TWD tWD;
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

    @JsonProperty("AUD")
    public AUD getAUD() {
        return aUD;
    }

    @JsonProperty("AUD")
    public void setAUD(AUD aUD) {
        this.aUD = aUD;
    }

    @JsonProperty("BRL")
    public BRL getBRL() {
        return bRL;
    }

    @JsonProperty("BRL")
    public void setBRL(BRL bRL) {
        this.bRL = bRL;
    }

    @JsonProperty("CAD")
    public CAD getCAD() {
        return cAD;
    }

    @JsonProperty("CAD")
    public void setCAD(CAD cAD) {
        this.cAD = cAD;
    }

    @JsonProperty("CHF")
    public CHF getCHF() {
        return cHF;
    }

    @JsonProperty("CHF")
    public void setCHF(CHF cHF) {
        this.cHF = cHF;
    }

    @JsonProperty("CLP")
    public CLP getCLP() {
        return cLP;
    }

    @JsonProperty("CLP")
    public void setCLP(CLP cLP) {
        this.cLP = cLP;
    }

    @JsonProperty("CNY")
    public CNY getCNY() {
        return cNY;
    }

    @JsonProperty("CNY")
    public void setCNY(CNY cNY) {
        this.cNY = cNY;
    }

    @JsonProperty("DKK")
    public DKK getDKK() {
        return dKK;
    }

    @JsonProperty("DKK")
    public void setDKK(DKK dKK) {
        this.dKK = dKK;
    }

    @JsonProperty("EUR")
    public EUR getEUR() {
        return eUR;
    }

    @JsonProperty("EUR")
    public void setEUR(EUR eUR) {
        this.eUR = eUR;
    }

    @JsonProperty("GBP")
    public GBP getGBP() {
        return gBP;
    }

    @JsonProperty("GBP")
    public void setGBP(GBP gBP) {
        this.gBP = gBP;
    }

    @JsonProperty("HKD")
    public HKD getHKD() {
        return hKD;
    }

    @JsonProperty("HKD")
    public void setHKD(HKD hKD) {
        this.hKD = hKD;
    }

    @JsonProperty("INR")
    public INR getINR() {
        return iNR;
    }

    @JsonProperty("INR")
    public void setINR(INR iNR) {
        this.iNR = iNR;
    }

    @JsonProperty("ISK")
    public ISK getISK() {
        return iSK;
    }

    @JsonProperty("ISK")
    public void setISK(ISK iSK) {
        this.iSK = iSK;
    }

    @JsonProperty("JPY")
    public JPY getJPY() {
        return jPY;
    }

    @JsonProperty("JPY")
    public void setJPY(JPY jPY) {
        this.jPY = jPY;
    }

    @JsonProperty("KRW")
    public KRW getKRW() {
        return kRW;
    }

    @JsonProperty("KRW")
    public void setKRW(KRW kRW) {
        this.kRW = kRW;
    }

    @JsonProperty("NZD")
    public NZD getNZD() {
        return nZD;
    }

    @JsonProperty("NZD")
    public void setNZD(NZD nZD) {
        this.nZD = nZD;
    }

    @JsonProperty("PLN")
    public PLN getPLN() {
        return pLN;
    }

    @JsonProperty("PLN")
    public void setPLN(PLN pLN) {
        this.pLN = pLN;
    }

    @JsonProperty("RUB")
    public RUB getRUB() {
        return rUB;
    }

    @JsonProperty("RUB")
    public void setRUB(RUB rUB) {
        this.rUB = rUB;
    }

    @JsonProperty("SEK")
    public SEK getSEK() {
        return sEK;
    }

    @JsonProperty("SEK")
    public void setSEK(SEK sEK) {
        this.sEK = sEK;
    }

    @JsonProperty("SGD")
    public SGD getSGD() {
        return sGD;
    }

    @JsonProperty("SGD")
    public void setSGD(SGD sGD) {
        this.sGD = sGD;
    }

    @JsonProperty("THB")
    public THB getTHB() {
        return tHB;
    }

    @JsonProperty("THB")
    public void setTHB(THB tHB) {
        this.tHB = tHB;
    }

    @JsonProperty("TWD")
    public TWD getTWD() {
        return tWD;
    }

    @JsonProperty("TWD")
    public void setTWD(TWD tWD) {
        this.tWD = tWD;
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
