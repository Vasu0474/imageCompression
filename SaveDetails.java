package fincare.videoKYC.model.saveDetails;

public class SaveDetails {
	
	private String referenceId;
	private boolean locationCheckFlag;
	private boolean custDetailsVerificationFlag;
	private boolean panDetailsCheckFlag;
	private boolean faceComparisionCheckFlag;
	private boolean signatureCheckFlag;
	
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public boolean isLocationCheckFlag() {
		return locationCheckFlag;
	}
	public void setLocationCheckFlag(boolean locationCheckFlag) {
		this.locationCheckFlag = locationCheckFlag;
	}
	public boolean isCustDetailsVerificationFlag() {
		return custDetailsVerificationFlag;
	}
	public void setCustDetailsVerificationFlag(boolean custDetailsVerificationFlag) {
		this.custDetailsVerificationFlag = custDetailsVerificationFlag;
	}
	public boolean isPanDetailsCheckFlag() {
		return panDetailsCheckFlag;
	}
	public void setPanDetailsCheckFlag(boolean panDetailsCheckFlag) {
		this.panDetailsCheckFlag = panDetailsCheckFlag;
	}
	public boolean isFaceComparisionCheckFlag() {
		return faceComparisionCheckFlag;
	}
	public void setFaceComparisionCheckFlag(boolean faceComparisionCheckFlag) {
		this.faceComparisionCheckFlag = faceComparisionCheckFlag;
	}
	public boolean isSignatureCheckFlag() {
		return signatureCheckFlag;
	}
	public void setSignatureCheckFlag(boolean signatureCheckFlag) {
		this.signatureCheckFlag = signatureCheckFlag;
	}
	

}
