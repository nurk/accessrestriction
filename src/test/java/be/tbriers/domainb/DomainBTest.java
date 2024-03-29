package be.tbriers.domainb;

import be.tbriers.domaina.DomainServiceATestConstants;
import org.junit.jupiter.api.Test;

class DomainBTest {

    @Test
    void update() {
        DomainB domainB = new DomainB();
        //does not compile due to no access to the constructor of the token
        //domainB.update(domainB, new DomainServiceA.DomainServiceAAccess());

        //in order to test we need to 'borrow' an access object from DomainServiceA so we use testConstants
        domainB.update(domainB, DomainServiceATestConstants.DOMAIN_SERVICE_A_ACCESS_TOKEN);
    }

    @Test
    void update_withNull() {
        DomainB domainB = new DomainB();
        // exception when calling with null
        domainB.update(domainB, null);
    }
}