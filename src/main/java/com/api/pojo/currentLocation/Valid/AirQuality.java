package com.api.pojo.currentLocation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirQuality {

    public String co;
    public String no2;
    public String o3;
    public String so2;
    public String pm2_5;
    public String pm10;

    @JsonProperty("us-epa-index")
    public String usEpaIndex;

    @JsonProperty("gb-defra-index")
    public String gbDefraIndex;

    // Optional: getters and setters
    public String getCo() { return co; }
    public void setCo(String co) { this.co = co; }

    public String getNo2() { return no2; }
    public void setNo2(String no2) { this.no2 = no2; }

    public String getO3() { return o3; }
    public void setO3(String o3) { this.o3 = o3; }

    public String getSo2() { return so2; }
    public void setSo2(String so2) { this.so2 = so2; }

    public String getPm2_5() { return pm2_5; }
    public void setPm2_5(String pm2_5) { this.pm2_5 = pm2_5; }

    public String getPm10() { return pm10; }
    public void setPm10(String pm10) { this.pm10 = pm10; }

    public String getUsEpaIndex() { return usEpaIndex; }
    public void setUsEpaIndex(String usEpaIndex) { this.usEpaIndex = usEpaIndex; }

    public String getGbDefraIndex() { return gbDefraIndex; }
    public void setGbDefraIndex(String gbDefraIndex) { this.gbDefraIndex = gbDefraIndex; }

}
