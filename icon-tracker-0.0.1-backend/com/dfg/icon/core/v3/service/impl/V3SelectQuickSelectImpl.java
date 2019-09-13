// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service.impl;

import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Comparator;
import java.util.Arrays;
import java.util.HashMap;
import com.dfg.icon.core.exception.IconCode;
import java.util.ArrayList;
import com.dfg.icon.web.v3.dto.SearchQuickInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.quickSearchMapper;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v3.service.V3SelectQuickSearchService;

@Service
public class V3SelectQuickSelectImpl implements V3SelectQuickSearchService
{
    @Autowired
    quickSearchMapper quickSearchMapper;
    
    public List<SearchQuickInfo> selectQuickSearch(final String targetWord) throws Exception {
        final long start = System.currentTimeMillis();
        final Object[] keyArray = V3SelectQuickSelectImpl.SEARCH_MAP.keySet().toArray();
        int[] checkRange = { 0, keyArray.length };
        for (int i = 0; i < 4; ++i) {
            checkRange = checkIndex(targetWord, checkRange, keyArray);
        }
        int startIndex = checkRange[0];
        boolean searchCheck = false;
        for (int j = startIndex; j <= checkRange[1]; ++j) {
            if (keyArray[j].toString().startsWith(targetWord)) {
                startIndex = j;
                searchCheck = true;
                break;
            }
        }
        final List<SearchQuickInfo> returnList = new ArrayList<SearchQuickInfo>();
        if (!searchCheck) {
            final String[] noData = { IconCode.NO_DATA.getCode(), "", "" };
            returnList.add(new SearchQuickInfo(noData));
            return returnList;
        }
        final HashMap dataMap = new HashMap();
        for (int k = startIndex; k < keyArray.length && keyArray[k].toString().startsWith(targetWord); ++k) {
            final String dbKey = keyArray[k].toString();
            dataMap.put(dbKey, V3SelectQuickSelectImpl.SEARCH_MAP.get(dbKey));
        }
        final Object[] returnData = dataMap.entrySet().toArray();
        Arrays.sort(returnData, (Comparator<? super Object>)new V3SelectQuickSelectImpl$1(this));
        for (final Object returnDataValue : returnData) {
            final String key = ((Map.Entry)returnDataValue).getKey();
            final StringTokenizer values = new StringTokenizer(key, "@#$");
            final String[] keys = new String[3];
            int l = 0;
            while (values.hasMoreTokens()) {
                keys[l++] = values.nextToken();
            }
            returnList.add(new SearchQuickInfo(keys));
        }
        return returnList;
    }
    
    public static int[] checkIndex(final String targetWord, final int[] checkRange, final Object[] keyArray) {
        final int startIndex = checkRange[0];
        final int endIndex = checkRange[1];
        final int checkIndex = (endIndex - startIndex) / 2 + startIndex;
        final int result = targetWord.compareTo(keyArray[checkIndex].toString());
        if (result > 0) {
            checkRange[0] = checkIndex;
            checkRange[1] = endIndex;
        }
        else {
            checkRange[0] = startIndex;
            checkRange[1] = checkIndex;
        }
        return checkRange;
    }
    
    public void selectSearchMapData() throws Exception {
        final List<SearchQuickInfo> searchDataList = this.quickSearchMapper.selectQuickSearch();
        for (final SearchQuickInfo searchData : searchDataList) {
            String key = searchData.getName() + "@#$" + searchData.getAddress() + "@#$" + searchData.getIrcVersion();
            key = key.toLowerCase();
            V3SelectQuickSelectImpl.SEARCH_MAP.put(key, searchData.getTxCount().intValue());
        }
    }
}
