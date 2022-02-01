In most project that I have seen we tend to separate the domain in different functional packages.
This in order to not have too many classes in each package.

The caveat with this is that you could have a domain object that needs to have an update method but should only be called from a domainService in another package.
This can be required due to constraint checking that needs to span multiple domain objects.

With the functional separation you would need to make the update method public creating a hole in your constraint checking because once you have a reference to that domain object you can just call the update method.

Java does not really provide access restriction on that level.

One solution would obviously be that you put everything in the same package but that is not very clean.

In this proof of concept a AccessToken class is tested.

The AccessToken class is public and can be seen by everyone but the constructor has default access meaning that only the package it is declared in can make the object.

So in this crude example the update method from `DomainB` should only be called from `DomainServiceA`
Hence following method:
```
public void update(DomainB domainB, DomainServiceA.DomainServiceAAccessToken domainServiceAAccessToken){
    if(Objects.isNull(domainServiceAAccessToken)){
        throw new IllegalCallerException("No access");
    };
    //do update
}
```
We need a valid `DomainServiceAAccessToken`

This token can only be made from within package `domaina`:
```
public class DomainServiceA {
    public static final class DomainServiceAAccessToken {
        DomainServiceAAccessToken() {
        }
    }
}
```
So we restrict access to calls coming from `domaina` meaning you cannot just call the update method from anywhere you want.

If you make the constructor private you actually limit the calls from coming from `DomainServiceA` but this would limit the testability of the `DomainB.update` method because we do not have a way of creating the token.

With the default access constructor we can provide a test constant that is the token.
```
public class DomainServiceATestConstants {
    public static final DomainServiceA.DomainServiceAAccessToken DOMAIN_SERVICE_A_ACCESS_TOKEN = new DomainServiceA.DomainServiceAAccessToken();
}
```

So it is still a compromise but it does provide a finer level of access control.