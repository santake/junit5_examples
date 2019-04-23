package jp.takeshi;

/**
 * Class for test target
 * @author santake
 *
 */
public class Person {
    
    private String id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;

    public String getId() {
	return id;
    }
    public void setId(String id) {
	this.id = id;
    }
    public String getFirstName() {
	return firstName;
    }
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getLastName() {
	return lastName;
    }
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }
    public String getEmail() {
	return email;
    }
    public void setEmail(String email) {
	this.email = email;
    }
    public void clear() {
	this.id = "";
	this.firstName = "";
	this.lastName = "";
	this.email = "";
    }
    public void throwingRuntimeException() {
	throw new IllegalArgumentException("error");
    }
    public void throwingException() throws Exception {
	throw new Exception("error");
    }
}