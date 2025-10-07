class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();

        userService.registerUsers(
                new String[]{"John", "Doe", "johndoe@gmail.com"},
                new String[]{"Matthew", "Lad", "alice.com"},
                new String[]{null, "Jude", "alicejude@gmail.com"},
                new String[]{"Seth", "", ""}
        );
    }
}