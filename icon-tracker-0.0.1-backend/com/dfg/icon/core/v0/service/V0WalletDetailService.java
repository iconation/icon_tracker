// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.service;

import com.dfg.icon.web.v3.dto.TxDetail;
import java.util.List;
import com.dfg.icon.web.v0.dto.WalletInfoDto;
import com.dfg.icon.web.v0.dto.WalletTxReq;
import com.dfg.icon.web.v0.dto.CommonRes;
import com.dfg.icon.web.v3.dto.PageReq;

public interface V0WalletDetailService
{
    CommonRes selectAddrList(final PageReq p0) throws Exception;
    
    WalletInfoDto selectWalletDetail(final WalletTxReq p0) throws Exception;
    
    List<TxDetail> selectWalletTx(final WalletTxReq p0) throws Exception;
}
