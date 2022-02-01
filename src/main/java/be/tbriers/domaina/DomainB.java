package be.tbriers.domaina;

import be.tbriers.domainb.DomainServiceA;

import java.util.Objects;

public class DomainB {

    /**
     *
     * can only be called by DomainServiceA due to private construction of access object
     */
    public void update(DomainB domainB, DomainServiceA.DomainServiceAAccessToken domainServiceAAccessToken){
        if(!Objects.nonNull(domainServiceAAccessToken)){
            throw new IllegalCallerException("No access");
        };
        //do update
        System.out.println("update called");
    }
}
