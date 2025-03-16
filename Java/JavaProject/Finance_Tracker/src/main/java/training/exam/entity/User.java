package training.exam.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int userId;
    private String username;
    private String password;

    public boolean validateUser(){
        String regexUserName = "[a-zA-Z]+";
        String regexPassWord = "[a-zA-Z#$%@%^&*]{10}";
        if(username.matches(regexUserName)&& password.matches(regexPassWord)) {
            return true;
        }
        return false;
    }
}
