package be.tbriers.domaina;

import be.tbriers.domainb.DomainServiceATestConstants;
import org.junit.jupiter.api.Test;

class DomainBTest {

    @Test
    void update() {
        DomainB domainB = new DomainB();
        //does not compile
        //domainB.update(domainB, new DomainServiceA.DomainServiceAAccess());

        //in order to test we need to 'borrow' a access object from DomainServiceA
        domainB.update(domainB, DomainServiceATestConstants.DOMAIN_SERVICE_A_ACCESS_TOKEN);
    }

    @Test
    void update_withNull() {
        DomainB domainB = new DomainB();
        // exception when calling with null
        domainB.update(domainB, null);
    }
}