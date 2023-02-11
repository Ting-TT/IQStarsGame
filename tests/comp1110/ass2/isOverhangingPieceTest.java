package comp1110.ass2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class isOverhangingPieceTest {

    @Test
    public void redOverhanging() {
        // Ensures all overhanging red positions return true
        // RED - ORIENTATION 0
        assertTrue(IQStars.isOverhangingPos("r060"));
        assertTrue(IQStars.isOverhangingPos("r052"));
        assertTrue(IQStars.isOverhangingPos("r050"));
        assertTrue(IQStars.isOverhangingPos("r051"));
        assertTrue(IQStars.isOverhangingPos("r003"));
        assertTrue(IQStars.isOverhangingPos("r013"));
        assertTrue(IQStars.isOverhangingPos("r023"));
        assertTrue(IQStars.isOverhangingPos("r033"));
        assertTrue(IQStars.isOverhangingPos("r043"));
        assertTrue(IQStars.isOverhangingPos("r053"));

        // RED - ORIENTATION 1
        assertTrue(IQStars.isOverhangingPos("r100"));
        assertTrue(IQStars.isOverhangingPos("r160"));
        assertTrue(IQStars.isOverhangingPos("r102"));
        assertTrue(IQStars.isOverhangingPos("r112"));
        assertTrue(IQStars.isOverhangingPos("r122"));
        assertTrue(IQStars.isOverhangingPos("r132"));
        assertTrue(IQStars.isOverhangingPos("r142"));
        assertTrue(IQStars.isOverhangingPos("r152"));
        assertTrue(IQStars.isOverhangingPos("r162"));
        assertTrue(IQStars.isOverhangingPos("r103"));
        assertTrue(IQStars.isOverhangingPos("r113"));
        assertTrue(IQStars.isOverhangingPos("r123"));
        assertTrue(IQStars.isOverhangingPos("r133"));
        assertTrue(IQStars.isOverhangingPos("r143"));
        assertTrue(IQStars.isOverhangingPos("r153"));

        // RED - ORIENTATION 2
        assertTrue(IQStars.isOverhangingPos("r200"));
        assertTrue(IQStars.isOverhangingPos("r260"));
        assertTrue(IQStars.isOverhangingPos("r251"));
        assertTrue(IQStars.isOverhangingPos("r202"));
        assertTrue(IQStars.isOverhangingPos("r262"));
        assertTrue(IQStars.isOverhangingPos("r203"));
        assertTrue(IQStars.isOverhangingPos("r213"));
        assertTrue(IQStars.isOverhangingPos("r223"));
        assertTrue(IQStars.isOverhangingPos("r233"));
        assertTrue(IQStars.isOverhangingPos("r243"));
        assertTrue(IQStars.isOverhangingPos("r253"));
    }

    @Test
    public void orangeOverhanging() {
        // Ensures all overhanging orange positions return true
        // ORANGE - POSITION 0
        assertTrue(IQStars.isOverhangingPos("o050"));
        assertTrue(IQStars.isOverhangingPos("o060"));
        assertTrue(IQStars.isOverhangingPos("o051"));
        assertTrue(IQStars.isOverhangingPos("o052"));
        assertTrue(IQStars.isOverhangingPos("o062"));
        assertTrue(IQStars.isOverhangingPos("o003"));
        assertTrue(IQStars.isOverhangingPos("o013"));
        assertTrue(IQStars.isOverhangingPos("o023"));
        assertTrue(IQStars.isOverhangingPos("o033"));
        assertTrue(IQStars.isOverhangingPos("o043"));
        assertTrue(IQStars.isOverhangingPos("o053"));

        //ORANGE - POSITION 1
        assertTrue(IQStars.isOverhangingPos("o160"));
        assertTrue(IQStars.isOverhangingPos("o102"));
        assertTrue(IQStars.isOverhangingPos("o112"));
        assertTrue(IQStars.isOverhangingPos("o122"));
        assertTrue(IQStars.isOverhangingPos("o132"));
        assertTrue(IQStars.isOverhangingPos("o142"));
        assertTrue(IQStars.isOverhangingPos("o152"));
        assertTrue(IQStars.isOverhangingPos("o162"));
        assertTrue(IQStars.isOverhangingPos("o103"));
        assertTrue(IQStars.isOverhangingPos("o113"));
        assertTrue(IQStars.isOverhangingPos("o123"));
        assertTrue(IQStars.isOverhangingPos("o133"));
        assertTrue(IQStars.isOverhangingPos("o143"));
        assertTrue(IQStars.isOverhangingPos("o153"));

        //ORANGE - POSITION 2
        assertTrue(IQStars.isOverhangingPos("o200"));
        assertTrue(IQStars.isOverhangingPos("o201"));
        assertTrue(IQStars.isOverhangingPos("o210"));
        assertTrue(IQStars.isOverhangingPos("o202"));
        assertTrue(IQStars.isOverhangingPos("o212"));
        assertTrue(IQStars.isOverhangingPos("o203"));
        assertTrue(IQStars.isOverhangingPos("o213"));
        assertTrue(IQStars.isOverhangingPos("o223"));
        assertTrue(IQStars.isOverhangingPos("o233"));
        assertTrue(IQStars.isOverhangingPos("o243"));
        assertTrue(IQStars.isOverhangingPos("o253"));

        //ORANGE - POSITION 3
        assertTrue(IQStars.isOverhangingPos("o350"));
        assertTrue(IQStars.isOverhangingPos("o360"));
        assertTrue(IQStars.isOverhangingPos("o351"));
        assertTrue(IQStars.isOverhangingPos("o352"));
        assertTrue(IQStars.isOverhangingPos("o362"));
        assertTrue(IQStars.isOverhangingPos("o303"));
        assertTrue(IQStars.isOverhangingPos("o313"));
        assertTrue(IQStars.isOverhangingPos("o323"));
        assertTrue(IQStars.isOverhangingPos("o333"));
        assertTrue(IQStars.isOverhangingPos("o343"));
        assertTrue(IQStars.isOverhangingPos("o353"));

        //ORANGE - POSITION 4
        assertTrue(IQStars.isOverhangingPos("o400"));
        assertTrue(IQStars.isOverhangingPos("o402"));
        assertTrue(IQStars.isOverhangingPos("o412"));
        assertTrue(IQStars.isOverhangingPos("o422"));
        assertTrue(IQStars.isOverhangingPos("o432"));
        assertTrue(IQStars.isOverhangingPos("o442"));
        assertTrue(IQStars.isOverhangingPos("o452"));
        assertTrue(IQStars.isOverhangingPos("o462"));
        assertTrue(IQStars.isOverhangingPos("o403"));
        assertTrue(IQStars.isOverhangingPos("o413"));
        assertTrue(IQStars.isOverhangingPos("o423"));
        assertTrue(IQStars.isOverhangingPos("o433"));
        assertTrue(IQStars.isOverhangingPos("o443"));
        assertTrue(IQStars.isOverhangingPos("o453"));

        //ORANGE - POSITION 5
        assertTrue(IQStars.isOverhangingPos("o500"));
        assertTrue(IQStars.isOverhangingPos("o560"));
        assertTrue(IQStars.isOverhangingPos("o562"));
        assertTrue(IQStars.isOverhangingPos("o551"));
        assertTrue(IQStars.isOverhangingPos("o502"));
        assertTrue(IQStars.isOverhangingPos("o503"));
        assertTrue(IQStars.isOverhangingPos("o513"));
        assertTrue(IQStars.isOverhangingPos("o523"));
        assertTrue(IQStars.isOverhangingPos("o533"));
        assertTrue(IQStars.isOverhangingPos("o543"));
        assertTrue(IQStars.isOverhangingPos("o553"));
    }

    @Test
    public void yellowOverhanging() {
        //Ensures yellow overhanging pieces return true
        //YELLOW - ORIENTATION 0
        assertTrue(IQStars.isOverhangingPos("y050"));
        assertTrue(IQStars.isOverhangingPos("y060"));
        assertTrue(IQStars.isOverhangingPos("y041"));
        assertTrue(IQStars.isOverhangingPos("y051"));
        assertTrue(IQStars.isOverhangingPos("y052"));
        assertTrue(IQStars.isOverhangingPos("y062"));
        assertTrue(IQStars.isOverhangingPos("y003"));
        assertTrue(IQStars.isOverhangingPos("y013"));
        assertTrue(IQStars.isOverhangingPos("y023"));
        assertTrue(IQStars.isOverhangingPos("y033"));
        assertTrue(IQStars.isOverhangingPos("y043"));
        assertTrue(IQStars.isOverhangingPos("y053"));

        //YELLOW - ORIENTATION 1
        assertTrue(IQStars.isOverhangingPos("y100"));
        assertTrue(IQStars.isOverhangingPos("y160"));
        assertTrue(IQStars.isOverhangingPos("y151"));
        assertTrue(IQStars.isOverhangingPos("y102"));
        assertTrue(IQStars.isOverhangingPos("y112"));
        assertTrue(IQStars.isOverhangingPos("y122"));
        assertTrue(IQStars.isOverhangingPos("y132"));
        assertTrue(IQStars.isOverhangingPos("y142"));
        assertTrue(IQStars.isOverhangingPos("y152"));
        assertTrue(IQStars.isOverhangingPos("y162"));
        assertTrue(IQStars.isOverhangingPos("y103"));
        assertTrue(IQStars.isOverhangingPos("y113"));
        assertTrue(IQStars.isOverhangingPos("y123"));
        assertTrue(IQStars.isOverhangingPos("y133"));
        assertTrue(IQStars.isOverhangingPos("y143"));
        assertTrue(IQStars.isOverhangingPos("y153"));

        //YELLOW - ORIENTATION 2
        assertTrue(IQStars.isOverhangingPos("y260"));
        assertTrue(IQStars.isOverhangingPos("y251"));
        assertTrue(IQStars.isOverhangingPos("y202"));
        assertTrue(IQStars.isOverhangingPos("y212"));
        assertTrue(IQStars.isOverhangingPos("y222"));
        assertTrue(IQStars.isOverhangingPos("y232"));
        assertTrue(IQStars.isOverhangingPos("y242"));
        assertTrue(IQStars.isOverhangingPos("y252"));
        assertTrue(IQStars.isOverhangingPos("y262"));
        assertTrue(IQStars.isOverhangingPos("y203"));
        assertTrue(IQStars.isOverhangingPos("y213"));
        assertTrue(IQStars.isOverhangingPos("y223"));
        assertTrue(IQStars.isOverhangingPos("y233"));
        assertTrue(IQStars.isOverhangingPos("y243"));
        assertTrue(IQStars.isOverhangingPos("y253"));

        //YELLOW - ORIENTATION 3
        assertTrue(IQStars.isOverhangingPos("y300"));
        assertTrue(IQStars.isOverhangingPos("y310"));
        assertTrue(IQStars.isOverhangingPos("y360"));
        assertTrue(IQStars.isOverhangingPos("y301"));
        assertTrue(IQStars.isOverhangingPos("y302"));
        assertTrue(IQStars.isOverhangingPos("y312"));
        assertTrue(IQStars.isOverhangingPos("y362"));
        assertTrue(IQStars.isOverhangingPos("y303"));
        assertTrue(IQStars.isOverhangingPos("y313"));
        assertTrue(IQStars.isOverhangingPos("y323"));
        assertTrue(IQStars.isOverhangingPos("y333"));
        assertTrue(IQStars.isOverhangingPos("y343"));
        assertTrue(IQStars.isOverhangingPos("y353"));

        //YELLOW - ORIENTATION 4
        assertTrue(IQStars.isOverhangingPos("y450"));
        assertTrue(IQStars.isOverhangingPos("y460"));
        assertTrue(IQStars.isOverhangingPos("y451"));
        assertTrue(IQStars.isOverhangingPos("y402"));
        assertTrue(IQStars.isOverhangingPos("y412"));
        assertTrue(IQStars.isOverhangingPos("y422"));
        assertTrue(IQStars.isOverhangingPos("y432"));
        assertTrue(IQStars.isOverhangingPos("y442"));
        assertTrue(IQStars.isOverhangingPos("y452"));
        assertTrue(IQStars.isOverhangingPos("y462"));
        assertTrue(IQStars.isOverhangingPos("y403"));
        assertTrue(IQStars.isOverhangingPos("y413"));
        assertTrue(IQStars.isOverhangingPos("y423"));
        assertTrue(IQStars.isOverhangingPos("y433"));
        assertTrue(IQStars.isOverhangingPos("y443"));
        assertTrue(IQStars.isOverhangingPos("y453"));

        //YELLOW - ORIENTATION 5
        assertTrue(IQStars.isOverhangingPos("y500"));
        assertTrue(IQStars.isOverhangingPos("y501"));
        assertTrue(IQStars.isOverhangingPos("y502"));
        assertTrue(IQStars.isOverhangingPos("y512"));
        assertTrue(IQStars.isOverhangingPos("y522"));
        assertTrue(IQStars.isOverhangingPos("y532"));
        assertTrue(IQStars.isOverhangingPos("y542"));
        assertTrue(IQStars.isOverhangingPos("y552"));
        assertTrue(IQStars.isOverhangingPos("y562"));
        assertTrue(IQStars.isOverhangingPos("y503"));
        assertTrue(IQStars.isOverhangingPos("y513"));
        assertTrue(IQStars.isOverhangingPos("y523"));
        assertTrue(IQStars.isOverhangingPos("y533"));
        assertTrue(IQStars.isOverhangingPos("y543"));
        assertTrue(IQStars.isOverhangingPos("y553"));
    }

    @Test
    public void greenOverhanging() {
        // Ensures green overhanging positions return true
        // GREEN - ORIENTATION 0
        assertTrue(IQStars.isOverhangingPos("g050"));
        assertTrue(IQStars.isOverhangingPos("g060"));
        assertTrue(IQStars.isOverhangingPos("g041"));
        assertTrue(IQStars.isOverhangingPos("g051"));
        assertTrue(IQStars.isOverhangingPos("g002"));
        assertTrue(IQStars.isOverhangingPos("g012"));
        assertTrue(IQStars.isOverhangingPos("g022"));
        assertTrue(IQStars.isOverhangingPos("g032"));
        assertTrue(IQStars.isOverhangingPos("g042"));
        assertTrue(IQStars.isOverhangingPos("g052"));
        assertTrue(IQStars.isOverhangingPos("g062"));
        assertTrue(IQStars.isOverhangingPos("g003"));
        assertTrue(IQStars.isOverhangingPos("g013"));
        assertTrue(IQStars.isOverhangingPos("g023"));
        assertTrue(IQStars.isOverhangingPos("g033"));
        assertTrue(IQStars.isOverhangingPos("g043"));
        assertTrue(IQStars.isOverhangingPos("g053"));

        // GREEN - ORIENTATION 1
        assertFalse(IQStars.isOverhangingPos("g110"));
        assertFalse(IQStars.isOverhangingPos("g120"));
        assertFalse(IQStars.isOverhangingPos("g130"));
        assertFalse(IQStars.isOverhangingPos("g140"));
        assertFalse(IQStars.isOverhangingPos("g150"));

        // GREEN - ORIENTATION 2
        assertTrue(IQStars.isOverhangingPos("g200"));
        assertTrue(IQStars.isOverhangingPos("g210"));
        assertTrue(IQStars.isOverhangingPos("g220"));
        assertTrue(IQStars.isOverhangingPos("g201"));
        assertTrue(IQStars.isOverhangingPos("g211"));
        assertTrue(IQStars.isOverhangingPos("g202"));
        assertTrue(IQStars.isOverhangingPos("g212"));
        assertTrue(IQStars.isOverhangingPos("g222"));
        assertTrue(IQStars.isOverhangingPos("g203"));
        assertTrue(IQStars.isOverhangingPos("g213"));
        assertTrue(IQStars.isOverhangingPos("g223"));
        assertTrue(IQStars.isOverhangingPos("g233"));
        assertTrue(IQStars.isOverhangingPos("g243"));
        assertTrue(IQStars.isOverhangingPos("g253"));

        //Green - ORIENTATION 3
        assertFalse(IQStars.isOverhangingPos("g300"));
        assertFalse(IQStars.isOverhangingPos("g310"));
        assertFalse(IQStars.isOverhangingPos("g320"));
        assertFalse(IQStars.isOverhangingPos("g330"));
        assertFalse(IQStars.isOverhangingPos("g340"));
        assertFalse(IQStars.isOverhangingPos("g301"));
        assertFalse(IQStars.isOverhangingPos("g311"));
        assertFalse(IQStars.isOverhangingPos("g321"));
        assertFalse(IQStars.isOverhangingPos("g331"));

        //GREEN - ORIENTATION 4
        assertFalse(IQStars.isOverhangingPos("g410"));
        assertFalse(IQStars.isOverhangingPos("g420"));
        assertFalse(IQStars.isOverhangingPos("g430"));
        assertFalse(IQStars.isOverhangingPos("g440"));
        assertFalse(IQStars.isOverhangingPos("g450"));
        assertFalse(IQStars.isOverhangingPos("g460"));

        //GREEN - ORIENTATION 5
        assertTrue(IQStars.isOverhangingPos("g500"));
        assertTrue(IQStars.isOverhangingPos("g550"));
        assertTrue(IQStars.isOverhangingPos("g560"));
        assertTrue(IQStars.isOverhangingPos("g541"));
        assertTrue(IQStars.isOverhangingPos("g551"));
        assertTrue(IQStars.isOverhangingPos("g502"));
        assertTrue(IQStars.isOverhangingPos("g503"));
        assertTrue(IQStars.isOverhangingPos("g513"));
        assertTrue(IQStars.isOverhangingPos("g523"));
        assertTrue(IQStars.isOverhangingPos("g533"));
        assertTrue(IQStars.isOverhangingPos("g543"));
        assertTrue(IQStars.isOverhangingPos("g553"));
    }

    @Test
    public void blueOverhanging() {
        //Ensures Blue overhanging pieces return true
        //BLUE - ORIENTATION 0
        assertTrue(IQStars.isOverhangingPos("b050"));
        assertTrue(IQStars.isOverhangingPos("b060"));
        assertTrue(IQStars.isOverhangingPos("b041"));
        assertTrue(IQStars.isOverhangingPos("b051"));
        assertTrue(IQStars.isOverhangingPos("b052"));
        assertTrue(IQStars.isOverhangingPos("b062"));
        assertTrue(IQStars.isOverhangingPos("b003"));
        assertTrue(IQStars.isOverhangingPos("b013"));
        assertTrue(IQStars.isOverhangingPos("b023"));
        assertTrue(IQStars.isOverhangingPos("b033"));
        assertTrue(IQStars.isOverhangingPos("b043"));
        assertTrue(IQStars.isOverhangingPos("b053"));

        //BLUE - ORIENTATION 1
        assertFalse(IQStars.isOverhangingPos("b100"));
        assertFalse(IQStars.isOverhangingPos("b110"));
        assertFalse(IQStars.isOverhangingPos("b120"));
        assertFalse(IQStars.isOverhangingPos("b130"));
        assertFalse(IQStars.isOverhangingPos("b140"));
        assertFalse(IQStars.isOverhangingPos("b150"));
        assertFalse(IQStars.isOverhangingPos("b101"));
        assertFalse(IQStars.isOverhangingPos("b111"));
        assertFalse(IQStars.isOverhangingPos("b121"));
        assertFalse(IQStars.isOverhangingPos("b131"));
        assertFalse(IQStars.isOverhangingPos("b141"));

        //BLUE - ORIENTATION 2
        assertFalse(IQStars.isOverhangingPos("b220"));
        assertFalse(IQStars.isOverhangingPos("b230"));
        assertFalse(IQStars.isOverhangingPos("b240"));
        assertFalse(IQStars.isOverhangingPos("b250"));
        assertFalse(IQStars.isOverhangingPos("b260"));
        assertFalse(IQStars.isOverhangingPos("b211"));
        assertFalse(IQStars.isOverhangingPos("b221"));
        assertFalse(IQStars.isOverhangingPos("b231"));
        assertFalse(IQStars.isOverhangingPos("b241"));
        assertFalse(IQStars.isOverhangingPos("b251"));

        //BLUE - ORIENTATION 3
        assertTrue(IQStars.isOverhangingPos("b300"));
        assertTrue(IQStars.isOverhangingPos("b350"));
        assertTrue(IQStars.isOverhangingPos("b360"));
        assertTrue(IQStars.isOverhangingPos("b351"));
        assertTrue(IQStars.isOverhangingPos("b302"));
        assertTrue(IQStars.isOverhangingPos("b352"));
        assertTrue(IQStars.isOverhangingPos("b362"));
        assertTrue(IQStars.isOverhangingPos("b303"));
        assertTrue(IQStars.isOverhangingPos("b313"));
        assertTrue(IQStars.isOverhangingPos("b323"));
        assertTrue(IQStars.isOverhangingPos("b343"));
        assertTrue(IQStars.isOverhangingPos("b353"));

        //BLUE - ORIENTATION 4
        assertFalse(IQStars.isOverhangingPos("b400"));
        assertFalse(IQStars.isOverhangingPos("b410"));
        assertFalse(IQStars.isOverhangingPos("b420"));
        assertFalse(IQStars.isOverhangingPos("b430"));
        assertFalse(IQStars.isOverhangingPos("b440"));
        assertFalse(IQStars.isOverhangingPos("b450"));
        assertFalse(IQStars.isOverhangingPos("b401"));
        assertFalse(IQStars.isOverhangingPos("b411"));
        assertFalse(IQStars.isOverhangingPos("b421"));
        assertFalse(IQStars.isOverhangingPos("b431"));
        assertFalse(IQStars.isOverhangingPos("b441"));

        //BLUE - ORIENTATION 5
        assertFalse(IQStars.isOverhangingPos("b510"));
        assertFalse(IQStars.isOverhangingPos("b520"));
        assertFalse(IQStars.isOverhangingPos("b530"));
        assertFalse(IQStars.isOverhangingPos("b540"));
        assertFalse(IQStars.isOverhangingPos("b550"));
        assertFalse(IQStars.isOverhangingPos("b511"));
        assertFalse(IQStars.isOverhangingPos("b521"));
        assertFalse(IQStars.isOverhangingPos("b531"));
        assertFalse(IQStars.isOverhangingPos("b541"));
    }

    @Test
    public void indigoOverhanging() {
        //ensures indigo overhanging pieces return true
        //INDIGO - ORIENTATION 0
        assertTrue(IQStars.isOverhangingPos("i050"));
        assertTrue(IQStars.isOverhangingPos("i060"));
        assertTrue(IQStars.isOverhangingPos("i041"));
        assertTrue(IQStars.isOverhangingPos("i051"));
        assertTrue(IQStars.isOverhangingPos("i052"));
        assertTrue(IQStars.isOverhangingPos("i062"));
        assertTrue(IQStars.isOverhangingPos("i043"));
        assertTrue(IQStars.isOverhangingPos("i053"));

        //INDIGO - ORIENTATION 1
        assertFalse(IQStars.isOverhangingPos("i100"));
        assertFalse(IQStars.isOverhangingPos("i110"));
        assertFalse(IQStars.isOverhangingPos("i120"));
        assertFalse(IQStars.isOverhangingPos("i130"));
        assertFalse(IQStars.isOverhangingPos("i140"));
        assertFalse(IQStars.isOverhangingPos("i150"));
        assertFalse(IQStars.isOverhangingPos("i101"));
        assertFalse(IQStars.isOverhangingPos("i111"));
        assertFalse(IQStars.isOverhangingPos("i121"));
        assertFalse(IQStars.isOverhangingPos("i131"));
        assertFalse(IQStars.isOverhangingPos("i141"));

        //INDIGO - ORIENTATION 2
        assertFalse(IQStars.isOverhangingPos("i210"));
        assertFalse(IQStars.isOverhangingPos("i220"));
        assertFalse(IQStars.isOverhangingPos("i230"));
        assertFalse(IQStars.isOverhangingPos("i240"));
        assertFalse(IQStars.isOverhangingPos("i250"));
        assertFalse(IQStars.isOverhangingPos("i260"));
        assertFalse(IQStars.isOverhangingPos("i211"));
        assertFalse(IQStars.isOverhangingPos("i221"));
        assertFalse(IQStars.isOverhangingPos("i231"));
        assertFalse(IQStars.isOverhangingPos("i241"));
        assertFalse(IQStars.isOverhangingPos("i251"));
    }

    @Test
    public void pinkOverhanging() {
        //ensures overhanging pink pieces return true
        //PINK - ORIENTATION 0
        assertFalse(IQStars.isOverhangingPos("p000"));
        assertFalse(IQStars.isOverhangingPos("p010"));
        assertFalse(IQStars.isOverhangingPos("p020"));
        assertFalse(IQStars.isOverhangingPos("p030"));
        assertFalse(IQStars.isOverhangingPos("p040"));
        assertFalse(IQStars.isOverhangingPos("p001"));
        assertFalse(IQStars.isOverhangingPos("p011"));
        assertFalse(IQStars.isOverhangingPos("p021"));
        assertFalse(IQStars.isOverhangingPos("p031"));

        //PINK - ORIENTATION 1
        assertFalse(IQStars.isOverhangingPos("p110"));
        assertFalse(IQStars.isOverhangingPos("p120"));
        assertFalse(IQStars.isOverhangingPos("p130"));
        assertFalse(IQStars.isOverhangingPos("p140"));
        assertFalse(IQStars.isOverhangingPos("p150"));
        assertFalse(IQStars.isOverhangingPos("p111"));
        assertFalse(IQStars.isOverhangingPos("p121"));
        assertFalse(IQStars.isOverhangingPos("p131"));
        assertFalse(IQStars.isOverhangingPos("p141"));
        assertFalse(IQStars.isOverhangingPos("p151"));

        //PINK - ORIENTATION 2
        assertTrue(IQStars.isOverhangingPos("p250"));
        assertTrue(IQStars.isOverhangingPos("p260"));
        assertTrue(IQStars.isOverhangingPos("p241"));
        assertTrue(IQStars.isOverhangingPos("p251"));
        assertTrue(IQStars.isOverhangingPos("p252"));
        assertTrue(IQStars.isOverhangingPos("p262"));
        assertTrue(IQStars.isOverhangingPos("p203"));
        assertTrue(IQStars.isOverhangingPos("p213"));
        assertTrue(IQStars.isOverhangingPos("p223"));
        assertTrue(IQStars.isOverhangingPos("p233"));
        assertTrue(IQStars.isOverhangingPos("p243"));
        assertTrue(IQStars.isOverhangingPos("p253"));

        //PINK - ORIENTATION 3
        assertFalse(IQStars.isOverhangingPos("p310"));
        assertFalse(IQStars.isOverhangingPos("p320"));
        assertFalse(IQStars.isOverhangingPos("p330"));
        assertFalse(IQStars.isOverhangingPos("p340"));
        assertFalse(IQStars.isOverhangingPos("p350"));
        assertFalse(IQStars.isOverhangingPos("p301"));
        assertFalse(IQStars.isOverhangingPos("p311"));
        assertFalse(IQStars.isOverhangingPos("p321"));
        assertFalse(IQStars.isOverhangingPos("p331"));
        assertFalse(IQStars.isOverhangingPos("p341"));

        //PINK - ORIENTATION 4
        assertFalse(IQStars.isOverhangingPos("p410"));
        assertFalse(IQStars.isOverhangingPos("p420"));
        assertFalse(IQStars.isOverhangingPos("p430"));
        assertFalse(IQStars.isOverhangingPos("p440"));
        assertFalse(IQStars.isOverhangingPos("p450"));
        assertFalse(IQStars.isOverhangingPos("p401"));
        assertFalse(IQStars.isOverhangingPos("p411"));
        assertFalse(IQStars.isOverhangingPos("p421"));
        assertFalse(IQStars.isOverhangingPos("p431"));
        assertFalse(IQStars.isOverhangingPos("p441"));

        //PINK - ORIENTATION 5
        assertTrue(IQStars.isOverhangingPos("p500"));
        assertTrue(IQStars.isOverhangingPos("p550"));
        assertTrue(IQStars.isOverhangingPos("p560"));
        assertTrue(IQStars.isOverhangingPos("p551"));
        assertTrue(IQStars.isOverhangingPos("p502"));
        assertTrue(IQStars.isOverhangingPos("p503"));
        assertTrue(IQStars.isOverhangingPos("p513"));
        assertTrue(IQStars.isOverhangingPos("p523"));
        assertTrue(IQStars.isOverhangingPos("p533"));
        assertTrue(IQStars.isOverhangingPos("p543"));
        assertTrue(IQStars.isOverhangingPos("p553"));
    }
}
