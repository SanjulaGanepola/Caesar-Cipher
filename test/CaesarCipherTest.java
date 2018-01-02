/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static caesar.ciphers.CaesarCipher.decode;
import static caesar.ciphers.CaesarCipher.encode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rohitha
 */
public class CaesarCipherTest {

    public CaesarCipherTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    //Test the encode method
    @Test
    public void encodeTest() {
        assertEquals("!@# BcDe $%^  &*( xYzA )_+", encode("!@# AbCd $%^  &*( wXyZ )_+", 1));
        assertEquals(" 1z A b C1   2V wX y2", encode(" 1a B c D1   2W xY z2", -1));
        assertEquals("~g  ikmoqsuwyace|", encode("~a  cegikmoqsuwy|", 500));
        assertEquals("9prtvxzbdfhjln~", encode("9bdfhjlnprtvxz~", -1000));
    }

    //Test the decode method
    @Test
    public void decodeTest() {
        assertEquals("!@# zAbC $%^  &*( VwXy )_+", decode("!@# aBcD $%^  &*( WxYz )_+", 1));
        assertEquals(" 3B c D e3   4x Yz A4", decode(" 3A b C d3   4w Xy Z4", -1));
        assertEquals(".u<o m v e n x m>t.", decode(".a<u s b k t d s>z.", 500));
        assertEquals("n>m4ps..2rs6<k", decode("b>a4dg..2fg6<y", -1000));
    }
}
