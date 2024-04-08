package com.jojo.training;


import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
public enum ContractPayStatusEnum {

    PayFirst_1("已付首款","541239898728836421",new HashSet<>(Collections.singletonList("533298992562307589")),true),
    NeedCollectFirst_2("需追回首款","541240546031578437",new HashSet<>(Collections.singletonList("533298992562307589")),false),
    PayMedium_3("已付中款","541240644123766085",new HashSet<>(Collections.singletonList("533300678991282693")),true),
    NeedCollectMedium_4("需追回中款","541240751451811141",new HashSet<>(Collections.singletonList("533300678991282693")),false),
    PayLast_5("已付尾款","541240809605836101",new HashSet<>(Arrays.asList("533300716412862981","533300755482804741")),true),
    NeedCollectLast_6("需追回尾款","541240877020884293",new HashSet<>(Arrays.asList("533300716412862981","533300755482804741")),false);

    private final String propertyName;

    private final String propertyId;

    private final Set<String> bindNodes;

    private final boolean isPayChange;
    ContractPayStatusEnum(String propertyName, String property, Set<String> bindNodes, boolean isPayChange){
        this.propertyName = propertyName;
        this.propertyId = property;
        this.bindNodes = bindNodes;
        this.isPayChange = isPayChange;
    }

    public static String getEnumNameById(String id){
        for (ContractPayStatusEnum value : ContractPayStatusEnum.values()) {
            if(value.getPropertyId().equals(id)){
                return value.name();
            }
        }
        throw new IllegalArgumentException("根据节点id");
    }

    public static ContractPayStatusEnum getNextById(String id){
        return getNext(getEnumNameById(id));
    }

    public static ContractPayStatusEnum getByNodeId(String id){
        for (ContractPayStatusEnum value : ContractPayStatusEnum.values()) {
            if(value.getBindNodes().contains(id)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }

    public static ContractPayStatusEnum getNext(String valueName){
        ContractPayStatusEnum contractPayStatusEnum = ContractPayStatusEnum.valueOf(valueName);
        int ordinal = contractPayStatusEnum.ordinal();
        if(ordinal==ContractPayStatusEnum.values().length-2 || ordinal ==ContractPayStatusEnum.values().length-1){
            return contractPayStatusEnum;
        }
        else {
            for (ContractPayStatusEnum value : ContractPayStatusEnum.values()) {
                if(value.ordinal()==ordinal+2){
                    return contractPayStatusEnum;
                }
            }
        }
        throw new IllegalArgumentException();
    }

}