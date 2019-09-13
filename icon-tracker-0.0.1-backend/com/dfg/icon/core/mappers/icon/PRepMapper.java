// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import com.dfg.icon.web.v3.dto.PRepList;
import java.util.List;
import com.dfg.icon.web.v3.dto.PageReq;

public interface PRepMapper
{
    List<PRepList> selectPRepList(final PageReq p0);
    
    int selectPRepListCount(final PageReq p0);
}
