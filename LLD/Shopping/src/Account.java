// make it builder design pattern
class Account {
    private String username;
    private String password;
    private String name;
    private String address;
    private String email;
    private String phoneNUmber;

    private Account(AccountBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.name = builder.name;
        this.address = builder.address;
        this.email = builder.email;
        this.phoneNUmber = builder.phoneNUmber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNUmber(String phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class AccountBuilder {
        //required
        private String username;
        private String password;
        private String name;

        //optional
        private String address;
        private String email;
        private String phoneNUmber;

        public AccountBuilder(String username, String password, String name) {
            this.username = username;
            this.password = password;
            this.name = name;
        }

        public AccountBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public AccountBuilder setEmail(String address) {
            this.address = address;
            return this;
        }

        public AccountBuilder setPhoneNumber(String address) {
            this.address = address;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
