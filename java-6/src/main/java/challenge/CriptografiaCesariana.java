package challenge;

import java.time.format.SignStyle;
import java.util.Locale;

/*
***************************************************************************************************
***  REFERÊNCIAS                                                                                ***
***  1. Conteúdo da Codenation                                                                  ***
***  2. https://www.devmedia.com.br/trabalhando-com-excecoes-em-java/27601                      ***
***                                                                                             ***
***  DATA DE INÍCIO                     DATA DE TÉRMINO                                         ***
***  14/02/2021                         16/02/2021                                              ***
***                                                                                             ***
***  DIFICULDADES                                                                               ***
***  Não consegui fazer passar no teste usando o Try/Catch                                      ***
***************************************************************************************************
 */

public class CriptografiaCesariana implements Criptografia {

    public void verifyExistExceptions(String text) {
        if (text == null) {
            NullPointerException error = new NullPointerException("Texto nulo");
            throw error;
        }
        if (text.isEmpty()) {
            IllegalArgumentException error = new IllegalArgumentException("Texto vazio");
            throw error;
        }
    }

    public String encripty(String text, boolean isEncripty) {
        verifyExistExceptions(text);
        int addAscii = 3;
        int addCode = -3;
        if (isEncripty) {
            addAscii = 0;
            addCode = 3;
        }
        String encoding = "";
        // A ideia de converter o texto para minusculo foi retirada do código do @Nando T7
        for (char c: text.toLowerCase().toCharArray()) {
            int code = (int) c;
            if (code >= (97 + addAscii) && code <= (122 + addAscii)) {
                code += addCode;
            }
            encoding += (char) code;
        }
        return(encoding);
    }

    @Override
    public String criptografar(String texto) {
        return(encripty(texto, true));
    }

    @Override
    public String descriptografar(String texto) {
        return(encripty(texto, false));
    }

    public static void  main(String[] args) {
        Criptografia express = new CriptografiaCesariana();
        String cript = express.criptografar("A ligeira raposa marrom saltou sobre o cachorro cansado");
        System.out.println(cript);
        express.

        String decript = express.descriptografar(cript);
        System.out.println(decript);
    }
}
