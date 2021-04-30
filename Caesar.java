/**
 * Die Caesar-Verschlüsselung
 */
public class Caesar
{
    public Caesar()
    {
        String text = "Reglvmglx er Gmgivs! Mgl, iyiv sfivwxiv Fijilpwlefiv, lefi iygl rmglx zivkiwwir yrh aimß zsr iyviv Peki. Lepxix rsgl imri aimpi wxerh yrh zivxveyx eyj iyvi Wxeivoi. Wglsr feph aivhir aimxivi Xvyttir dy iygl wxsßir, daim Pikmsrir wmrh fivimxw eyj hiq Aik. Kemyw Nypmyw Geiwev";
        char[] geheimtext = text.toCharArray();
        haeufigkeitsanalyse(geheimtext);
    }

    public int[] haeufigkeitsanalyse(char[] geheimtext) {
        int[] buchstabenzaehler = new int[128];
        for(int i=0; i < geheimtext.length; i++){
            int asciicode = (int)geheimtext[i];
            buchstabenzaehler[asciicode]++;
        }
        return buchstabenzaehler;
    }

    public void analyseAusgabe(int[] buchstabenzaehler) {
        for (int ascii=0; ascii < buchstabenzaehler.length; ascii++) {
            char buchstabe = (char)ascii;
            System.out.println("Anzahl von " + buchstabe + " ist " + buchstabenzaehler[ascii]); 
        }
    }

    /* public int prozentAusgabe(int[] buchstabenzaehler, ){
    for (int ascii=0; ascii < buchstabenzaehler.length; ascii++) {
    int prozent = ((buchstabenzaehler[ascii] * 100)/textlaenge);

    }
    } */

    public char[] verschluesseln(char[] klartext, int schluessel){
        char[] geheimtext = new char[klartext.length];

        for(int i = 0; i < klartext.length; i++){
            int verschiebung = klartext[i] + schluessel;
            if (verschiebung >= 128) {
                verschiebung -= 128;
            }
            geheimtext[i] = (char) verschiebung;
        }

        return geheimtext;
    }

    public char[] entschluesseln(char[] geheimtext, int schluessel){
        char[] klartext = new char[geheimtext.length];

        for(int i = 0; i < geheimtext.length; i++){
            int verschiebung = geheimtext[i] - schluessel;
            if (verschiebung < 0) {
                verschiebung += 128;
            }
            klartext[i] = (char) verschiebung;
        }

        return klartext;
    }

    public static void main(String[] args) {
        System.out.println("Hallo");
    }

}
