// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

public class ContractDetail
{
    Integer state;
    String txHash;
    String verifiedTx;
    String verifier;
    String submitter;
    String checksum;
    String comment;
    
    public Integer getState() {
        return this.state;
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public String getVerifiedTx() {
        return this.verifiedTx;
    }
    
    public String getVerifier() {
        return this.verifier;
    }
    
    public String getSubmitter() {
        return this.submitter;
    }
    
    public String getChecksum() {
        return this.checksum;
    }
    
    public String getComment() {
        return this.comment;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setVerifiedTx(final String verifiedTx) {
        this.verifiedTx = verifiedTx;
    }
    
    public void setVerifier(final String verifier) {
        this.verifier = verifier;
    }
    
    public void setSubmitter(final String submitter) {
        this.submitter = submitter;
    }
    
    public void setChecksum(final String checksum) {
        this.checksum = checksum;
    }
    
    public void setComment(final String comment) {
        this.comment = comment;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ContractDetail)) {
            return false;
        }
        final ContractDetail other = (ContractDetail)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        Label_0065: {
            if (this$state == null) {
                if (other$state == null) {
                    break Label_0065;
                }
            }
            else if (this$state.equals(other$state)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$txHash = this.getTxHash();
        final Object other$txHash = other.getTxHash();
        Label_0102: {
            if (this$txHash == null) {
                if (other$txHash == null) {
                    break Label_0102;
                }
            }
            else if (this$txHash.equals(other$txHash)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$verifiedTx = this.getVerifiedTx();
        final Object other$verifiedTx = other.getVerifiedTx();
        Label_0139: {
            if (this$verifiedTx == null) {
                if (other$verifiedTx == null) {
                    break Label_0139;
                }
            }
            else if (this$verifiedTx.equals(other$verifiedTx)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$verifier = this.getVerifier();
        final Object other$verifier = other.getVerifier();
        Label_0176: {
            if (this$verifier == null) {
                if (other$verifier == null) {
                    break Label_0176;
                }
            }
            else if (this$verifier.equals(other$verifier)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$submitter = this.getSubmitter();
        final Object other$submitter = other.getSubmitter();
        Label_0213: {
            if (this$submitter == null) {
                if (other$submitter == null) {
                    break Label_0213;
                }
            }
            else if (this$submitter.equals(other$submitter)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$checksum = this.getChecksum();
        final Object other$checksum = other.getChecksum();
        Label_0250: {
            if (this$checksum == null) {
                if (other$checksum == null) {
                    break Label_0250;
                }
            }
            else if (this$checksum.equals(other$checksum)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$comment = this.getComment();
        final Object other$comment = other.getComment();
        if (this$comment == null) {
            if (other$comment == null) {
                return true;
            }
        }
        else if (this$comment.equals(other$comment)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ContractDetail;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $state = this.getState();
        result = result * 59 + (($state == null) ? 43 : $state.hashCode());
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $verifiedTx = this.getVerifiedTx();
        result = result * 59 + (($verifiedTx == null) ? 43 : $verifiedTx.hashCode());
        final Object $verifier = this.getVerifier();
        result = result * 59 + (($verifier == null) ? 43 : $verifier.hashCode());
        final Object $submitter = this.getSubmitter();
        result = result * 59 + (($submitter == null) ? 43 : $submitter.hashCode());
        final Object $checksum = this.getChecksum();
        result = result * 59 + (($checksum == null) ? 43 : $checksum.hashCode());
        final Object $comment = this.getComment();
        result = result * 59 + (($comment == null) ? 43 : $comment.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "ContractDetail(state=" + this.getState() + ", txHash=" + this.getTxHash() + ", verifiedTx=" + this.getVerifiedTx() + ", verifier=" + this.getVerifier() + ", submitter=" + this.getSubmitter() + ", checksum=" + this.getChecksum() + ", comment=" + this.getComment() + ")";
    }
}
