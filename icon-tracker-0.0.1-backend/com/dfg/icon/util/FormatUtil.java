// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.util;

import java.util.Iterator;
import com.dfg.icon.web.v3.dto.RecentBlock;
import com.dfg.icon.web.v3.dto.TxDetailDto;
import com.dfg.icon.web.v3.dto.TxDetail;
import com.dfg.icon.web.v0.dto.block.Transaction;
import java.util.List;

public class FormatUtil
{
    public static List<Transaction> txFormat(final List<Transaction> list) {
        for (int i = 0; i < list.size(); ++i) {
            final double getAmount = Double.parseDouble(list.get(i).getAmount());
            final String amount = String.format("%.4f", getAmount);
            list.get(i).setAmount(amount);
        }
        return list;
    }
    
    public static List<TxDetail> txDetailFormat(final List<TxDetail> list) {
        for (int i = 0; i < list.size(); ++i) {
            final double getAmount = Double.parseDouble(list.get(i).getAmount());
            final String amount = String.format("%.4f", getAmount);
            list.get(i).setAmount(amount);
        }
        return list;
    }
    
    public static List<TxDetailDto> txDetailV3Format(final List<TxDetailDto> list) {
        for (int i = 0; i < list.size(); ++i) {
            final double getAmount = Double.parseDouble(list.get(i).getAmount());
            final String amount = String.format("%.4f", getAmount);
            list.get(i).setAmount(amount);
        }
        return list;
    }
    
    public static List<RecentBlock> blockFormat(final List<RecentBlock> list) {
        for (final RecentBlock rb : list) {
            if (rb.getAmount() != null && !"".equals(rb.getAmount())) {
                final double getAmount = Double.parseDouble(rb.getAmount());
                rb.setAmount(String.format("%.4f", getAmount));
            }
            else {
                rb.setAmount("-");
            }
        }
        return list;
    }
}
