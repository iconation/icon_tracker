// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.controller;

import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.util.QRcodeUtil;
import com.dfg.icon.web.v0.dto.CommonRes;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "Dummy Data " })
@RequestMapping({ "dummy" })
@RestController
public class DummyController
{
    @Value("${server.url}")
    String serverUrl;
    @Value("${qrCode.path}")
    String qrcodePath;
    
    @ApiOperation("QRcode Test ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @PostMapping({ "/generateQrcode" })
    public CommonRes testQrCode(@Valid @RequestParam("address") final String address) throws Exception {
        final String url = QRcodeUtil.createQrCode(this.serverUrl, this.qrcodePath, address);
        final CommonRes res = new CommonRes();
        res.setData((Object)url);
        return res;
    }
    
    @ApiOperation("QRcode Test2 ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @PostMapping({ "/checkQrcode" })
    public CommonRes checkQrCode(@Valid @RequestParam("address") final String address) throws Exception {
        final String url = QRcodeUtil.checkQrCode(this.serverUrl, this.qrcodePath, address);
        final CommonRes res = new CommonRes();
        res.setData((Object)url);
        return res;
    }
    
    @ApiOperation(" loopChain \ud638\ucd9c   ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @PostMapping({ "/callLoopChain" })
    public String callLoopChain(@RequestBody final String Data) throws Exception {
        System.out.println(Data);
        final URL url = new URL("http://52.79.233.89:9000/api/v3");
        final HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        final OutputStream os = conn.getOutputStream();
        os.write(Data.getBytes("UTF-8"));
        os.close();
        final InputStream in = new BufferedInputStream(conn.getInputStream());
        final String result = IOUtils.toString(in, "UTF-8");
        final JSONObject jsonObject = new JSONObject(result);
        in.close();
        conn.disconnect();
        return jsonObject.toString();
    }
}
