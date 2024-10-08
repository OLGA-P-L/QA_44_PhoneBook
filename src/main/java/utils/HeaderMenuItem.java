package utils;

public enum HeaderMenuItem {
    HOME("//a[@href='/home']"),

    ABOUT("//a[@href='/about']"),

    LOGIN("//a[@href='/login']"),

    CONTACTS("//a[@href='/login']"),

    ADD ("//a[@href='/add']"),

    SIGNOUT ("//button[text()='Sign out']"),

    SAVE ("//button/b");


    private final String locator;


    HeaderMenuItem(String locator){
        this.locator = locator;
    }

    public String getLocator(){
        return locator;
    }
}
