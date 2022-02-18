package be.tbriers.domainc;

import be.tbriers.domaind.DomainDService;

import java.util.Objects;

public class DomainC {

    private int c;

    public DomainC(int c) {
        this.c = c;
    }

    private void modifyC(int other) {
        System.out.println("ModifyC called " + c + " " + other);
        this.c = other;
    }

    void modifyCDefault(int other) {
        System.out.println("ModifyCDefault called " + c + " " + other);
        this.c = other;
    }

    public class ExposedToDomainB {
        public void modifyC(int other) {
            DomainC.this.modifyC(other);
        }

        public void modifyCDefault(int other) {
            DomainC.this.modifyCDefault(other);
        }
    }

    public ExposedToDomainB exposedToDomainDService(DomainDService d) {
        if (Objects.isNull(d)) {
            throw new IllegalCallerException("No access");
        }
        return new ExposedToDomainB();
    }
}
