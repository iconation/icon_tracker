// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service;

import com.dfg.icon.core.dao.icon.TAddressTotal;
import com.dfg.icon.web.v3.dto.CommonRes;
import com.dfg.icon.web.v3.dto.CommonListRes;
import com.dfg.icon.web.v3.dto.PageReq;

public interface V3AddressService
{
    CommonListRes getAddressList(final PageReq p0) throws Exception;
    
    CommonRes selectAddressInfo(final PageReq p0) throws Exception;
    
    CommonListRes getAddressTxList(final PageReq p0) throws Exception;
    
    CommonListRes getAddressTxListForWallet(final PageReq p0) throws Exception;
    
    CommonListRes selectAddressTokenTx(final PageReq p0) throws Exception;
    
    Integer getTotalTxCount(final PageReq p0) throws Exception;
    
    Integer getTotalTokenTxCount(final PageReq p0) throws Exception;
    
    TAddressTotal initGenesisTotal() throws Exception;
    
    TAddressTotal initTreasuryTotal() throws Exception;
}
