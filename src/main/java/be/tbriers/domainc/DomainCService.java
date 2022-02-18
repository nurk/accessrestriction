package be.tbriers.domainc;

public class DomainCService {
    public static void main(String[] args) {
        new DomainCService().modifyC();
    }

    public void modifyC() {
        new DomainC(3).modifyCDefault(4);
        // hmmmm
        // new DomainC(4).exposedToDomainDService(new DomainDService()).modifyC(5);
    }
}
