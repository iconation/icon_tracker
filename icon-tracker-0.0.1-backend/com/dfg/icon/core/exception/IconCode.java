// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.exception;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;

public enum IconCode implements CustomErrorCode
{
    OK(HttpStatus.OK, "OK"), 
    NO_DATA("No Data", "No Data"), 
    SUCCESS("200", "success"), 
    ERROR("404", "ERROR"), 
    SESSION_EXPIRED(HttpStatus.INTERNAL_SERVER_ERROR, "Session Expired"), 
    INVALID_AUTHENTICATION(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid Authentication"), 
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "Invalid Password"), 
    PERMISSION_DENIED(HttpStatus.BAD_REQUEST, "Permission Denied"), 
    BLOCK_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Block Error"), 
    TRANSACTION_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Transaction Error"), 
    PREP_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Prep Request Errror"), 
    EXCHANGE_ACCESS_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Exchange Access Fail"), 
    IRC_NOIRC("-", "No IRC Format"), 
    IRC_TOKEN("IRC1", "Token IRC"), 
    IRC2_TOKEN("IRC2", "Token IRC"), 
    SCHEDULER_VER0("v0", "version0"), 
    SCHEDULER_VER1("v1", "version1"), 
    SCHEDULER_VER2("v2", "version2"), 
    SCHEDULER_VER3("v3", "version3"), 
    LIST_PAGE_TYPE10("10", "10"), 
    LIST_PAGE_TYPE20("20", "20"), 
    TXNVERSION_2("0x2", "ver2"), 
    TXNVERSION_3("0x3", "ver3"), 
    TXDATATYPE_DEPLOY("deploy", "deploy"), 
    TXDATATYPE_CALL("call", "call"), 
    TXDATATYPE_MESSAGE("message", "message"), 
    TX_METHOD_TYPE_TRANSFER("transfer", "transfer"), 
    TX_METHOD_TYPE_ACCEPTSCORE("acceptScore", "acceptScore"), 
    TX_METHOD_TYPE_REJECTSCORE("rejectScore", "rejectScore"), 
    TX_METHOD_TYPE_ADD_DEPLOYER("addDeployer", "addDeployer"), 
    SCORE_INSTALL_ADDR("cx0000000000000000000000000000000000000000", " Score Deploy addr"), 
    SCORE_CONTROL_ADDR("cx0000000000000000000000000000000000000001", " Score Control addr"), 
    TX_RESULT_SUCCESS("1", "success"), 
    TX_RESULT_FAILURE("0", "failure"), 
    SCORE_PENDING("0", "padding"), 
    SCORE_ACCEPT("1", "success"), 
    SCORE_REJECT("2", "reject"), 
    SCORE_ERROR("3", "error"), 
    SCORE_CANCELED("4", "canceled"), 
    WRONG_SCORE("WRONG SCORE", "WRONG SCORE"), 
    SCORE_METHOD_TRANSFER("Transfer(Address,Address,int,bytes)", "Transfer method "), 
    SCORE_METHOD_ICXSEND("ICXTransfer(Address,Address,int)", "icx send method  "), 
    SCORE_METHOD_ACCEPT("Accepted(str)", "score deploy accept method"), 
    SCORE_METHOD_REJECT("Rejected(str,str)", "score deploy reject method"), 
    TX_TYPE_ICX("0", "icx transfer"), 
    TX_TYPE_TOKEN("1", "token transfer"), 
    TX_TYPE_CALL("2", "score call"), 
    TX_TYPE_INSTALL("3", "score install"), 
    TX_TYPE_UPDATE("4", "score update"), 
    TX_TYPE_INSTALL_ACCEPT("5", "score accept"), 
    TX_TYPE_INSTALL_REJECT("6", "score reject"), 
    TX_TYPE_UPDATE_ACCEPT("7", "update accept"), 
    TX_TYPE_UPDATE_REJECT("8", "update reject"), 
    TX_TYPE_UPDATE_CANCELED("9", "update canceled"), 
    TOKEN_DEFAULT_DECIMALS("0x12", "defalut decimal"), 
    TOKEN_DEFAULT_SYMBOL("???", "unknwon symbol"), 
    pageKind_Pre("pre", "move pre page"), 
    pageKind_Next("next", "move next page"), 
    TX_RESULT_ERROR("tx_result_error", "[ {\"code\":\"0x7d00\" , \"value\":\"Out Of Balance\"} ,  {\"code\":\"0x0000\" , \"value\":\"Unknown ERROR\"} ]");
    
    private HttpStatus status;
    private String message;
    private String code;
    
    private IconCode(final HttpStatus status, final String message) {
        this.status = status;
        this.message = message;
    }
    
    private IconCode(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
    
    @Override
    public HttpStatus getStatus() {
        return this.status;
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }
    
    @Override
    public String getCode() {
        return this.code;
    }
    
    public static String getTxResultErrorCode(final String code) throws JSONException {
        final JSONArray ja = new JSONArray(IconCode.TX_RESULT_ERROR.getMessage());
        for (int i = 0; i < ja.length(); ++i) {
            final JSONObject jData = ja.getJSONObject(i);
            if (jData.getString("code").equals(code)) {
                return jData.getString("value");
            }
        }
        return null;
    }
}
