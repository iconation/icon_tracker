// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service.impl;

import java.io.FileWriter;
import java.io.InputStream;
import javax.servlet.ServletOutputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;
import java.io.FileInputStream;
import java.io.File;
import com.dfg.icon.core.v3.vo.TxCount;
import com.dfg.icon.core.dao.icon.TTransactionTotal;
import java.util.List;
import com.dfg.icon.util.Validator;
import javax.servlet.http.HttpServletResponse;
import com.dfg.icon.web.v3.dto.PageReq;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.TransactionV3Mapper;
import org.springframework.stereotype.Service;

@Service
public class V3DownloadServiceImpl
{
    @Autowired
    private TransactionV3Mapper transactionV3Mapper;
    
    public void downloadList(final PageReq req, final HttpServletResponse response) throws Exception {
        final List<TTransactionTotal> txList = this.transactionV3Mapper.selectTxListForDownload(req);
        if (!Validator.isValidMaxDownload(Integer.valueOf(txList.size()))) {
            this.createNullFile(response, "fail.txt");
            return;
        }
        this.createListFile(response, txList, new StringBuffer().append("txList_").append(req.getStartDate()).append("~").append(req.getEndDate()).append(".csv").toString());
    }
    
    public void downloadCount(final PageReq req, final HttpServletResponse response) throws Exception {
        final List<TxCount> countList = this.transactionV3Mapper.selectTxCountForDownload(req);
        if (!Validator.isValidMaxDownload(Integer.valueOf(countList.size()))) {
            this.createNullFile(response, "fail.txt");
            return;
        }
        final String addr = req.getType().equals("0") ? "fromAddr" : "toAddr";
        this.createCountFile(response, countList, new StringBuffer().append("countList_").append(req.getStartDate()).append("~").append(req.getEndDate()).append("_").append(addr).append(".csv").toString());
    }
    
    private void downloadFile(final HttpServletResponse response, final String menuName, final File file) {
        response.setHeader("Content-Disposition", "attachment;filename=" + menuName);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/CSV");
        try {
            final ServletOutputStream out = response.getOutputStream();
            final InputStream is = new FileInputStream(file);
            IOUtils.copy(is, (OutputStream)out);
            response.flushBuffer();
            is.close();
            out.close();
            file.delete();
        }
        catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void createListFile(final HttpServletResponse response, final List<TTransactionTotal> list, final String menuName) throws Exception {
        final File file = new File(menuName);
        final FileWriter fw = new FileWriter(file);
        final StringBuffer sb = new StringBuffer();
        sb.append("height,txHash,hash,createDate,fromAddr,toAddr,fee,amount,state\r\n");
        for (int i = 0; i < list.size(); ++i) {
            sb.append(list.get(i).getHeight()).append(",");
            sb.append(list.get(i).getTxHash()).append(",");
            sb.append(list.get(i).getHash()).append(",");
            sb.append(list.get(i).getCreateDate()).append(",");
            sb.append(list.get(i).getFromAddr()).append(",");
            sb.append(list.get(i).getToAddr()).append(",");
            sb.append(list.get(i).getFee()).append(",");
            sb.append(list.get(i).getAmount()).append(",");
            sb.append(list.get(i).getState()).append("\r\n");
        }
        fw.write(sb.toString());
        fw.flush();
        fw.close();
        this.downloadFile(response, menuName, file);
    }
    
    public void createCountFile(final HttpServletResponse response, final List<TxCount> list, final String menuName) throws Exception {
        final File file = new File(menuName);
        final FileWriter fw = new FileWriter(file);
        final StringBuffer sb = new StringBuffer();
        sb.append("address,count\r\n");
        for (int i = 0; i < list.size(); ++i) {
            sb.append(list.get(i).getAddress()).append(",");
            sb.append(list.get(i).getCnt()).append("\r\n");
        }
        fw.write(sb.toString());
        fw.flush();
        fw.close();
        this.downloadFile(response, menuName, file);
    }
    
    public void createNullFile(final HttpServletResponse response, final String menuName) throws Exception {
        final File file = new File(menuName);
        final FileWriter fw = new FileWriter(file);
        fw.write("File too large!! Plrease, decrease date\r\n");
        fw.flush();
        fw.close();
        this.downloadFile(response, menuName, file);
    }
}
