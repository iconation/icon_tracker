// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.service.impl;

import com.dfg.icon.core.dao.icon.TContract;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.web.v0.dto.SimpleRes;
import com.dfg.icon.web.v0.dto.SearchReq;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.SearchMapper;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v0.service.V0SearchService;

@Service
public class V0SearchServiceImpl implements V0SearchService
{
    @Autowired
    SearchMapper searchMapper;
    
    public SimpleRes search(final SearchReq req) throws Exception {
        final SimpleRes res = new SimpleRes();
        if (req.getData().contains("cx")) {
            final TContract tokenResult = this.searchMapper.isTokenCheck(req.getData());
            if (tokenResult == null) {
                res.setData((Object)"-");
                res.setCode(IconCode.NO_DATA);
            }
            else {
                res.setData((Object)tokenResult.getIrcVersion());
                res.setCode(IconCode.SUCCESS);
            }
        }
        else {
            final int hash = this.searchMapper.blockHashSearch(req.getData());
            if (hash == 1) {
                res.setCode(IconCode.SUCCESS);
                res.setData((Object)"Block Hash");
            }
            else {
                res.setCode(IconCode.SUCCESS);
                res.setData((Object)"Transaction Hash");
            }
        }
        return res;
    }
}
