package com.company;

import org.junit.jupiter.api.Test;

import static com.company.Rovar.derov;
import static com.company.Rovar.enrov;
import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class RovarTesting {
        @Test
        public void testEnrov() {
            // Test with non-empty string and all characters
            assertEquals("abobcocdodefofgoghohijojkoklolmom", enrov("abcdefghijklm"));

        }
        @Test
        public void testEnrovSecond(){
            assertEquals("nonopopqoqrorsostotuvovwowxoxyzozåäö", enrov("nopqrstuvwxyzåäö"));
        }

        @Test
        public void testEnroovUppercase(){
            assertEquals("ABoBCoCDoDEFoFGoGHoHIJoJKoKLoLMoM", enrov("ABCDEFGHIJKLM"));
        }

        @Test
        public void testEnrovUppercaseSecond(){
            assertEquals("NoNOPoPQoQRoRSoSToTUVoVWoWXoXYZoZÅÄÖ", enrov("NOPQRSTUVWXYZÅÄÖ"));
        }

        @Test
        public void testEnrovString(){
            assertEquals("123456789", enrov("123456789"));
        }
        @Test
        public void testEnrovSpecialCharacters(){
            assertEquals(".,;:!?()[]{}+-/%&", enrov(".,;:!?()[]{}+-/%&"));

        }
        @Test
        public void testEnrovEmptyString() {
            // Test with empty string
            assertEquals(" ", enrov(" "));
        }
        @Test
        public void testEnrovNull() {
            // Test with null
            assertNull(enrov(null));
        }


        // DEROV TESTS
        @Test
        public void testDerov() {
            assertEquals("abcdefghijklm", derov("abobcocdodefofgoghohijojkoklolmom"));
        }

        @Test
        public void testDerovSecond(){
            assertEquals("nopqrstuvwxyzåäö", derov("nonopopqoqrorsostotuvovwowxoxyzozåäö"));
        }

        @Test
        public void testDerovUppercase(){
            assertEquals("ABCDEFGHIJKLM", derov("ABoBCoCDoDEFoFGoGHoHIJoJKoKLoLMoM"));
        }

        @Test
        public void testDerovUpercaseSecond() {
            // Test with empty string
            assertEquals("NOPQRSTUVWXYZÅÄÖ", derov("NoNOPoPQoQRoRSoSToTUVoVWoWXoXYZoZÅÄÖ"));
        }

        @Test
        public void testDerovSpecial(){
            assertEquals(".,;:!?()[]{}+-/%&", derov(".,;:!?()[]{}+-/%&"));
        }

        @Test
        public void testDerovEmptyString(){
            assertEquals(" ", derov(" "));
        }

        @Test
        public void testDerovNull(){
            assertNull(enrov(null));
        }



}