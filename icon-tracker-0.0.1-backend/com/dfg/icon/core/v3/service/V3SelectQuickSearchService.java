// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service;

import com.dfg.icon.web.v3.dto.SearchQuickInfo;
import java.util.List;
import java.util.TreeMap;

public interface V3SelectQuickSearchService
{
    public static final TreeMap<String, Integer> SEARCH_MAP = new TreeMap();
    public static final String CONNECT_WORD = "@#$";
    
    List<SearchQuickInfo> selectQuickSearch(final String p0) throws Exception;
    
    void selectSearchMapData() throws Exception;
}
