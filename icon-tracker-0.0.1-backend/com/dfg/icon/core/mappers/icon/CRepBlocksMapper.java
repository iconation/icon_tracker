// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import com.dfg.icon.web.v3.dto.RecentBlock;
import java.util.List;
import com.dfg.icon.web.v3.dto.CRepBlocksQueryRequest;

public interface CRepBlocksMapper
{
    List<RecentBlock> selectBlocksProducedByCRep(final CRepBlocksQueryRequest p0);
}
