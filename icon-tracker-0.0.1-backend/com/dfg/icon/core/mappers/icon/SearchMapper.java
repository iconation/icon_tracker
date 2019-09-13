// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import com.dfg.icon.core.dao.icon.TContract;
import org.apache.ibatis.annotations.Param;

public interface SearchMapper
{
    int blockHashSearch(@Param("hash") final String p0);
    
    TContract isTokenCheck(@Param("address") final String p0);
    
    int blockHeightSearch(@Param("height") final String p0);
    
    int txHashSearch(@Param("txHash") final String p0);
}
