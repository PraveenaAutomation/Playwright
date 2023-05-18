package pages;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountEntries {

    CREATE_ACCOUNT("Create Account"),
    SIGN_IN("Sign In");

    private String displayName;
}
