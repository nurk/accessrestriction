package be.tbriers.domainb;

import be.tbriers.domaina.DomainB;

public class DomainServiceA {
    public static final class DomainServiceAAccessToken {
        // can only be created in this package in order to be able to create a Test access token
        // in testConstants so we can actually do tests.
        DomainServiceAAccessToken() {
        }
    }

    public void doSomething() {
        DomainB domainB = new DomainB();
        domainB.update(domainB, new DomainServiceAAccessToken());
    }
}
