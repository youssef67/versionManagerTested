public class VersionManager {
    private int version = 1;

    public void updateVersion(ETypeUpdate type) {
        this.version = version + switch(type) {
            case ETypeUpdate.PATCH -> Constantes.UPDATE_PATCH_VALUE;
            case ETypeUpdate.MINEUR -> Constantes.UPDATE_MINOR_VALUE;
            case ETypeUpdate.MAJEUR -> Constantes.UPDATE_MAJEUR_VALUE;
            default -> 0;
        };
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Version: " + this.version;
    }
}