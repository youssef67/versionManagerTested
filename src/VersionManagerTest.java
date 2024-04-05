import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionManagerTest {

    private static VersionManager instance = null;

    @BeforeAll
    static void berforeAll() {
        instance = new VersionManager();
    }

    @BeforeEach
    void setUp() {
        instance.setVersion(1);
    }

    @Test
    @DisplayName("Test initialisation à 1")
    void  testUnit() {
        assertEquals(1, instance.getVersion());
    }

    @Test
    @DisplayName("Test retour de la version en chaine de caractère")
    void testToString() {
        assertEquals("Version: 1", instance.toString());
    }

    @Test
    @DisplayName("Test pour une update MAJOR")
    void testMajorUpdate() {
        instance.updateVersion(ETypeUpdate.MAJEUR);
        assertEquals("Version: 101", instance.toString());
    }

    @Test
    @DisplayName("Test pour une update MINOR")
    void testMinorUpdate() {
        instance.updateVersion(ETypeUpdate.MINEUR);
        assertEquals("Version: 11", instance.toString());
    }

    @Test
    @DisplayName("Test pour une update PATCH")
    void testPatchUpdate() {
        instance.updateVersion(ETypeUpdate.PATCH);
        assertEquals("Version: 2", instance.toString());
    }

    @Test
    @DisplayName("Test pour une update sans parametre")
    void testNoParameterUpdate() {
        instance.updateVersion(ETypeUpdate.TEST);
        assertEquals("Version: 1", instance.toString());
    }

    @Test
    @DisplayName("Test pour une version inferieur à 0")
    void testSetVersionNegativeNUmber() {
        instance.setVersion(-5);
        assertEquals("Version: -5", instance.toString());
    }

    @Test
    @DisplayName("Test pour une version inferieur à 0")
    void testSetVersionEqualZero() {
        instance.setVersion(0);
        assertEquals("Version: 0", instance.toString());
    }

    @Test
    @DisplayName("Test pour une version inferieur à 0")
    void testSetVersionPositiveNumber() {
        instance.setVersion(11);
        assertEquals("Version: 11", instance.toString());
    }

    @Test
    @DisplayName("Test un enchainement d'update avec PATCH MINOR MAJOR")
    void testSetVersionUpdateFromPatch() {
        instance.updateVersion(ETypeUpdate.PATCH);
        instance.updateVersion(ETypeUpdate.MINEUR);
        instance.updateVersion(ETypeUpdate.MAJEUR);

        assertEquals("Version: 112", instance.toString());
    }

    @Test
    @DisplayName("Test un enchainement d'update avec MAJOR MINOR PATCH")
    void testSetVersionUpdateFromMajor() {
        instance.updateVersion(ETypeUpdate.MAJEUR);
        instance.updateVersion(ETypeUpdate.MINEUR);
        instance.updateVersion(ETypeUpdate.PATCH);

        assertEquals("Version: 112", instance.toString());
    }

    @Test
    @DisplayName("Test un enchainement d'update appelé 3 fois")
    void testSetVersionUpdateThreeTimes() {
        instance.updateVersion(ETypeUpdate.MAJEUR);
        instance.updateVersion(ETypeUpdate.MAJEUR);
        instance.updateVersion(ETypeUpdate.MAJEUR);

        assertEquals("Version: 301", instance.toString());
    }

    @Test
    @DisplayName("Test un enchainement update, setVersion a 1 et update")
    void testSetVersionUpdateAndSetVersion() {
        instance.updateVersion(ETypeUpdate.MAJEUR);
        instance.setVersion(1);
        instance.updateVersion(ETypeUpdate.MAJEUR);

        assertEquals("Version: 101", instance.toString());
    }



}