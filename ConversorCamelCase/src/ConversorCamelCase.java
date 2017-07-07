import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class ConversorCamelCase {
	private List<String> listaResposta;
	private Pattern pattern;	

	public ConversorCamelCase() {
		listaResposta = new ArrayList<String>();
		pattern = Pattern.compile("([A-Z][a-z]+)|([a-z]+)|([A-Z]+(?![a-z]+))|([0-9]+)");
	}

	public List<String> converterCamelCase(String string) {
		if(string.isEmpty()) {
			listaResposta.add("");
		} else {	
			verificaValidadeString(string);
			Matcher matcher = pattern.matcher(string);
			while(matcher.find())
				listaResposta.add(formataResposta(matcher.group(0)));
		}
		return listaResposta;
	}

	private String formataResposta(String string) {
		if(!inteiraMaiuscula(string)) {
			return string.toLowerCase();
		} else {
			return string;
		}
		
	}
	
	private boolean inteiraMaiuscula(String string) {
		return string.toUpperCase().equals(string);
	}
	
	private boolean comecaComNumero(String string) {
		char[] firstCharacter = new char[1];
		string.getChars(0, 1, firstCharacter, 0);
		return (firstCharacter[0] > '0' && firstCharacter[0] < '9');
	}
	
	private boolean contemCaracteresEspeciais(String string) {
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
		Matcher matcher = pattern.matcher(string);
		return matcher.find();
	}

	private void verificaValidadeString(String string){
		if (comecaComNumero(string)) {
			throw new CamelCaseInvalidoException("Nao pode comecar com numeros");
		} else if (contemCaracteresEspeciais(string)) {
			throw new CamelCaseInvalidoException("Nao pode conter caracteres especiais");
		}
	}
}
