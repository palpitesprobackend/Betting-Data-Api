package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Comparison{
    private Form form;
    private Att att;
    private Def def;
    private PoissonDistribution poisson_distribution;
    private H2h h2h;
    private Goals goals;
    private Total total;
}
