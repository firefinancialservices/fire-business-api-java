package com.fire.sdk.model;

public class RelatedParty {
    private RelatedParty.Type type;
    private RelatedParty.Account account;
    private RelatedParty.User user;

    public RelatedParty.Type getType() {
        return type;
    }

    public void setType(RelatedParty.Type type) {
        this.type = type;
    }
    
    public RelatedParty.Account getAccount() {
		return account;
	}

	public void setAccount(RelatedParty.Account account) {
		this.account = account;
	}
	
	public RelatedParty.User getUser() {
		return user;
	}

	public void setUser(RelatedParty.User user) {
		this.user = user;
	}
	

	public enum Type {
		FIRE_ACCOUNT,
		EXTERNAL_ACCOUNT,
		WITHDRAWAL_ACCOUNT,
		USER
	}


	public class User {
		private String alias;
		private String mobilePhoneNumber;
		private String imageUrl;
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		public String getMobilePhoneNumber() {
			return mobilePhoneNumber;
		}
		public void setMobilePhoneNumber(String mobilePhoneNumber) {
			this.mobilePhoneNumber = mobilePhoneNumber;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		
		
	}

	public class Account {
    	private Long id;
    	private String alias;
    	private String iban;
    	private String bic;
    	private String nsc;
    	private String accountNumber;
    	
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		public String getIban() {
			return iban;
		}
		public void setIban(String iban) {
			this.iban = iban;
		}
		public String getBic() {
			return bic;
		}
		public void setBic(String bic) {
			this.bic = bic;
		}
		public String getNsc() {
			return nsc;
		}
		public void setNsc(String nsc) {
			this.nsc = nsc;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
    	
    	
    }
}
