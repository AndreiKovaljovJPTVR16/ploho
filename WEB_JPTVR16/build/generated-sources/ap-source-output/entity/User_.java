package entity;

import entity.Reader;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-23T23:18:12")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Reader> reader;
    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, String> login;

}