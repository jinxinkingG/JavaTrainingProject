package com.jojo.training;


public enum ContractPayStatusEnum {

    PayFirst("已付首款","541239898728836421",true),
    NeedCollectFirst("需追回首款","541240546031578437",false),
    PayMedium("已付中款","541240644123766085",true),
    NeedCollectMedium("需追回中款","541240751451811141",false),
    PayLast("已付尾款","541240809605836101",true),
    NeedCollectLast("需追回尾款","541240877020884293",false);

    private final String propertyName;

    private final String propertyId;

    private final boolean isPayChange;
    ContractPayStatusEnum(String propertyName, String property, boolean isPayChange){
        this.propertyName = propertyName;
        this.propertyId = property;
        this.isPayChange = isPayChange;
    }

    public ContractPayStatusEnum getNext(){
        for (ContractPayStatusEnum value : ContractPayStatusEnum.values()) {
            value.
        }

    }

}
