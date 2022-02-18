package be.tbriers.domaind;

import be.tbriers.domainc.DomainC;

// some experiments with https://stackoverflow.com/questions/14226228/implementation-of-friend-concept-in-java
public final class DomainDService {

    DomainDService() {

    }

    public static void main(String[] args) {
        DomainDService domainDService = new DomainDService();
        domainDService.tryToModifyC();
    }

    public void tryToModifyC() {
        new DomainC(4).exposedToDomainDService(this).modifyC(2);
        new DomainC(2).exposedToDomainDService(this).modifyCDefault(5);
    }
}
