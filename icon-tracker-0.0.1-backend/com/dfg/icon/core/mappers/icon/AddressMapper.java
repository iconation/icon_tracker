// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import com.dfg.icon.core.dao.icon.TAddressPrep;
import com.dfg.icon.core.dao.icon.TAddressTotal;
import com.dfg.icon.core.dao.icon.TTokenAddress;
import com.dfg.icon.web.v3.dto.AddressInfo;
import com.dfg.icon.web.v0.dto.WalletInfoDto;
import com.dfg.icon.core.v3.vo.IcxSupplyVo;
import com.dfg.icon.web.v3.dto.AddressDto;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.web.v0.dto.block.Address;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper
{
    List<Address> selectAddrList(@Param("page") final int p0);
    
    List<AddressDto> selectAddrListV3(final PageReq p0);
    
    Integer selectCountAddrlist();
    
    List<IcxSupplyVo> sumIcxCirculationy();
    
    WalletInfoDto selectWalletInfo(@Param("address") final String p0);
    
    AddressInfo selectAddressInfo(final PageReq p0);
    
    Integer deleteAddressByBalanceLessThan(@Param("balance") final String p0);
    
    Integer countByCrep();
    
    Integer selectxCountAddrTx(@Param("address") final String p0);
    
    int upsertTxCountByTransactionRange(@Param("height1") final Integer p0, @Param("height2") final Integer p1);
    
    int upsertTokenTxCountByTokenTransactionRange(@Param("height1") final Integer p0, @Param("height2") final Integer p1);
    
    int upsertPRepBlockCountByBlockRange(@Param("height1") final Integer p0, @Param("height2") final Integer p1);
    
    int updateAddressTotalByTransaction(@Param("hash") final String p0);
    
    int updateAddressByTotal();
    
    int initUpdateAddressTotal();
    
    int upsertTokenAddressArray(final List<TTokenAddress> p0);
    
    int upsertAddressArray(final List<TAddressTotal> p0);
    
    int upsertPrepTerm(final List<TAddressPrep> p0);
    
    List<String> selectCurrentPrep();
    
    String selectSumIcx();
}
