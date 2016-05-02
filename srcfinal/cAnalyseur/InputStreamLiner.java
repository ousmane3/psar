package cAnalyseur;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe fournit une méthode readLine() pour les InputStream.
 * Il y a en fait trois méthodes (readLineWin, readLineUnix et
 * readLineMac). En effet, selon le système le séparateur de ligne est :
 * - Unix : 0x0A
 * - Windows : 0x0D 0x0A
 * - Mac : 0x0D
 * 
 * Cette classe est une alternative simple
 * au couple InputStreamReader+BufferedReader.
 * De plus, ce couple pose problème si l'on souhaite continuer
 * à lire le flux en mode binaire. En effet BufferedReader :
 * - est bufférisé et lit en avance des octets,
 * - ces octets sont interprétés comme des caractères en fonction
 *   d'un encodage (éventuellement par défaut, i.e. ISO-machin),
 * - il est compliqué de désinterpréter cet encodage pour retrouver
 *   les octets bruts initiaux.
 * 
 * @author Lionel Seinturier <Lionel.Seinturier@lip6.fr>
 * @version 1.0
 */
public class InputStreamLiner extends FilterInputStream {
    
    public InputStreamLiner(InputStream in) {
        super(in);
    }
    
    final static public int UNIX = 0;
    final static public int WIN = 1;
    final static public int MAC = 2;
    
    /**
     * Méthode générale de lecture d'une ligne.
     * En fonction du paramètre typeFichier, la lecture effective est
     * sous-traitée à une des trois autres méthodes de la classe.
     * 
     * @param typeFichier  énuméré valant soit UNIX, soit WIN, soit MAC 
     */
    public String readLine( int typeFichier ) throws IOException {
        switch(typeFichier) {
            case UNIX : return readLineUnix();
            case WIN : return readLineWin();
            case MAC : return readLineMac();
            default :
                throw new IllegalArgumentException(
                            "Valeur "+typeFichier+" interdite");
        }
    }
    

    /**
     * Lit une ligne sous Unix
     * (i.e. jusqu'à la prochaine occurrence de 0x0A).
     * 
     * @return  les octets lus (à l'exclusion de 0x0A) sous forme de String
     *          null si la fin du flux est atteinte
     */
    public String readLineUnix() throws IOException {
        
        int b = read();
        if (b==-1)  return null;
        
        buffer.clear();
        while ( b!=-1 && b!=0x0A ) {
            buffer.add(new Integer(b));
            b = read();
        }
        return bufferContent();
    }
    
    /**
     * Lit une ligne sous Windows
     * (i.e. jusqu'à la prochaine occurrence de 0x0D 0x0A).
     * 
     * @return  les octets lus (à l'exclusion de 0x0D 0x0A) sous forme de String
     *          null si la fin du flux est atteinte
     */
    public String readLineWin() throws IOException {
        
        buffer.clear();
        boolean first = true;
        
        while (true) {
            
            int b = read();
            if (b==-1) {
                if (first)  return null;
                return bufferContent();
            }
            first = false;
        
            if ( b == 0x0D ) {
                b = read();
                if ( b==-1 || b==0x0A )
                    return bufferContent();
                buffer.add(new Integer(0x0D));
                buffer.add(new Integer(b));
            }
            else
                buffer.add(new Integer(b));
        }
    }
    
    /**
     * Lit une ligne sous Mac
     * (i.e. jusqu'à la prochaine occurrence de 0x0D).
     * 
     * @return  les octets lus (à l'exclusion de 0x0D) sous forme de String
     *          null si la fin du flux est atteinte
     */
    public String readLineMac() throws IOException {
        
        int b = read();
        if (b==-1)  return null;
        
        buffer.clear();
        while ( b!=-1 && b!=0x0D ) {
            buffer.add(new Integer(b));
            b = read();
        }
        return bufferContent();
    }
    

    /** Buffer pour stocker les données de la ligne (sous forme d'Integer). */
    private List<Integer> buffer = new ArrayList<Integer>();

    /** @return  le contenu du buffer sous forme de String. */
    private String bufferContent() {
        
        Integer[] content = (Integer[]) buffer.toArray(integerArray);
        byte[] b = new byte[content.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = content[i].byteValue();
        }
        
        return new String(b);
    }
    
    /** Variable de travail pour bufferContent(). */
    final static private Integer[] integerArray = new Integer[0];
}
