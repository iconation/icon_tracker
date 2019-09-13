// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

public enum TxStateEnum
{
    public static final TxStateEnum Pending;
    public static final TxStateEnum Success;
    private int state;
    private String detail;
    
    public static TxStateEnum valueOf(final String name) {
        return Enum.valueOf(TxStateEnum.class, name);
    }
    
    private TxStateEnum(final int state, final String detail) {
        this.state = state;
        this.detail = detail;
    }
    
    public static String getDetailByState(final int value) {
        for (final TxStateEnum state : values()) {
            if (state.getState() == value) {
                return state.getDetail();
            }
        }
        return null;
    }
    
    public int getState() {
        return this.state;
    }
    
    public String getDetail() {
        return this.detail;
    }
    
    static {
        TxStateEnum.Pending = new TxStateEnum("Pending", 0, 0, "Fail");
        TxStateEnum.Success = new TxStateEnum("Success", 1, 1, "Success");
        TxStateEnum.$VALUES = new TxStateEnum[] { TxStateEnum.Pending, TxStateEnum.Success };
    }
}
