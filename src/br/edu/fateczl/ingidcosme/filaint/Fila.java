package br.edu.fateczl.ingidcosme.filaint;

public class Fila {

		No inicio;
		No fim;
	
		
		public Fila() {
			inicio = null;
			fim = null;
			
		}
		
		public boolean isEmpty() {
			if(inicio == null && fim == null) {
				return true;
			} else {
				return false;
			}
		}
	
		public void insert(int valor) {
			No elemento = new No();
			elemento.dado = valor;
			
			if(inicio == null) {
				inicio = elemento;
				fim = elemento;
				elemento.proximo = null;
			} else {
				if(inicio == fim && inicio != null) {
					fim = elemento;
					inicio.proximo = fim;
					fim.proximo = null;
				} else {
					fim.proximo = elemento;
					elemento.proximo = null;
					fim = elemento;
				}
			}
		}
		
		public int remove() throws Exception {
			if(isEmpty()) {
				throw new Exception("Fila vazia");
			}
			No auxiliar = inicio;
			if(inicio == fim && inicio != null) {
				inicio = null;
				fim = null;
			} else {
				inicio = inicio.proximo;
			}
			return auxiliar.dado;
		}

		public void list() throws Exception {
			if(isEmpty()) {
				throw new Exception("Fila vazia");
			}
			No auxiliar = inicio;
			while(auxiliar != null) {
				System.out.print(auxiliar.toString() + " ==> ");
				auxiliar = auxiliar.proximo;
			}
			System.out.print("NULL");
			System.out.println("");
		}
		
		public int size() {
			int cont = 0;
			if(!isEmpty()) {
				No auxiliar = inicio;
				while(auxiliar != null) {
					cont++;
					auxiliar = auxiliar.proximo;
				}
			}
			return cont;
		}
		
		public int get(int posicao) throws Exception {
			if(isEmpty()) {
				throw new Exception("Fila vazia");
			}
			if(posicao < 0) {
				throw new Exception("Posição inválida");
			}
			int tamanho = size();
			if(posicao > tamanho - 1) {
				throw new Exception("Posição inexistente");
			}
			int cont = 0;
			No auxiliar = inicio;
			while(cont < posicao) {
				auxiliar = auxiliar.proximo;
				cont++;
			}
			return auxiliar.dado;
		}
		
		@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer();
			int tamanho = size();
			try {
				for(int i = 0; i < tamanho ; i++) {
					buffer.append("[");
					buffer.append(get(i));
					buffer.append("]");
					buffer.append("[]->");
					if(i == tamanho - 1) {
						buffer.append("NULL");
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return buffer.toString();
		}
}
