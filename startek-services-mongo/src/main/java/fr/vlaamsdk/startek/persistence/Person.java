package fr.vlaamsdk.startek.persistence;

import java.util.UUID;

/**
 * @author ymartel (martel@codelutin.com)
 */
public class Person {

    public Person() {}

    public Person(String name, String fullname, String nickname) {
        this.identifier = UUID.randomUUID();
        this.name = name;
        this.fullname = fullname;
        this.nickname = nickname;
    }

    public Person(String name, String fullname) {
        this.identifier = UUID.randomUUID();
        this.name = name;
        this.fullname = fullname;
    }

    protected UUID identifier;
    protected String name;
    protected String fullname;
    protected String nickname;

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
