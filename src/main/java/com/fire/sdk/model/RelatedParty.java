package com.fire.sdk.model;

public class RelatedParty {
    private RelatedParty.Type type;
    private RelatedParty.Account account;
    private RelatedParty.User user;

    public RelatedParty.Type getType() {
        return type;
    }

    public RelatedParty setType(RelatedParty.Type type) {
        this.type = type;
        return this;
    }
    
    public RelatedParty.Account getAccount() {
		return account;
	}

	public RelatedParty setAccount(RelatedParty.Account account) {
		this.account = account;
        return this;
	}
	
	public RelatedParty.User getUser() {
		return user;
	}

	public RelatedParty setUser(RelatedParty.User user) {
		this.user = user;
        return this;
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
		public User setAlias(String alias) {
			this.alias = alias;
	        return this;
		}
		public String getMobilePhoneNumber() {
			return mobilePhoneNumber;
		}
		public User setMobilePhoneNumber(String mobilePhoneNumber) {
			this.mobilePhoneNumber = mobilePhoneNumber;
	        return this;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public User setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
	        return this;
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
		public Account setId(Long id) {
			this.id = id;
	        return this;
		}
		public String getAlias() {
			return alias;
		}
		public Account setAlias(String alias) {
			this.alias = alias;
	        return this;
		}
		public String getIban() {
			return iban;
		}
		public Account setIban(String iban) {
			this.iban = iban;
	        return this;
		}
		public String getBic() {
			return bic;
		}
		public Account setBic(String bic) {
			this.bic = bic;
	        return this;
		}
		public String getNsc() {
			return nsc;
		}
		public Account setNsc(String nsc) {
			this.nsc = nsc;
	        return this;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public Account setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
	        return this;
		}
    	
    	
    }
}
