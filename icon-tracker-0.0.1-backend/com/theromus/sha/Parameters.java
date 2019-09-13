// 
// Decompiled by Procyon v0.5.36
// 

package com.theromus.sha;

public enum Parameters
{
    public static final Parameters KECCAK_224;
    public static final Parameters KECCAK_256;
    public static final Parameters KECCAK_384;
    public static final Parameters KECCAK_512;
    public static final Parameters SHA3_224;
    public static final Parameters SHA3_256;
    public static final Parameters SHA3_384;
    public static final Parameters SHA3_512;
    public static final Parameters SHAKE128;
    public static final Parameters SHAKE256;
    private final int r;
    private final int outputLength;
    private final String d;
    
    public static Parameters valueOf(final String name) {
        return Enum.valueOf(Parameters.class, name);
    }
    
    private Parameters(final int r, final int outputLength, final String d) {
        this.r = r;
        this.outputLength = outputLength;
        this.d = d;
    }
    
    public int getR() {
        return this.r;
    }
    
    public int getOutputLength() {
        return this.outputLength;
    }
    
    public String getD() {
        return this.d;
    }
    
    static {
        Parameters.KECCAK_224 = new Parameters("KECCAK_224", 0, 1152, 28, "01");
        Parameters.KECCAK_256 = new Parameters("KECCAK_256", 1, 1088, 32, "01");
        Parameters.KECCAK_384 = new Parameters("KECCAK_384", 2, 832, 48, "01");
        Parameters.KECCAK_512 = new Parameters("KECCAK_512", 3, 576, 64, "01");
        Parameters.SHA3_224 = new Parameters("SHA3_224", 4, 1152, 28, "06");
        Parameters.SHA3_256 = new Parameters("SHA3_256", 5, 1088, 32, "06");
        Parameters.SHA3_384 = new Parameters("SHA3_384", 6, 832, 48, "06");
        Parameters.SHA3_512 = new Parameters("SHA3_512", 7, 576, 64, "06");
        Parameters.SHAKE128 = new Parameters("SHAKE128", 8, 1344, 32, "1F");
        Parameters.SHAKE256 = new Parameters("SHAKE256", 9, 1088, 64, "1F");
        Parameters.$VALUES = new Parameters[] { Parameters.KECCAK_224, Parameters.KECCAK_256, Parameters.KECCAK_384, Parameters.KECCAK_512, Parameters.SHA3_224, Parameters.SHA3_256, Parameters.SHA3_384, Parameters.SHA3_512, Parameters.SHAKE128, Parameters.SHAKE256 };
    }
}
