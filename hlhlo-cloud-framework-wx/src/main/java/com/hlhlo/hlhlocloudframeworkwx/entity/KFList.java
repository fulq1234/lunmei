package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class KFList extends BaseResponse {
    private static final long serialVersionUID = -6956732376406422335L;

    @JsonProperty("kf_list")
    private List<KFAccountResponse> kfList;
}

