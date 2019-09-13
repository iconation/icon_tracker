// 
// Decompiled by Procyon v0.5.36
// 

package com.theromus.sha;

import java.math.BigInteger;

public class Keccak
{
    public static final int DEFAULT_PERMUTATION_WIDTH = 1600;
    private static BigInteger BIT_64;
    private BigInteger[] RC;
    private int[][] r;
    private int w;
    private int n;
    
    public Keccak() {
        this.RC = new BigInteger[] { new BigInteger("0000000000000001", 16), new BigInteger("0000000000008082", 16), new BigInteger("800000000000808A", 16), new BigInteger("8000000080008000", 16), new BigInteger("000000000000808B", 16), new BigInteger("0000000080000001", 16), new BigInteger("8000000080008081", 16), new BigInteger("8000000000008009", 16), new BigInteger("000000000000008A", 16), new BigInteger("0000000000000088", 16), new BigInteger("0000000080008009", 16), new BigInteger("000000008000000A", 16), new BigInteger("000000008000808B", 16), new BigInteger("800000000000008B", 16), new BigInteger("8000000000008089", 16), new BigInteger("8000000000008003", 16), new BigInteger("8000000000008002", 16), new BigInteger("8000000000000080", 16), new BigInteger("000000000000800A", 16), new BigInteger("800000008000000A", 16), new BigInteger("8000000080008081", 16), new BigInteger("8000000000008080", 16), new BigInteger("0000000080000001", 16), new BigInteger("8000000080008008", 16) };
        this.r = new int[][] { { 0, 36, 3, 41, 18 }, { 1, 44, 10, 45, 2 }, { 62, 6, 43, 15, 61 }, { 28, 55, 25, 21, 56 }, { 27, 20, 39, 8, 14 } };
        this.initialize(1600);
    }
    
    public Keccak(final int b) {
        this.RC = new BigInteger[] { new BigInteger("0000000000000001", 16), new BigInteger("0000000000008082", 16), new BigInteger("800000000000808A", 16), new BigInteger("8000000080008000", 16), new BigInteger("000000000000808B", 16), new BigInteger("0000000080000001", 16), new BigInteger("8000000080008081", 16), new BigInteger("8000000000008009", 16), new BigInteger("000000000000008A", 16), new BigInteger("0000000000000088", 16), new BigInteger("0000000080008009", 16), new BigInteger("000000008000000A", 16), new BigInteger("000000008000808B", 16), new BigInteger("800000000000008B", 16), new BigInteger("8000000000008089", 16), new BigInteger("8000000000008003", 16), new BigInteger("8000000000008002", 16), new BigInteger("8000000000000080", 16), new BigInteger("000000000000800A", 16), new BigInteger("800000008000000A", 16), new BigInteger("8000000080008081", 16), new BigInteger("8000000000008080", 16), new BigInteger("0000000080000001", 16), new BigInteger("8000000080008008", 16) };
        this.r = new int[][] { { 0, 36, 3, 41, 18 }, { 1, 44, 10, 45, 2 }, { 62, 6, 43, 15, 61 }, { 28, 55, 25, 21, 56 }, { 27, 20, 39, 8, 14 } };
        this.initialize(b);
    }
    
    public String getHash(final String message, final Parameters parameters) {
        final BigInteger[][] S = new BigInteger[5][5];
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                S[i][j] = new BigInteger("0", 16);
            }
        }
        final BigInteger[][] padding;
        final BigInteger[][] P = padding = this.padding(message, parameters);
        for (final BigInteger[] Pi : padding) {
            for (int k = 0; k < 5; ++k) {
                for (int l = 0; l < 5; ++l) {
                    if (k + l * 5 < parameters.getR() / this.w) {
                        S[k][l] = S[k][l].xor(Pi[k + l * 5]);
                    }
                }
            }
            this.doKeccackf(S);
        }
        String Z = "";
        do {
            for (int m = 0; m < 5; ++m) {
                for (int j2 = 0; j2 < 5; ++j2) {
                    if (5 * m + j2 < parameters.getR() / this.w) {
                        Z += this.addZero(HexUtils.getReverseHex(S[j2][m].toByteArray()), 16).substring(0, 16);
                    }
                }
            }
            this.doKeccackf(S);
        } while (Z.length() < parameters.getOutputLength() * 2);
        return Z.substring(0, parameters.getOutputLength() * 2);
    }
    
    private BigInteger[][] doKeccackf(BigInteger[][] A) {
        for (int i = 0; i < this.n; ++i) {
            A = this.roundB(A, this.RC[i]);
        }
        return A;
    }
    
    private BigInteger[][] roundB(final BigInteger[][] A, final BigInteger RC) {
        final BigInteger[] C = new BigInteger[5];
        final BigInteger[] D = new BigInteger[5];
        final BigInteger[][] B = new BigInteger[5][5];
        for (int i = 0; i < 5; ++i) {
            C[i] = A[i][0].xor(A[i][1]).xor(A[i][2]).xor(A[i][3]).xor(A[i][4]);
        }
        for (int i = 0; i < 5; ++i) {
            D[i] = C[(i + 4) % 5].xor(this.rot(C[(i + 1) % 5], 1));
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                A[i][j] = A[i][j].xor(D[i]);
            }
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                B[j][(2 * i + 3 * j) % 5] = this.rot(A[i][j], this.r[i][j]);
            }
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                A[i][j] = B[i][j].xor(B[(i + 1) % 5][j].not().and(B[(i + 2) % 5][j]));
            }
        }
        A[0][0] = A[0][0].xor(RC);
        return A;
    }
    
    private BigInteger rot(final BigInteger x, int n) {
        n %= this.w;
        final BigInteger leftShift = this.getShiftLeft64(x, n);
        final BigInteger rightShift = x.shiftRight(this.w - n);
        return leftShift.or(rightShift);
    }
    
    private BigInteger getShiftLeft64(final BigInteger value, final int shift) {
        BigInteger retValue = value.shiftLeft(shift);
        BigInteger tmpValue = value.shiftLeft(shift);
        if (retValue.compareTo(Keccak.BIT_64) > 0) {
            for (int i = 64; i < 64 + shift; ++i) {
                tmpValue = tmpValue.clearBit(i);
            }
            tmpValue = tmpValue.setBit(64 + shift);
            retValue = tmpValue.and(retValue);
        }
        return retValue;
    }
    
    private BigInteger[][] padding(String message, final Parameters parameters) {
        for (message += parameters.getD(); message.length() / 2 * 8 % parameters.getR() != parameters.getR() - 8; message += "00") {}
        message += "80";
        final int size = message.length() / 2 * 8 / parameters.getR();
        final BigInteger[][] arrayM = new BigInteger[size][];
        this.initArray(arrayM[0] = new BigInteger[1600 / this.w]);
        int count = 0;
        int j = 0;
        int i = 0;
        for (int _n = 0; _n < message.length(); ++_n) {
            if (j > parameters.getR() / this.w - 1) {
                j = 0;
                ++i;
                this.initArray(arrayM[i] = new BigInteger[1600 / this.w]);
            }
            if (++count * 4 % this.w == 0) {
                final String subString = message.substring(count - this.w / 4, this.w / 4 + (count - this.w / 4));
                arrayM[i][j] = new BigInteger(subString, 16);
                String revertString = HexUtils.getReverseHex(arrayM[i][j].toByteArray());
                revertString = this.addZero(revertString, subString.length());
                arrayM[i][j] = new BigInteger(revertString, 16);
                ++j;
            }
        }
        return arrayM;
    }
    
    private String addZero(final String str, final int length) {
        String retStr = str;
        for (int i = 0; i < length - str.length(); ++i) {
            retStr += "0";
        }
        return retStr;
    }
    
    private void initArray(final BigInteger[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = new BigInteger("0", 16);
        }
    }
    
    private void initialize(final int b) {
        this.w = b / 25;
        final int l = (int)(Math.log(this.w) / Math.log(2.0));
        this.n = 12 + 2 * l;
    }
    
    static {
        Keccak.BIT_64 = new BigInteger("18446744073709551615");
    }
}
