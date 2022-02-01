package be.tbriers.domainb;

import be.tbriers.domaina.DomainServiceA;

import java.util.Objects;

public class DomainB {

    /**
     *
     * can only be called by from domainA package do due to restricted construction of access object
     */
    public void update(DomainB domainB, DomainServiceA.DomainServiceAAccessToken domainServiceAAccessToken){
        if(Objects.isNull(domainServiceAAccessToken)){
            throw new IllegalCallerException("No access");
        };
        //do update
        System.out.println("update called");
    }
}
